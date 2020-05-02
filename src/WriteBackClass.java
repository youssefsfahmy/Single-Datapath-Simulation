import javafx.beans.binding.IntegerBinding;


public class WriteBackClass {
	
	static String ALUresult;
	static String ReadData;
	
	static String WriteData;
	public static void WriteBack(){
		
		System.out.println("------------------------Performing Write Back------------------------");

		ALUresult= ExecuteClass.ALUresult;
		ReadData = MemoryAccess.ReadData;
		
		String WriteLocation= InstructionDecode.writeRegister;
		
		if(InstructionDecode.controlRegWrite){
		if(InstructionDecode.controlMemtoReg){
			System.out.println("Setting Register no: " + Integer.parseInt(WriteLocation,2) + " ,with address: "+ WriteLocation + " with the Read Data: " + ReadData + " from the memory");
			RegisterFile.setRegister(ReadData, WriteLocation);
			
		}else{
			System.out.println("Setting Register no: " + Integer.parseInt(WriteLocation,2) + " ,with address: "+ WriteLocation + " with the ALU result: " + ALUresult + " from ALU");
			RegisterFile.setRegister(ALUresult, WriteLocation);
		}
		}
		else{
			 System.out.println("No write back occured");

		}
		System.out.println();
		
		
	}

}

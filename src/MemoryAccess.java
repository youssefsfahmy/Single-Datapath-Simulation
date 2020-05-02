
public class MemoryAccess {
		static String Address;
		static String WriteData;
		
		static String ReadData;
		
	public static void memAccess(){
		
		System.out.println("------------------------Performing Memory Access------------------------");
		
		Address = ExecuteClass.ALUresult;
		WriteData = InstructionDecode.readData2;
		
		if(InstructionDecode.controlMemRead){
			ReadData=DataMemory.getData(Address);
			System.out.println("Reading Data from memory no: "+ Integer.parseInt(Address, 2) +" with address: " + Address);
			System.out.println("The Data read is: " + ReadData);


		}else if(InstructionDecode.controlMemWrite){
			
			System.out.println("Writing the Data: " + WriteData +  " ,at memory no: "+ Integer.parseInt(Address, 2) +" with address: " + Address);

			 DataMemory.setData(WriteData, Address);
			 
		}else{
			 System.out.println("No memory access occured");
		}
		
		
		
		System.out.println();
		
	}

}

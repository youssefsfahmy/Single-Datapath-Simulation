import java.util.ArrayList;


public class Engine {
	
	public static String to32Bits(String old){
		
		String thirtyTwoBit = old;
		for(int n=thirtyTwoBit.length(); n<32; n++) {
				thirtyTwoBit = "0" + thirtyTwoBit;
			
		}
		return thirtyTwoBit;
	}
	
	public static void main(String[]Args){
		
		ArrayList<String>instructions=new ArrayList<String>();
		
		//add
//		RegisterFile.arrRegister[17]=to32Bits(Integer.toBinaryString(10));
//		RegisterFile.arrRegister[18]=to32Bits(Integer.toBinaryString(5));
//		instructions.add("00000010001100101000000000100000");
//		
		//sub
//		RegisterFile.arrRegister[3]=to32Bits(Integer.toBinaryString(-2));
//		RegisterFile.arrRegister[2]=to32Bits(Integer.toBinaryString(10));
//		instructions.add("00000000011000100001100000100010");

		
		//load
//		DataMemory.dataList[4]="1111";
//		RegisterFile.arrRegister[1]=to32Bits(Integer.toBinaryString(0));
//		RegisterFile.arrRegister[2]=to32Bits(Integer.toBinaryString(2));
//		instructions.add("10001100001000110000000000000100");
		
//		//store
//		RegisterFile.arrRegister[1]=to32Bits(Integer.toBinaryString(3));
//		RegisterFile.arrRegister[2]=to32Bits(Integer.toBinaryString(3));
//		instructions.add("10101100001000100000000000000101");
		
		//beq
//		RegisterFile.arrRegister[8]="00000000000000000000000000000000";
//		RegisterFile.arrRegister[0]="00000000000000000000000000000000";
//		instructions.add("00010001000000000000000000000101");
		
		
		//error instruction
//		instructions.add("10101000000000000000000000000001");
		
		InstructionMemory.loadInstructions(instructions); // this method runs the data path (loads and executes all instructions)
		
		
	}

}

import java.util.ArrayList;

public class InstructionMemory {
	static String pC="0";
	static int pCInt=0;
	private static ArrayList<String> pInstructions;
	
	public InstructionMemory() {
		pC="00000000000000000000000000000000";
	}

	public static String getInstruction(String pCAddress){
		pCInt = Integer.parseInt(pCAddress,2);
		if(pCInt>=pInstructions.size()){
			return null;
		}
		else{
			return pInstructions.get(pCInt);
		}
	}
	
	public static void loadInstructions(ArrayList<String> Instructions){
		pInstructions = new ArrayList<String>();
		
		for(int i=0;i<Instructions.size();i++) {
			if(Instructions.get(i).length()==32)
			pInstructions.add(Instructions.get(i));
			else {
				System.out.println("Wrong Instruction length at index " +i);
				System.out.println("The program will now end");
				return;
			}
		}
		
		
		System.out.println("Intructions are now loaded to the instruction memory");
		boolean done = false;
		
		while(done==false) {
		
			System.out.println("The PC is " +pCInt);
			

			String CurrentInstruction = InstructionFetch.InstFetch(pC);

			if(CurrentInstruction==null){
				
			System.out.println("PROGRAM FINISHED EXECUTING");
				done= true;
			}else{
			System.out.println("The program counter after decoding is " + pCInt);
			
			System.out.println("===================================================================");
			}
		}
		

	}
//	
//	public static void main(String[] args){
//		
//		DataMemory data = new DataMemory();
//		RegisterFile registerfile=new RegisterFile();
//
//		ArrayList<String>instructions=new ArrayList<String>();
//		
//		//add
////		registerfile.arrRegister[17]=Integer.toBinaryString(10);
////		registerfile.arrRegister[18]=Integer.toBinaryString(5);
////		instructions.add("00000010001100101000000000100000");
//		
//		//sub
////		instructions.add("00000000011000100001100000100010");
////		registerfile.arrRegister[3]=Integer.toBinaryString(2);
////		registerfile.arrRegister[2]=Integer.toBinaryString(10);
//		
//		//load
////		registerfile.arrRegister[1]=Integer.toBinaryString(0);
////		registerfile.arrRegister[2]=Integer.toBinaryString(2);
////		instructions.add("10001100001000110000000000000100");
//		
//		//store
////		registerfile.arrRegister[1]=Integer.toBinaryString(3);
////		registerfile.arrRegister[2]=Integer.toBinaryString(3);
////		instructions.add("10101100001000100000000000000101");
//		
//		//beq
////		registerfile.arrRegister[8]="00000000000000000000000000000000";
////		instructions.add("00010001000000000000000000000101");
//		
//		//Jump
////		instructions.add("00001000000000000000000000000001");
//		
//		//error instruction
////		instructions.add("10101000000000000000000000000001");
//
//		
//		
//		
//
//		
//		
//		InstructionMemory instMem= new InstructionMemory(instructions);
//
//		
//		instMem.begin(data,registerfile );
//
//				
//	}
	
	
	

}


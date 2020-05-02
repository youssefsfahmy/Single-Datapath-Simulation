
public class InstructionFetch {
	
	
	public static String InstFetch(String pCAddress){
		
		System.out.println("---------------------Fetching instruction---------------------");

		String curInstruction = InstructionMemory.getInstruction(pCAddress);
		
		if(curInstruction==null){
			return curInstruction;
		}
		else{
			System.out.println("Instruction successfully fetched");
			InstructionDecode.InstDecode(curInstruction);
			ExecuteClass.Execute();
			MemoryAccess.memAccess();
			WriteBackClass.WriteBack();
		}
		
		ProgCounter(pCAddress);
		
		return curInstruction;
		
	}
	
	public static void ProgCounter(String pCAddress){
		String nextpC;
		int pcInt;
		
		if(InstructionDecode.controlBranch && ExecuteClass.ALUZero){
			System.out.println("--------------A JUMP HAS OCCURRED--------------");
			
			pcInt = Integer.parseInt(pCAddress,2);
			String branch=InstructionDecode.signExtend;//
			int branchpCInt = Integer.parseInt(branch,2);
			pcInt++;
			
			System.out.println("The PC regularly incremented by 1 is:" + pcInt);
			pcInt=branchpCInt+pcInt;
			
			System.out.println("The PC after jump is:" + pcInt);
			
			nextpC=(Integer.toBinaryString(pcInt));
			for(int n=nextpC.length(); n<32; n++) {
			                        nextpC = "0" + nextpC;
			}
			if(InstructionMemory.getInstruction(nextpC)==null){
				System.out.println("This location of the jump DOES NOT EXIST");
				
			}
			System.out.println();

		}
		else{
			pcInt = Integer.parseInt(pCAddress,2);
			pcInt++;
			
			nextpC=(Integer.toBinaryString(pcInt));
			for(int n=nextpC.length(); n<32; n++) {
			                        nextpC = "0" + nextpC;
			}
		}
		
		InstructionMemory.pC=nextpC;
		InstructionMemory.pCInt=pcInt;
		
	}

}

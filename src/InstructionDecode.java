
public class InstructionDecode {
	static boolean controlRegDst;
	static boolean controlBranch;
	static boolean controlMemRead;
	static boolean controlMemtoReg;
	static boolean controlALUOp1;
	static boolean controlALUOp0;
	static boolean controlMemWrite;
	static boolean controlALUSrc;
	static boolean controlRegWrite;
	
	
	static String opCode;
	static String readRegister1;
	static String readRegister2;
	static String writeRegister;
	
	
	
	static String signExtend;
	static String func;
	static String readData1;
	static String readData2;
	static String ALUOP;
	
	
	public static void InstDecode(String instruction){
		System.out.println();
		System.out.println("---------------------Starting decoding now---------------------");
		
		
		opCode = instruction.substring(0, 6);
		func=instruction.substring(26, 32);

		
		ContUnit(opCode);
		String immValue;
		
		readRegister1 = instruction.substring(6, 11);
		
		readRegister2= instruction.substring(11, 16);
		
		if(controlRegDst){
			writeRegister= instruction.substring(16, 21);
		}else{
			writeRegister= instruction.substring(11, 16);
		}
		
		
		immValue=instruction.substring(16, 32);
		
		signExtend= SignExtend(immValue);
		
		
		readData1= RegisterFile.getRegister(readRegister1);
		readData2= RegisterFile.getRegister(readRegister2);
		
		System.out.println("Loading Register no: " + (int)Long.parseLong(readRegister1,2) + " ,with address: "+ readRegister1);
		System.out.println("ReadData1 = " + readData1);
		System.out.println("Loading Register no: " + (int)Long.parseLong(readRegister2,2) + " ,with address: "+ readRegister2);
		System.out.println("ReadData2 = "+ readData2 );
		System.out.println("SignExtend = "+ signExtend +" ,with value of: " + (int)Long.parseLong(signExtend,2));
	}
		
	
	
	public static String SignExtend(String sixteenbit){
		
		String thirtyTwoBit = sixteenbit;
		for(int n=thirtyTwoBit.length(); n<32; n++) {
			if(thirtyTwoBit.startsWith("0")){
				thirtyTwoBit = "0" + thirtyTwoBit;
			}
			else{
				thirtyTwoBit = "1" + thirtyTwoBit;
			}
		}
		return thirtyTwoBit;
	}
	
	
	
	public static String ContUnit(String opCode){
		System.out.println("Control Unit:");
		if(opCode.equals("000000")) {//R-Type
			
			 controlRegDst=true;
			 controlBranch=false;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlALUOp1=true;
			 controlALUOp0=false;
			 controlMemWrite=false;
			 controlALUSrc=false;
			 controlRegWrite=true;
					}
		else if(opCode.equals("100011")) {//Load inst
			
			controlRegDst=false;
			 controlBranch=false;
			 controlMemRead=true;
			 controlMemtoReg=true;
			 controlALUOp1=false;
			 controlALUOp0=false;
			 controlMemWrite=false;
			 controlALUSrc=true;
			 controlRegWrite=true;

		}
		else if(opCode.equals("101011")) {//Store inst
			
			
			controlRegDst=true; //x
			 controlBranch=false;
			 controlMemRead=false;
			 controlMemtoReg=true; // x
			 controlALUOp1=false;
			 controlALUOp0=false;
			 controlMemWrite=true;
			 controlALUSrc=true;
			 controlRegWrite=false;


		}
		else if(opCode.equals("000100")) {//beq inst
			controlRegDst=true; //x
			 controlBranch=true;
			 controlMemRead=false;
			 controlMemtoReg=true; //x
			 controlALUOp1=false;
			 controlALUOp0=true;
			 controlMemWrite=false;
			 controlALUSrc=false;
			 controlRegWrite=false;

			
		}
		else{
			System.out.println("This opCode instruction" + opCode + "does not exist");
		}
		
		System.out.println("Main Control bits are set successfully");
		System.out.println("[ controlRegDst:"+controlRegDst+
				" ,controlBranch:"+controlBranch+
				" ,controlMemRead:"+controlMemRead+
				" ,controlMemtoReg:"+controlMemtoReg+
				" ,controlALUOp1:"+controlALUOp1+
				" ,controlALUOp:"+controlALUOp0+
				" ,controlMemWrite:"+controlMemWrite+
				" ,controlALUSrc:"+controlALUSrc
				+" ,controlRegWrite:" +controlRegWrite+" ] ");
		System.out.println();
		
		
		ALUOP="";
		
		if(!controlALUOp1 && !controlALUOp0){//ADD
			ALUOP="0010";
		}
		else if(!controlALUOp1 && controlALUOp0 ){//SUB
			ALUOP="0110";
		}
		else if(controlALUOp1 && !controlALUOp0){//func
			switch(func) {
			case "100000": ALUOP = "0010";break;
			case "100010": ALUOP = "0110";break;
			case "100100": ALUOP = "0000";break;
			case "100101": ALUOP = "0001";break;
			case "101010": ALUOP = "0111";break;
			default: ALUOP = "111111";
			}
		}
		
		System.out.println("ALU Controle set successfully and ALUOP= " + ALUOP);
		System.out.println();
		
		
		return ALUOP;
	}
	

}

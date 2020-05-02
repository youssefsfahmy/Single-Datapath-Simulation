
import java.util.Scanner;

public class ExecuteClass {
	static String Operand1;
	static String Operand2;
	static String Op;
	
	
	static boolean ALUZero;
	static String ALUresult;

	public static String Execute() {
		
		
		Op= InstructionDecode.ALUOP;
		
		Operand1 = InstructionDecode.readData1;
		
		if(InstructionDecode.controlALUSrc){
			Operand2 = InstructionDecode.signExtend;
		}
		else{
			Operand2 = InstructionDecode.readData2;
		}
		
		System.out.println();
		System.out.println("---------------------Begin ALU operation (Execute)---------------------");
		System.out.println("Input");
		System.out.println("1st Operand: " + Operand1 );
		System.out.println("2nd Operand: " + Operand2 );
		System.out.println("Operation: " + Op);
		System.out.println();

		System.out.println("ALUresult");
		int Operand1Int = (int)Long.parseLong(Operand1, 2);
		int Operand2Int = (int)Long.parseLong(Operand2, 2);
		int ALUresultInt;
		
		switch (Op) {
		case "0000":
			System.out.println("Operation Name: AND");
			System.out.println("1st Operand: " + Operand1+ " ,with value of: " + (int)Long.parseLong(Operand1,2));
			System.out.println("2nd Operand: " + Operand2+ " ,with value of: " + (int)Long.parseLong(Operand2,2));
			ALUresultInt =Operand1Int& Operand2Int;
			
			ALUresult = Engine.to32Bits(Integer.toBinaryString(ALUresultInt));
			System.out.println("ALUresult: " + ALUresult+ " ,with value of: " + (int)Long.parseLong(ALUresult,2));
			
			
			if(ALUresultInt==0){
				ALUZero= true;
				System.out.println("Z-Flag Value: " + ALUZero);
			}else{
				ALUZero= false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}
			// code block
			break;
		case "0001":
			System.out.println("Operation Name: OR");
			System.out.println("1st Operand: " + Operand1+ " ,with value of: " + (int)Long.parseLong(Operand1,2));
			System.out.println("2nd Operand: " + Operand2+ " ,with value of: " + (int)Long.parseLong(Operand2,2));

			ALUresultInt =Operand1Int | Operand2Int;
			
			ALUresult = Engine.to32Bits(Integer.toBinaryString(ALUresultInt));
			System.out.println("ALUresult: " + ALUresult+ " ,with value of: " + (int)Long.parseLong(ALUresult,2));
			
			
			if(ALUresultInt==0){
				ALUZero= true;
				System.out.println("Z-Flag Value: " + ALUZero);
			}else{
				ALUZero= false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}
			

			// code block
			break;
		case "0010":
			System.out.println("Operation Name: add");
			System.out.println("1st Operand: " + Operand1+ " ,with value of: " + (int)Long.parseLong(Operand1,2));
			System.out.println("2nd Operand: " + Operand2+ " ,with value of: " + (int)Long.parseLong(Operand2,2));
			ALUresultInt =Operand1Int + Operand2Int;
			ALUresult = Engine.to32Bits(Integer.toBinaryString(ALUresultInt));

			System.out.println("ALUresult: " + ALUresult+ " ,with value of: " + (int)Long.parseLong(ALUresult,2));
			if(ALUresultInt==0){
				ALUZero= true;
				System.out.println("Z-Flag Value: " + ALUZero);
			}else{
				ALUZero= false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}

			// code block
			break;
		case "0110":
			System.out.println("Operation Name: sub");
			System.out.println("1st Operand: " + Operand1+ " ,with value of: " + (int)Long.parseLong(Operand1,2));
			System.out.println("2nd Operand: " + Operand2+ " ,with value of: " + (int)Long.parseLong(Operand2,2));
			ALUresultInt =Operand1Int - Operand2Int;

			ALUresult = Engine.to32Bits(Integer.toBinaryString(ALUresultInt));

			System.out.println("ALUresult: " + ALUresult+ " ,with value of: " + (int)Long.parseLong(ALUresult,2));
			if(ALUresultInt==0){
				ALUZero= true;
				System.out.println("Z-Flag Value: " + ALUZero);
			}else{
				ALUZero= false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}

			// code block
			break;
		case "0111":
			System.out.println("Operation Name: slt");
			System.out.println("1st Operand: " + Operand1+ " ,with value of: " + (int)Long.parseLong(Operand1,2));
			System.out.println("2nd Operand: " + Operand2+ " ,with value of: " + (int)Long.parseLong(Operand2,2));

			if(Operand1Int<Operand2Int){
				ALUresultInt= 1;
			}
			else{
				ALUresultInt=0;
			}
			ALUresult = Engine.to32Bits(Integer.toBinaryString(ALUresultInt));

			System.out.println("ALUresult: " + ALUresult+ " ,with value of: " + (int)Long.parseLong(ALUresult,2));
			if(ALUresultInt==0){
				ALUZero= true;
				System.out.println("Z-Flag Value: " + ALUZero);
			}else{
				ALUZero= false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}

			// code block
			break;
		default:
			System.out.println("This operation does not exist");
		}
		
		System.out.println();
		
		return ALUresult;

	}

//	@SuppressWarnings("resource")
//	public static void main(String[] args) {
//		
//		int Operand1;
//		int Operand2;
//		String Op;
//		
//		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//		
//	    System.out.println("Enter operation string");
//	    Op = myObj.nextLine();  // Read user input
//	    
//		System.out.println("Enter 1st operand in decimal");
//	    Operand1 = myObj.nextInt();  // Read user input
//	    
//	    System.out.println("Enter 2nd operand in decimal");
//	    Operand2 = myObj.nextInt();  // Read user input
//
//	    
//	    ALUEvaluator(Op, Operand1, Operand2);
//		
//		
//		//Test Cases
//		
////		//AND
////		Operand1=5;
////		Operand2=13;
////		Op="0000";
////		ALUEvaluator(Op, Operand1, Operand2);
////
////		
////		//OR
////		Operand1=9;
////		Operand2=25;
////		Op="0001";
////		ALUEvaluator(Op, Operand1, Operand2);
////		
////		//NOR
////		Operand1=8;
////		Operand2=8;
////		Op="1100";
////		ALUEvaluator(Op, Operand1, Operand2);
////		
////		//add
////		Operand1=8;
////		Operand2=8;
////		Op="0010";
////		ALUEvaluator(Op, Operand1, Operand2);
////		
////		//slt
////		Operand1=9;
////		Operand2=12;
////		Op="0111";
////		ALUEvaluator(Op, Operand1, Operand2);
////	    	    
////		//sub
////		Operand1=27;
////		Operand2=18;
////		Op="0110";
////		ALUEvaluator(Op, Operand1, Operand2);
//	   
//
//	}

}


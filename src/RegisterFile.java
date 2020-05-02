
public class RegisterFile {
	static String[] arrRegister=new String[32];
	
	public static void setRegister(String data,String location){
		int intLocation= Integer.parseInt(location, 2);
		
		if(intLocation==0 || intLocation>32){
			System.out.println("Error: can't save in register");
		}else{
			arrRegister[intLocation]=data;
		}
	}
	
	
	public static String getRegister(String location){
		int intLocation= Integer.parseInt(location, 2);
		
		if(intLocation>32){
			System.out.println("Error: can't load in register");
			return "";
		}else{
			if(arrRegister[intLocation]==null){
				return "0";
			}else{
			
			return arrRegister[intLocation];
			}
			}
	}
}



public class DataMemory {
	public static String[] dataList = new String[1024]; ;
	
	
	

	public static void setData(String data,String location){
		int intLocation= Integer.parseInt(location, 2);
		
		if(intLocation>1024){
			System.out.println("Error: can't save in memory");
		}else{
			dataList[intLocation]=data;
		}
	}
	
	
	public static String getData(String location){
		int intLocation= Integer.parseInt(location, 2);
		
		if(intLocation>32){
			System.out.println("Error: can't load from memory");
			return "";
		}else{
			return dataList[intLocation];
		}
	}
	
}

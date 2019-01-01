package two;
import java.util.*;
import java.io.*;
public class trial {
	static ArrayList<String[]>data=new ArrayList<>();
	public static void replace(int x,String y)
	{
		for(String []line:data) {
			if(line[x].isEmpty()) {
				line[x]=y;
			}
		}
	}

	public static void main(String[] args) throws IOException,FileNotFoundException {
		String lines;
		BufferedReader csv=new BufferedReader(new FileReader(new File("25.csv")));
		while((lines=csv.readLine())!=null){
			String []d=lines.split(",",-1);
			data.add(d);
		}
		double avg=0;
		double total=0;
		for(String []line:data) {
			if(!(line[0].isEmpty())){
				avg+=Double.parseDouble(line[0]);
				total++;
			}
		
		}	
		String f=Double.toString(avg/total);
		replace(0,f);
			
		System.out.println(avg);
		System.out.println(total);
		
		//for(String []line:data) {
		//	System.out.println(line[0]);
		//}
		HashMap<String,Integer>a1=new HashMap<>();
		for(String []line:data) {
			if(a1.containsKey(line[1])) {
				int temp=a1.get(line[1]);
				a1.put(line[1], temp+1);
			}
			else
			{
				a1.put(line[1], 1);
			}
			
		}
		String mode="";
		int max=0;
		for(String key:a1.keySet()) {
			if(a1.get(key)>max) {
				max=a1.get(key);
				mode=key;
				
			}
			
		}
		replace(1,mode);
		for(String []line:data) {
			for(String word:line)
			{
				System.out.print(word+"\t\t");
			}
			System.out.println();
		}
		
		
		
			
		
		
		
		
		
		
		
		
		

	}

}

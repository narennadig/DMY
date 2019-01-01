package eight;

import java.io.*;
import java.util.*;

class temp{
	double x,y;
}

public class Trial {
	public static void main(String[]args) throws IOException,FileNotFoundException {
		BufferedReader csv=new BufferedReader(new FileReader(new File("gaitonde.csv")));
		String data=csv.readLine();
		ArrayList<temp>a1=new ArrayList<>();
		while(data!=null) {
			String[]datarr=data.split(",");
			temp t=new temp();
			t.x=Double.parseDouble(datarr[0]);
			t.y=Double.parseDouble(datarr[1]);
			a1.add(t);
			data=csv.readLine();
			
		}
		
		
		double meanx=0,meany=0,varx=0,covxy=0;
		
		for(int i=0;i<a1.size();i++){
			meanx+=a1.get(i).x;
			meany+=a1.get(i).y;
			
		}
		
		
		
		meanx=meanx/a1.size();
		meany=meany/a1.size();
		System.out.println(meanx);
		System.out.println(meany);
		for(int i=0;i<a1.size();i++){
			covxy+=(a1.get(i).x-meanx)*(a1.get(i).y-meany);
			varx+=Math.pow((a1.get(i).x-meanx),2);
		
		
		}
		covxy=covxy/a1.size();
		varx=varx/a1.size();
		double m,c;
		m=covxy/varx;
		c=meany-m*meanx;
		System.out.println("enter x i will predict y");
		Scanner sc=new Scanner(System.in);
		double x=sc.nextDouble();
		//System.out.println(m);
		//System.out.println(c);
		
		double y=m*x+c;
		System.out.println("the predicted value is :"+y);
		
		
		
		
		
		
	}
	

}

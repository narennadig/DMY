package one;
import java.util.*;
import java.io.*;

class Record
{
	int id,age;
	String name;
}
public class trial {
	static Record[] rc=new Record[5];
	public static void main(String[] args)  throws IOException,FileNotFoundException{
		
		 int min=Integer.MAX_VALUE;
		 int max=Integer.MIN_VALUE;
		 BufferedReader csv=new BufferedReader(new FileReader(new File("3.csv")));
		 String data=csv.readLine();
		 int i=0;
		 while(data!=null){
			 String []datarr=data.split(",");
			 Integer a=Integer.parseInt(datarr[0]);
			 Integer b=Integer.parseInt(datarr[1]);
			 //String c=datarr[2];
			 rc[i]=new Record();
			rc[i].id=a;
			rc[i].age=b;
			//rc[i].name=c;
			if(b>max)
			{
				max=b;
			}
			if(b<min)
			{
				min=b;
			}
			 i++;
			 data=csv.readLine();
			 }
		 int avg=0;
		 for(int j=0;j<5;j++)
		 {
			avg +=rc[j].age;
		 }
		 avg=avg/5;
		 int []sampling=new int[4];
		 sampling[2]=0;
		 System.out.println("the average is "+avg);
		 System.out.println("the minimum is "+min);
		 System.out.println("the maximum is "+max);
		 int mean=(min+max)/2;
		 int mid1=(min+mean)/2;
		 int mid2=(max+mean)/2;
		 for(int j=0;j<i;j++) {
			 if(rc[j].age>=min&&rc[j].age<=mid1) {
				 System.out.println(min+"  "+mid1);
				 sampling[0]=rc[j].age;
			 }
			 if(rc[j].age>=mid1&&rc[j].age<=mean) {
				 System.out.println(mid1+"  "+mean);
				 sampling[1]=rc[j].age;
			 }
			 if(rc[j].age>=mean&&rc[j].age<=mid2) {
				 System.out.println(mean+"  "+mid2);
				 sampling[2]+=1;
			 }
			 if(rc[j].age>=mid2&&rc[j].age<=max) {
				 System.out.println(mid2+"  "+max);
				 sampling[3]=rc[j].age;
			 }
		 }
		 
		 System.out.println(min+"-"+mid1+"="+sampling[0]);
		 System.out.println(mid1+"-"+mean+"="+sampling[1]);
		 System.out.println(mean+"-"+mid2+"="+sampling[2]);
		 System.out.println(mid2+"-"+max+"="+sampling[3]);
		 
		 
		
		 
		 
		 

	}

}

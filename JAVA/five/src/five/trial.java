
package five;
import java.io.*;
import java.util.*;


class temp
{
	double z;
	String x,y;
}

public class trial {
	public static double prob(ArrayList<temp>a1,String x) {
		double count=0;
		for(temp z:a1) {
			if((z.x).equals(x)) {
				count++;
				
			}
		}
		return(count/a1.size());
		
	}
	public static double mean(ArrayList<temp>a1) {
		double sum=0;
		for(temp z:a1) {
			sum+=z.z;
		}
		return(sum/a1.size());
		
	}
	public static double sd(ArrayList<temp>a1,double m1) {
		double sum=0;
		int x=a1.size();
		for(temp z:a1) {
			sum+=Math.pow(z.z-m1, 2);
		}
		return Math.sqrt(sum/(x*(x-1)));
	}
	

	public static void main(String[] args)  throws IOException,FileNotFoundException{
		BufferedReader csv=new BufferedReader(new FileReader(new File("69.csv")));
		ArrayList<temp>y=new ArrayList<>();
		ArrayList<temp>n=new ArrayList<>();
		
		String data=csv.readLine();
		while(data!=null) {
			String[]datarr=data.split(",",-1);
			temp res=new temp();
			res.z=Integer.parseInt(datarr[0]);
			res.x=datarr[1];
			res.y=datarr[2];
			if((res.y).equals("Y")) {
				y.add(res);
				}
			else {
				n.add(res);
			}
		data=csv.readLine();
			
		}
		
		System.out.println("enter shirt measure and size");
		Scanner sc=new Scanner(System.in);
		Double x1=sc.nextDouble();
		String x2=sc.next();
		int t=y.size()+n.size();
		double p_y=(double)(y.size())/(double)(t);
		double p_n=(double)(n.size())/(double)(t);
		
		
		
		double mean1=mean(y);
		double mean2=mean(n);
		
		double sd1=sd(y,mean1);
		double sd2=sd(y,mean2);
		
		double exp1= Math.pow(x1-mean1, 2);
		exp1=exp1/(2*sd1*sd1);
		double p1 =1/Math.sqrt(2*3.14)*sd1;
		p1=p1/Math.exp(exp1);
		
		
		double exp2= Math.pow(x1-mean2, 2);
		exp2=exp2/(2*sd2*sd2);
		double p2 =1/Math.sqrt(2*3.14)*sd2;
		p2=p2/Math.exp(exp2);
		
		
		double p3=prob(y,x2);
		
		double p4=prob(n,x2);
		
		double res1=p_y*p1*p3;
		double res2=p_n*p2*p4;
		
		//System.out.println(y);
		//System.out.println(n);
		//System.out.println(mean1);
		System.out.println(p3);
		System.out.println(p4);
		
		System.out.println(res1);
		System.out.println(res2);
		
		if(res1>res2) {
			System.out.println("Y");
		}
		else
		{
			System.out.println("N");
		}
		
		
		
		
		
		
		

	}

}

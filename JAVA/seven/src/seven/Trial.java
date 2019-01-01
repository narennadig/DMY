package seven;
import java.io.*;
import java.util.*;
class Temp{
	double x,y,z;
}
public class Trial {
	public static void main(String []args) throws IOException,FileNotFoundException{
		Random rand=new Random();
		ArrayList<Temp>a1=new ArrayList<>();
		BufferedReader csv=new BufferedReader(new FileReader(new File("jaanu.csv")));
		String data=csv.readLine();
		double sum;
		double rate=0.02;
		while(data!=null) {
			String[]datarr=data.split(",");
			double x=Double.parseDouble(datarr[0]);
			double y=Double.parseDouble(datarr[1]);
			double z=Double.parseDouble(datarr[2]);
			data=csv.readLine();
		}
		double []weight=new double[3];
		weight[0]=rand.nextInt(32767*2)-32767;
		weight[1]=rand.nextInt(32767*2)-32767;
		for(int i=0;i<1000;i++) {
			for(int j=0;j<a1.size()-1;j++) {
				int res=0;
				sum=weight[0]+weight[1]*(a1.get(j)).x+weight[2]*(a1.get(j)).y;
				if(sum>0)
				{
					res=1;
				}
				double error=(a1.get(j)).z-res;
				weight[0]=weight[0]+rate*error;
				weight[1]=weight[1]+rate*error*(a1.get(j)).x;
				weight[2]=weight[2]+rate*error*(a1.get(j)).y;
				
				
			}
		}
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the inital weights ");
		double p=sc.nextDouble();
		double q=sc.nextDouble();
		double sum1=weight[0]+weight[1]*p+weight[2]*q;
		if(sum1>0){
			System.out.println("Target class:1.0");
		}
		else {
			System.out.println("Target class:0.0");
			
		}
		System.out.println("The final weights are :  weight[0] ="+weight[0]+"weight[1]="+weight[1]+"weight[2]="+weight[2]);
		
		
		
		
		
	}

}

import java.io.*;
import java.util.*;

class temp{
	int a,b;
	String c;
	temp(int dist,int point,String cls){
		a=dist;
		b=point;
		c=cls;
	}
}
 class Trial {

	public static void main(String[] args) throws FileNotFoundException,IOException{
		BufferedReader csv=new BufferedReader(new FileReader(new File("anhad.csv")));
		String data=csv.readLine();
		int k;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the value of k");
		k=sc.nextInt();
		System.out.println("enter the point");
		int p=sc.nextInt();
		
		ArrayList<temp>a1=new ArrayList<>();
		while(data!=null)
		{
			String []datarr=data.split(",",-1);
			int b=Integer.parseInt(datarr[0]);
			String c=datarr[1];
			
			
			int dist=Math.abs(p-b);
			temp t=new temp(dist,b,c);
			a1.add(t);
			data=csv.readLine();
			}
		
		Collections.sort(a1, new Comparator<temp>() {
			@Override public int compare(temp p1,temp p2) {
				if(p1.a==p2.a) {
					return 0;
					}
				else if(p1.a>p2.a) {
					return 1;
					}
				else {
					return -1;
				}
			}});
		
		
		
		
		
int []x=new int[2];
System.out.println("The k nearest neighbors are :");
for(temp t:a1) {
	if(k==0) {
		break;
	}
	System.out.println( t.a+"  "+t.b+"  "+t.c);
	k--;
	//System.out.println(t.c);
	
	if((t.c).equals("A")){
		x[0]++;
		
	}
	else
	{
		x[1]++;
	}
	
}
System.out.println("x[0]="+x[0]);
System.out.println("x[0]="+x[1]);
int r=Math.max(x[0], x[1]);
if(r==x[0])
{
	System.out.println("It belongs to class A");
}
else
{
	System.out.println("It belongs to class B");
}

			
			
			
			
		

	
	
	
	
	
	}

}

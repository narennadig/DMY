package nine;
import java.io.*;
import java.util.*;
class record
{
	double a=0,b=0;
}

public class Trial {
	public static record calc(ArrayList<record>b1){
		record a=new record();
		double x=0,y=0;
		for(record r:b1) {
			x+=r.a;
			y+=r.b;
			
		}
		a.a=x/b1.size();
		a.b=y/b1.size();
		return(a);
		
	}
	public static double dist(double a,double b,double c,double d) {
		double dist=Math.pow(a-b, 2)+Math.pow(c-d, 2);
		dist=Math.sqrt(dist);
		return(dist);
	}


	public static void main(String[] args) throws FileNotFoundException,IOException {
		BufferedReader csv=new BufferedReader(new FileReader(new File("70.csv")));
		ArrayList<record>a1=new ArrayList<>();
		String data=csv.readLine();
		while(data!=null) {
			String []datarr=data.split(",");
			record r=new record();
			r.a=Double.parseDouble(datarr[0]);
			r.b=Double.parseDouble(datarr[1]);
			a1.add(r);
			data=csv.readLine();
			
		}
		ArrayList<record>c1=new ArrayList<>();
		ArrayList<record>c2=new ArrayList<>();
		//ArrayList<record>c3=new ArrayList<>();
		ArrayList<record>centroid=new ArrayList<>();
		centroid.add(a1.get(0));
		centroid.add(a1.get(2));
		for(int i=0;i<3;i++) {
			c1.clear();
			c2.clear();
		for(record r:a1) {
				ArrayList<Double>p=new ArrayList<>();
				double e=dist(r.a,centroid.get(0).a,r.b,centroid.get(0).b);
				double f=dist(r.a,centroid.get(1).a,r.b,centroid.get(1).b);
				p.add(e);
				p.add(f);
				//System.out.println("e="+e+"f=");
				
				double res=Collections.min(p);
				if(res==e) {
					c1.add(r);
					}
				if(res==f) {
					c2.add(r);
					}
			}
			centroid.clear();
			centroid.add(calc(c1));
			centroid.add(calc(c2));
			
		}
		System.out.println("The first cluster is");
		for(record r:c1) {
			System.out.println(r.a+"   "+r.b);
		}
		System.out.println("The second cluster is");
		for(record r:c2) {
			System.out.println(r.a+"   "+r.b);
		}
		System.out.println("The centroids are is");
		for(record r:centroid) {
			System.out.println(r.a+"   "+r.b);
		}
		
				
				
				
			
			
			
			
			
			
			
			
	
		
		
		
	

	}

}


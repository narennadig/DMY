package ten;
import java.util.*;
import java.io.*;

public class Trial {

	public static void main(String[] args) {
		
		double [][]a=new double[2][2];
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the confusion matrix");
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				a[i][j]=sc.nextDouble();
			}
		}
		
		double Sense=(a[0][0])/(a[0][0]+a[0][1]);
		double Specify=(a[1][1])/(a[1][0]+a[1][1]);
		double recall=(a[0][0])/(a[0][0]+a[0][1]);
		double preision=(a[0][0])/(a[0][0]+a[1][0]);
		double accuracy =(a[0][0]+a[1][1])*25;
		
		System.out.println("sensitivity ="+Sense);
		System.out.println("specifitivity ="+Specify);
		System.out.println("recall ="+recall);
		System.out.println("precision ="+preision);
		System.out.println("accuracy ="+accuracy);
		

	}

}

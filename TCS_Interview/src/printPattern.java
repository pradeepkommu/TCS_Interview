/* 
 * Decode the logic of program If N= 3
then pattern will be :
10203010011012
**4050809
****607
If N= 4
then pattern will be:

1020304017018019020

**50607014015016

****809012013

******10011
and print the pattern
* */


import java.util.HashMap;
import java.util.Scanner;

public class printPattern {
	public static void main(String[] args) {
		HashMap<String, String> numFormate = new HashMap<String, String>();
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter Number");
		String num = myObj.nextLine();
		int N = Integer.parseInt(num);
		if(N>=2 && N<=100) {
			int counter =N;
			int split=N;
			String temp = "";
			N=N*(N+1);
			int i=0;
			int j=0;
			int k=1;
			for(i=1;i<=(N/2)+1;i++) {
				if(j == split && j != 0) {
					j=0;
					i=i-1;
					numFormate.put(Integer.toString(k), temp);
					temp="";
					k=k+1;
					split=split-1;
				}else {
					temp=temp+i+0;
					j=j+1;
				}
			}
			k=counter;
			temp="";
			j=0;
			split=1;
			for(i=(N/2)+1;i<=N+1;i++) {
				if(j == split && j != 0 ) {
					j=0;
					i=i-1;
					numFormate.put(Integer.toString(k), numFormate.get(Integer.toString(k)) + temp) ;
					temp="";
					k=k-1;
					split=split+1;
				}else {
					temp=temp+i+0;
					j=j+1;
				}
			}

			int g=0;
			for(int m=1;m<=counter;m++) {
				String star = "";
				String val=numFormate.get(Integer.toString(m));
				val=val.substring(0, val.length()-1);
					for(int l=1;l<=2*g;l++) {
						star= star + "*" ;
					}
					System.out.println(star+val);
					g=g+1;
			}
		}else {
			System.out.println("enter number between 2-100");
		}
	}

}

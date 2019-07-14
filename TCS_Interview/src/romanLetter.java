/*
 * - Problem Description
We know about number systems The Roman numerals and the alternative place value system with a given base.
For the purposes of this problem, we limit ourselves to
1) Roman numerals with values up to 3999 (MMMCMXCIX)
2) Place value systerri numbers having bases from 2 (with possible symbols 0, 1) through 36 (with possible symbols 0, 1, ..., 9, A, ... ,Z)
Consider the following procedure:
1) Accept a natural number N (in base 10).
2) If N lies in the closed interval (1,3999), i.e. between 1 and 3999 (both inclusive), convert N to R, its Roman numeral representation; else output N as the result and stop.
3) Identify the base in which the value of R, now considered to be in "place value system", is least and calculate its value in base 10, replacing N with this value.
4) Repeat from step 2
- Constraints
1<=N<=3999.
- Input Format
A single Integer N
- Output
Converted N
- Test Case
lanation​
 * */

import java.util.Scanner;
import java.util.TreeMap;

public class romanLetter {

	private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
	private final static TreeMap<String, String> base10 = new TreeMap<String, String>();

	static {
		map.put(1000, "M");map.put(900, "CM");map.put(500, "D");map.put(400, "CD");
		map.put(100, "C");map.put(90, "XC");map.put(50, "L");map.put(40, "XL");
		map.put(10, "X");map.put(9, "IX");map.put(5, "V");map.put(4, "IV");map.put(1, "I");
	}
	static {
		base10.put("0", "1");base10.put("1", "2");base10.put("2", "3");base10.put("3", "4");base10.put("4", "5");base10.put("5", "6");base10.put("6", "7");
		base10.put("7", "8");base10.put("8", "9");base10.put("9", "10");base10.put("A", "11");base10.put("B", "12");base10.put("C", "13");base10.put("D", "14");
		base10.put("E", "15");base10.put("F", "16");base10.put("G", "17");base10.put("H", "18");base10.put("I", "19");base10.put("J", "20");base10.put("K", "21");
		base10.put("L", "22");base10.put("M", "23");base10.put("N", "24");base10.put("O", "26");base10.put("P", "26");base10.put("Q", "27");base10.put("R", "28");
		base10.put("S", "29");base10.put("T", "30");base10.put("U", "31");base10.put("V", "32");base10.put("W", "33");base10.put("X", "34");base10.put("Y", "35");
		base10.put("Z", "36");
	}

	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter Number");
		String num = myObj.nextLine();  // Read user input
		int i = Integer.parseInt(num);
		long temp;
		int k;
		do {
			k=0;
			temp = 0;
			String romanValue=toRoman(i);
			System.out.println("Roman Value : "+romanValue);
			for(int j=romanValue.length()-1; j>=0;j--){  
				char c = romanValue.charAt(j); 
				char lastchar = romanValue.charAt(0); 
				String r=Character.toString(c);
				int baseTenValue=toBaseTen(Character.toString(lastchar));
				temp=temp+toCompute(r,baseTenValue, k);
				k=k+1;
				i=(int) temp;
			}  
		}
		while (i >= 1 && i <= 3999);
		System.out.println("Final Value : "+temp);
	}

	public final static long toCompute(String romanVal,int baseValue, int power) {
		int baseTenValue=toBaseTen(romanVal);
		int base=baseTenValue-1;
		long result = (long) (base*(Math.pow(baseValue, power)));
        //System.out.println("Answer = " + result);
		return result;
	}
	
	public final static String toRoman(int number) {
		int l =  map.floorKey(number);
		if ( number == l ) {
			return map.get(number);
		}
		return map.get(l) + toRoman(number-l);
	}
	public final static int toBaseTen(String val) {
		int v=Integer.parseInt(base10.get(val));
		return v;
	}

}

package prime;

import java.util.ArrayList;
import java.util.Scanner;

public class Prime {
		
	private static ArrayList<Integer> num_list = new ArrayList<Integer>();
	private static ArrayList<Integer> num_list2 = new ArrayList<Integer>();
	private static boolean first = true;
	
	// resets all the variables for the next calculation
	private static void list_clear(){
		num_list.clear();
		num_list2.clear();		
		first = true;
	}
	private static boolean determine(int num){
		
		// any negative number is not a prime number
		if (num <= 0){
			return false;
		}
		
		// 1 is always a prime number
		if (num == 1 ){
			return true;
		}
		
		// checks to see if there are any factors of the number, if so not a prime
		boolean result = true;
		for (int i = 2; i < num; i++){
			if (num % i == 0){
				if (first){
					num_list.add(i);
				}
				result = false;
			}
		}
		if (result == false){
			return false;
		}
		
		// if no factors are found, then it is a prime number
		return true;
	}
	
	// determines the prime factors of the numbers
	private static void factors(){
		num_list2.add(1);
		first = false;
		for (int i = 0; i <= num_list.size() - 1; i++){
			if (determine(num_list.get(i))) {
				num_list2.add(num_list.get(i));
			}	
		}
	}
	
	public static void main(String []args){
		
		int num;
		boolean run = true;
		Scanner reader = new Scanner(System.in);
		
		while (run = true){
			System.out.println("Please enter any number to determine if it is a prime number.");
			num = reader.nextInt();
			
			if (Prime.determine(num)){
				System.out.println(num + " is a prime number.");
			} else {
				System.out.println(num + " is not a prime number.");
				Prime.factors();
				System.out.println("The prime factors are: " + Prime.num_list2);
			}		
			System.out.println("");
			Prime.list_clear();
		}
		reader.close();

	}

}

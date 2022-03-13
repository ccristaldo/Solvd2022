package Ex3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String cont;
		boolean exit = false;
		String t,o,m=null;
		
		Arr arr = null;
				
		while (!exit) {
			
			try {
			
				System.out.println("Set length of the Array: ");
				int len = sc.nextInt();
				
				System.out.println("Set type of the Array: \n 1 - int \n 2 - char: ");
				int type = sc.nextInt();
				//validating entry
				while (type < 1 || type > 2) {
					System.out.println("Invalid entry. Try again: ");
					type = sc.nextInt();
				}
				//for information
				if (type == 1) {
					t = "Numbers";
				}else {
					t = "Characters";
				}
				
				System.out.println("Set order of the Array: \n 1 - asc \n 2 - desc: ");
				int order = sc.nextInt();
				//validating entry
				while (order < 1 || order > 2) {
					System.out.println("Invalid entry. Try again: ");
					order = sc.nextInt();
				}
				//for information
				if (order == 1) {
					o = "Ascendent";
				}else {
					o = "Descendent";
				}
				
				System.out.println("Set method of the Array: \n 1 - loop \n 2 - array class \n 3 - collection class: ");
				int method = sc.nextInt();
				//validating entry
				while (method < 1 || method > 3) {
					System.out.println("Invalid entry. Try again: ");
					method = sc.nextInt();
				}
				//for information
				switch (method) {
				case 1:
					m = "Sorted by Loop";
					break;
				case 2:
					m = "Sorted by Array Class";
					break;
				case 3:
					m = "Sorted by Collection Class";
					break;
				}
				
				//create the required array
				arr = new Arr(len, type, order, method);
				
				//information
				System.out.println("\nLenght: " + len + "\nType: " + t + "\nOrder: " + o + "\nMethod: " + m);
				
				//retrieve corresponding array
				if (arr.getArrInt() != null) {
					System.out.println("\nSorted Array: " + Arrays.toString(arr.getArrInt()));
				}else {
					System.out.println("\nSorted Array: " + arr.getArrString());
				}
				
				
				System.out.println("\n continue? (y/n): ");
				cont = sc.next();
				if (cont.equals("n")) {
					System.out.println("Program terminated.");
					exit = true;				
				}
			}catch (InputMismatchException e){
				System.out.println("Wrong entry. Only numbers");
                sc.next();
			}
		}	
				
		sc.close();
	}
	
}



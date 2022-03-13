import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class E2 {
	
	public static void loop() {
		System.out.println("Selected option: Loop \n");
		//create array
		int[] numbers = createArray();
		//print array unsorted
		System.out.println("Unsorted array:");
		for(int a : numbers) System.out.print(a + " ");
		System.out.println("\n");
		System.out.println("Sorted array:");
		// Outer loop
        for (int i = 0; i < numbers.length; i++) {
 
            // Inner loop pointing to the next element 
            for (int j = i + 1; j < numbers.length; j++) {
 
                // Checking elements
                int temp = 0;
                if (numbers[j] < numbers[i]) {
 
                    // Swapping if applies
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
 
            // Printing sorted array 
            System.out.print(numbers[i] + " ");
        }
		
	}
	
	public static void arrayClass() {
		System.out.println("Selected option: Array Class \n");
		//create array
		int[] numbers = createArray();
		//print array unsorted
		System.out.println("Unsorted array:");
		for(int a : numbers) System.out.print(a + " ");
		System.out.println("\n");
		System.out.println("Sorted array:");
		// Using sort() method present from Arrays class
        Arrays.sort(numbers); 
        // Printing and display sorted array
        System.out.printf(" %s", Arrays.toString(numbers));
	}
	
	public static void collectionClass() {
		System.out.println("Selected option: Collection Class \n");
		//create array
		int[] numbers = createArray();
		//print array unsorted
		System.out.println("Unsorted array:");
		for(int a : numbers) System.out.print(a + " ");
		System.out.println("\n");
		System.out.println("Sorted array:");
		ArrayList<Integer> arr = new ArrayList<>();
		 for (int i=0; i<numbers.length; i++){
	            arr.add(numbers[i]);
	        }
		Collections.sort(arr);
		System.out.println(arr);	
	}
	
	public static int[] createArray() {
		//method for fill array with random numbers
		int[] numbers = new int[10];
		for (int k=0; k < numbers.length; k++) {
			  numbers[k] = (int) (Math.random()*99)+1;
		}
		return numbers;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		
		int option;
		
		while (!exit){
			System.out.println("\n");
			System.out.println("Select method for sorting: \n 1 - Loop \n 2 - Array class \n 3 - Collection class \n 4 - Exit");
			try {
				System.out.println("Select option");
				option = sc.nextInt();
				switch (option) {
                case 1:
                    System.out.println("Selected option: 1");
                    loop();
                    break;
                case 2:
                    System.out.println("Selected option: 2");
                    arrayClass();
                    break;
                case 3:
                    System.out.println("Selected option: 3");
                    collectionClass();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Valid options: Numbers between 1 and 4");
            }
				
			} catch (InputMismatchException e) {
				System.out.println("Wrong entry. Only numbers");
                sc.next();
			}
			
		}
		
		sc.close();

	}

}

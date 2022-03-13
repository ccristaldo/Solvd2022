package Ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Arr {

	//Array's length
	private int len;
	//String or integer
	private int type;
	//asc or desc
	private int order;
	//loop, array class, collection class
	private int method;
	//Actual array
	private int[] arrInt = null;
	private String arrString = null;
	
	//constructor
	public Arr(int len, int type, int order, int method) {
		this.len = len;
		this.type = type;
		this.order = order;
		this.method = method;
		//create array of char or int upon type
		if (type == 1) this.arrInt = createIntArray();
		if (type == 2) this.arrString = createStringArray();
	}
	
	
	//setter and getters
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getMethod() {
		return method;
	}
	public void setMethod(int method) {
		this.method = method;
	}
	public int[] getArrInt() {
		return arrInt;
	}
	public void setArrInt(int[] arrInt) {
		this.arrInt = arrInt;
	}
	public String getArrString() {
		return arrString;
	}
	public void setArrString(String arrString) {
		this.arrString = arrString;
	}
	
	// ------------------- Integer Array Creation ------------------------

	public int[] createIntArray() {
		
		//creating array using upon len(length) attribute
		int[] res = new int[len];
		
		//create array of random Integers
		for (int k = 0; k < res.length; k++) {
			res[k] = (int) (Math.random() * 99) + 1;
		}
		
		System.out.println("\nUnsorted Array: " + Arrays.toString(res));
		
		//selecting sorting method upon method attribute
		switch (method) {
		case 1:
			res = loopInt(res);
			break;
		case 2:
			res = arrayClassInt(res);
			break;
		case 3:
			res = collectionClassInt(res);
			break;
		}
		
		//reversing array upon order attribute
		if (order == 2) {
			ArrayList<Integer> temp = new ArrayList<>();
			for(int i : res) temp.add(i);
			Collections.reverse(temp);
		
			for (int i = 0; i < res.length; i++) {
				res[i]=temp.get(i);
			}
			
		}
		
		//returning result
		return res;
	}
	
	//Sorting using collection class method
	private int[] collectionClassInt(int[] res) {
		
		//turning array into arraylist to use arraylist methods
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i=0; i<res.length; i++){
	            arr.add(res[i]);
	        }
		
		Collections.sort(arr);
		
		//turning arraylist into array to return result
		for(int j=0; j<arr.size();j++) {
			res[j] = arr.get(j);
			}
		
		//returning result
		return res;
	}

	//Sorting using a for loop
	public int[] loopInt(int[] res) {
		
		//Outer loop
		for (int i = 0; i < res.length; i++) {
			 
            // Inner loop pointing to the next element 
            for (int j = i + 1; j < res.length; j++) {
 
                // Checking elements
                int temp = 0;
                if (res[j] < res[i]) {
 
                    // Swapping if applies
                    temp = res[i];
                    res[i] = res[j];
                    res[j] = temp;
                }
            }
		}
		
		//returning result
		return res;
	}
	
	//Sorting using Array class method
	public int[] arrayClassInt(int[] res) {
		Arrays.sort(res);
		return res;
	}
	
	// ------------------- String/Char Array Creation ------------------------
	
	public String createStringArray() {
		StringBuilder builder = new StringBuilder(len); 
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		
		int index;
		String res;
		
		//creating array of random char using regex 'alphabet'
		for (int i = 0; i < len; i++) {
			index = (int) (alphabet.length() * Math.random());
			builder.append(alphabet.charAt(index));
		}
		
		//turning builder to string
		res = builder.toString();
		
		System.out.println("\nUnsorted Array: " + res);
		
		//Selecting sorting method upon method attribute
		switch (method) {
		case 1:
			res = loopChar(res);
			break;
		case 2:
			res = arrayClassChar(res);
			break;
		case 3:
			res = collectionClassChar(res);
			break;
		}
		
		//reversing array upon order attribute
		if (order == 2) {
			StringBuilder reverse = new StringBuilder();
			reverse.append(res);
			res = reverse.reverse().toString();
		}

		//returnig result
		return res;
		
	}

	//sorting using collection class method
	private String collectionClassChar(String str) {
		
		StringBuilder res = new StringBuilder();
		
		ArrayList<Character> out = new ArrayList<>();
		
		//turning input string into arraylist to use its method
		for (int i = 0; i < str.length(); i++) {
			out.add(str.charAt(i));
		}
		
		Collections.sort(out);
		
		//turning result into a builder
		out.forEach((c) -> {res.append(c);});
		
		//turning builder into string to return result
		return res.toString();
	}

	//sorting using array class method
	private String arrayClassChar(String str) {
		
		StringBuilder res = new StringBuilder();
		
		//turning input string into a char array
		char[] out = str.toCharArray();
		
		//sorting
		Arrays.sort(out);
		
		//turning result into a builder
		for (char c : out) {
			res.append(c);
		}
		
		//turning builder into string to return result
		return res.toString();
	}

	//sorting using a for loop
	private String loopChar(String str) {
		
		//turning input string into a char array
		char[] out = str.toCharArray();
		char temp;
		
		StringBuilder res = new StringBuilder();
		
		//Outer loop
		for (int i = 0; i < out.length; i++) {
			//Inner loop
			for (int j = i+1; j < out.length; j++) {
				//Checking elements
				if (out[j] < out[i]) {
					//Swapping if correspond
					temp = out[i];
					out[i] = out[j];
					out[j] = temp;
				}
			}
			
		}
		
		//turning result into a builder
		for (char c : out) {
			res.append(c);
		}
		
		//turning builder into string to return result
		return res.toString();
	}
	
}

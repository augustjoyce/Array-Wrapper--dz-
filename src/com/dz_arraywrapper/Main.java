package com.dz_arraywrapper;


public class Main {

	public static void main(String[] args) {
		
		ArrayWrapper wrap = new ArrayWrapper(null);
		ArrayWrapper.MyComparator comp = wrap.new MyComparator();

		Number[] originalArray = { 567, 5.53, 12, 8, 3, -156.22, -32, 423 };
		
		System.out.print("Original array: ");
		for (int j = 0; j < originalArray.length; j++) {
			System.out.print(originalArray[j] + " ");
		}

		System.out.println();
//----------------------------------------------------------------
		Number[] added = new ArrayWrapper(originalArray).add(46).getArray();

		System.out.print("Adding an element in array: ");
		for (int j = 0; j < added.length; j++) {
			System.out.print(added[j] + " ");
		}

		System.out.println();
//----------------------------------------------------------------
		Number[] sorted = new ArrayWrapper(added).sort(comp).getArray();
		
		System.out.print("Sorting array: ");
		for (int j = 0; j < sorted.length; j++) {
			System.out.print(sorted[j] + " ");
		}

		System.out.println();
//----------------------------------------------------------------
		Number[] reversed = new ArrayWrapper(sorted).reverse().getArray();
		
		System.out.print("Reversing array: ");
		for (int j = 0; j < reversed.length; j++) {
			System.out.print(reversed[j] + " ");
		}

		System.out.println();
//----------------------------------------------------------------
		try {
			Number[] removed = new ArrayWrapper(sorted).remove(6).getArray();
			
			System.out.print("Removing an element from array by index: ");
			for (int j = 0; j < removed.length; j++) {
				System.out.print(removed[j] + " ");
			}
		} catch (NullPointerException e) {
			System.out.println("Wrong parametrs");
		}

		System.out.println();
//----------------------------------------------------------------
		Double toBeRemoved = 5.53;
		
		try {
			Number[] removed2 = new ArrayWrapper(sorted).remove(toBeRemoved).getArray();
			
			System.out.print("Removing an element from array by value: ");
			for (int j = 0; j < removed2.length; j++) {
				System.out.print(removed2[j] + " ");
			}
		} catch (NullPointerException e) {
			System.out.println("Wrong parametrs");
		}
	}

}

package com.dz_arraywrapper;



public class Main <T extends Number>{

	public static void main(String[] args) throws AddingNullException {
		
		ArrayWrapper<Number> wrap = new ArrayWrapper<Number>(null);
		ArrayWrapper<Number>.MyComparator comp = wrap.new MyComparator();
		
		try {
			Integer[] arrInt = wrap.createArray(Integer.class, 8);
		} catch (NoSuchMethodException e1) {
			System.out.println("Something is fucking wrong");
		} catch (ClassNotFoundException e1) {
			System.out.println("Something is fucking wrong");
		}
		
		Number[] originalArray = { 567, 5.53, 12, 8, 3, -156.22, -32, 423 };
		
		System.out.print("Original array: ");
		for (int j = 0; j < originalArray.length; j++) {
			System.out.print(originalArray[j] + " ");
		}

		System.out.println();
//----------------------------------------------------------------
		Number[] added = new ArrayWrapper<Number>(originalArray).add(54).getArray();

		System.out.print("Adding an element in array: ");
		for (int j = 0; j < added.length; j++) {
			System.out.print(added[j] + " ");
		}

		System.out.println();
//----------------------------------------------------------------
		Number[] sorted = new ArrayWrapper<Number>(added).sort(comp).getArray();
		
		System.out.print("Sorting array: ");
		for (int j = 0; j < sorted.length; j++) {
			System.out.print(sorted[j] + " ");
		}

		System.out.println();
//----------------------------------------------------------------
		Number[] reversed = new ArrayWrapper<Number>(sorted).reverse().getArray();
		
		System.out.print("Reversing array: ");
		for (int j = 0; j < reversed.length; j++) {
			System.out.print(reversed[j] + " ");
		}

		System.out.println();
//----------------------------------------------------------------
		try {
			Number[] removedByIndex = new ArrayWrapper<Number>(sorted).remove(6).getArray();
			
			System.out.print("Removing an element from array by index: ");
			for (int j = 0; j < removedByIndex.length; j++) {
				System.out.print(removedByIndex[j] + " ");
			}
		} catch (NullPointerException e) {
			System.out.println("Wrong parametrs");
		}

		System.out.println();
//----------------------------------------------------------------
		Double toBeRemoved = 5.53;
		
		try {
			Number[] removedByValue = new ArrayWrapper<Number>(sorted).remove(toBeRemoved).getArray();
			
			System.out.print("Removing an element from array by value: ");
			for (int j = 0; j < removedByValue.length; j++) {
				System.out.print(removedByValue[j] + " ");
			}
			
		} catch (NullPointerException e) {
			System.out.println("Wrong parametrs");
		}
		System.out.println();

		
		System.out.println("Average value: " + new ArrayWrapper<Number>(sorted).findAverageValue());
		System.out.println("Maximal value: " + new ArrayWrapper<Number>(sorted).findMaxValue());
		System.out.println("Minimal value: " + new ArrayWrapper<Number>(sorted).findMinValue());
	}
		


}

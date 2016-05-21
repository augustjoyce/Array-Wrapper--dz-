package com.dz_arraywrapper;
import java.util.Comparator;

/**
 * This class holds an array of ANY object and provides base algorithms to work
 * with them.
 * 
 * 
 * @author August Joyce
 *
 */
public class ArrayWrapper {

	private Number initArray[];

	ArrayWrapper(Number initArray[]) {
		this.initArray = initArray;
	}
	
	

	/**
	 * Get array from the wrapper.
	 * 
	 * @return initArray - array in the wrapper
	 */
	public Number[] getArray() {
		return initArray;

	}

	/**
	 * Add element into array.
	 * 
	 * @param o
	 *            - provided element
	 */
	public ArrayWrapper add(Number num) {
		Number[] tmpArr = new Number[initArray.length + 1];
		System.arraycopy(initArray, 0, tmpArr, 0, initArray.length);
		tmpArr[tmpArr.length - 1] = num;
		return new ArrayWrapper(tmpArr);
	}

	/**
	 * Remove element from array by index.
	 * Should be surrounded with try-catch block.
	 * 
	 * @param index
	 *            - index
	 * @throws NullPointerException -	throws exception if parameters are wrong.
	 * @return ArrayWrapper -	wrapper with new array inside.            
	 */
	public ArrayWrapper remove(int index) throws NullPointerException{
		Number[] tmpArr = new Number[initArray.length];
		System.arraycopy(initArray, 0, tmpArr, 0, initArray.length);
		for (int i = 0; i < tmpArr.length; i++) {
			if (i == index) {
				for (int j = i + 1; j < tmpArr.length; j++) {
					tmpArr[j - 1] = tmpArr[j];

				}
				Number[] tmpArr2 = new Number[tmpArr.length - 1];
				System.arraycopy(tmpArr, 0, tmpArr2, 0, tmpArr.length - 1);
				return new ArrayWrapper(tmpArr2);
			}
		}
		
		return null;

	}

	/**
	 * Remove element from array by value.
	 * Should be surrounded with try-catch block.
	 * 
	 * @param o
	 *            - provided element
	 * @throws NullPointerException -	throws exception if parameters are wrong.    
	 * @return ArrayWrapper -	wrapper with new array inside.         
	 */
	public ArrayWrapper remove(Object o) throws NullPointerException{
		Number[] tmpArr = new Number[initArray.length];
		System.arraycopy(initArray, 0, tmpArr, 0, initArray.length);
		for (int i = 0; i < tmpArr.length; i++) {
			if (o.equals(tmpArr[i])) {
				for (int j = i + 1; j < tmpArr.length; j++) {
					tmpArr[j - 1] = tmpArr[j];
				}
				Number[] tmpArr2 = new Number[tmpArr.length - 1];
				System.arraycopy(tmpArr, 0, tmpArr2, 0, tmpArr.length - 1);
				return new ArrayWrapper(tmpArr2);
			}
		}
		
		return null;

	}

	/**
	 * Sort array for the smallest to the biggest values. Make a copy of
	 * provided array. Use {@link java.util.Comparator}
	 * 
	 * @param comparator
	 *            - provided comparator
	 * @return ArrayWrapper - wrapper with sorted array inside
	 */
	public ArrayWrapper sort(Comparator<Number> comparator) {
		Number tmpNum;
		Number[] tmpArr = new Number[initArray.length];
		System.arraycopy(initArray, 0, tmpArr, 0, initArray.length);
		for (int i = 0; i < tmpArr.length; i++) {
			for (int j = 0; j < tmpArr.length - 1; j++) {
				if (comparator.compare(tmpArr[j], tmpArr[j + 1]) > 0) {
					tmpNum = tmpArr[j];
					tmpArr[j] = tmpArr[j + 1];
					tmpArr[j + 1] = tmpNum;
				}
			}
		}

		return new ArrayWrapper(tmpArr);

	}
	
	/**
	 * Reverse the order of elements in provided array.
	 * 
	 * @return ArrayWrapper - wrapper with reversed array inside
	 */
	public ArrayWrapper reverse(){
		Number[] tmpArr = new Number[initArray.length];
		System.arraycopy(initArray, 0, tmpArr, 0, initArray.length);
		for (int i = 0; i < tmpArr.length/2; i++) {
			Number tmp = tmpArr[i]; 
			tmpArr[i] = tmpArr[tmpArr.length - i - 1];
			tmpArr[tmpArr.length - i - 1] = tmp;
			
		}
		return new ArrayWrapper(tmpArr);
	}
	
	
//--------------------------------------------------------------	
	class MyComparator implements Comparator<Number> {

		
		@Override
		public int compare(Number o1, Number o2) {

			return (o1.intValue() - o2.intValue());
		}
	}

}

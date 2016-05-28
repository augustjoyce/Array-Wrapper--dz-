package com.dz_arraywrapper;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;


/**
 * This class holds an array of ANY object and provides base algorithms to work
 * with them.
 * 
 * 
 * @author August Joyce
 *
 */
public class ArrayWrapper <T extends Number>{
	
	private T initArray[];
	
	ArrayWrapper(T initArray[]) {
		this.initArray = initArray;
	}
	
	ArrayWrapper() {
		
	}
	/**
	 * Initialize an array of defined size.
	 * 
	 * @param size -	size of array.
	 * @return array -	array
	 */
	@SuppressWarnings("unchecked")
	public <K extends Number> K[] createArray(Class<K> clazz, int size) throws NoSuchMethodException, ClassNotFoundException {
        K[] array = (K[]) Array.newInstance(clazz, size);
        return array;
	}

	
	/**
	 * Get array from the wrapper.
	 * 
	 * @return initArray - array in the wrapper
	 */
	public T[] getArray() {
		return initArray;

	}

	/**
	 * Add element into array.
	 * 
	 * @param o
	 *            - provided element
	 * @return ArrayWrapper -		wrapper with new array inside           
	 */
	public ArrayWrapper<Number> add(T o) throws AddingNullException{
		if (o == null) throw new AddingNullException("You have tried to add null");
		Number[] tmpArr = new Number[initArray.length + 1];
		System.arraycopy(initArray, 0, tmpArr, 0, initArray.length);
		tmpArr[tmpArr.length - 1] = o;
		return new ArrayWrapper<Number>(tmpArr);
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
	public ArrayWrapper<Number> remove(int index) throws NullPointerException{
		Number[] tmpArr = new Number[initArray.length];
		System.arraycopy(initArray, 0, tmpArr, 0, initArray.length);
		for (int i = 0; i < tmpArr.length; i++) {
			if (i == index) {
				for (int j = i + 1; j < tmpArr.length; j++) {
					tmpArr[j - 1] = tmpArr[j];

				}
				Number[] tmpArr2 = new Number[tmpArr.length - 1];
				System.arraycopy(tmpArr, 0, tmpArr2, 0, tmpArr.length - 1);
				return new ArrayWrapper<Number>(tmpArr2);
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
	public ArrayWrapper<Number> remove(T o) throws NullPointerException{
		Number[] tmpArr = new Number[initArray.length];
		System.arraycopy(initArray, 0, tmpArr, 0, initArray.length);
		for (int i = 0; i < tmpArr.length; i++) {
			if (o.equals(tmpArr[i])) {
				for (int j = i + 1; j < tmpArr.length; j++) {
					tmpArr[j - 1] = tmpArr[j];
				}
				Number[] tmpArr2 = new Number[tmpArr.length - 1];
				System.arraycopy(tmpArr, 0, tmpArr2, 0, tmpArr.length - 1);
				return new ArrayWrapper<Number>(tmpArr2);
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
	public ArrayWrapper<Number> sort(Comparator<Number> comparator) {
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

		return new ArrayWrapper<Number>(tmpArr);

	}
	
	/**
	 * Reverse the order of elements in provided array.
	 * 
	 * @return ArrayWrapper - wrapper with reversed array inside
	 */
	public ArrayWrapper<Number> reverse(){
		Number[] tmpArr = new Number[initArray.length];
		System.arraycopy(initArray, 0, tmpArr, 0, initArray.length);
		for (int i = 0; i < tmpArr.length/2; i++) {
			Number tmp = tmpArr[i]; 
			tmpArr[i] = tmpArr[tmpArr.length - i - 1];
			tmpArr[tmpArr.length - i - 1] = tmp;
			
		}
		return new ArrayWrapper<Number>(tmpArr);
	}
	
	/**
	 * Find minimal element in array.
	 * @return minValue -	minimal element
	 */
	public Number findMinValue(){
		Number minValue = Long.MAX_VALUE;
		for (int i = 0; i < initArray.length; i++) {
			if (minValue.doubleValue() > initArray[i].doubleValue()) {
				minValue = initArray[i];
			}
		}
		return minValue;
	}
	
	/**
	 * Find maximal element in array.
	 * @return maxValue -	maximal element
	 */
	public Number findMaxValue(){
		Number maxValue = Long.MIN_VALUE;
		for (int i = 0; i < initArray.length; i++) {
			if (maxValue.doubleValue() < initArray[i].doubleValue()) {
				maxValue = initArray[i];
			}
		}
		return maxValue;
	}
	/**
	 * Find an average value of all elements in array.
	 * @return averageValue -	average value
	 */
	public double findAverageValue(){
		double sum = 0d;
		for (int i = 0; i < initArray.length; i++) {
			sum += initArray[i].doubleValue();
		}
		double averageValue = sum/initArray.length;
		return averageValue;
	}
	
//--------------------------------------------------------------	
	class MyComparator implements Comparator<Number> {

		
		@Override
		public int compare(Number o1, Number o2) {

			return (o1.intValue() - o2.intValue());
		}
	}

}

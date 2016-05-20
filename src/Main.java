public class Main {

	public static void main(String[] args) {
		MyComparator comp = new MyComparator();

		Number[] i = { 567, 5.53, 12, 8, 3, -156.22, -32, 423 };

		for (int j = 0; j < i.length; j++) {
			System.out.print(i[j] + " ");
		}

		System.out.println();
//----------------------------------------------------------------
		Number[] added = new ArrayWrapper(i).add(46).getArray();

		
		for (int j = 0; j < added.length; j++) {
			System.out.print(added[j] + " ");
		}

		System.out.println();
//----------------------------------------------------------------
		Number[] sorted = new ArrayWrapper(added).sort(comp).getArray();

		for (int j = 0; j < sorted.length; j++) {
			System.out.print(sorted[j] + " ");
		}

		System.out.println();
//----------------------------------------------------------------
		try {
			Number[] removed = new ArrayWrapper(sorted).remove(6).getArray();
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
			for (int j = 0; j < removed2.length; j++) {
				System.out.print(removed2[j] + " ");
			}
		} catch (NullPointerException e) {
			System.out.println("Wrong parametrs");
		}
	}

}

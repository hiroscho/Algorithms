package praktikum1;

public class MainApp {

	public static void main(String[] args) {
		long startTime, difTime;
		int N = 20;

		// startTime = System.nanoTime();
		// createBinaryStrings(N);
		// difTime = (System.nanoTime() - startTime) / 1000000;
		// System.out.println("Time taken: " + difTime + "ms");

		N = 50;
		String symbols = createSymbols(N);

		startTime = System.nanoTime();
		char[] permutation = new char[N];
		permutation(0, symbols, permutation);
		difTime = (System.nanoTime() - startTime) / 1000000;
		System.out.println("Time taken: " + difTime + "ms");

	}

	// N=20: 70ms
	// N=21: 107ms
	// N=50: 70ms * (2^50/2^20) = 75161927680ms
	private static void createBinaryStrings(int n) {
		for (int i = 0; i < Math.pow(2, n); i++) {
			Integer.toBinaryString(i);
		}
	}

	private static String createSymbols(int n) {
		String symbols = "";
		for (int i = 49; i < 49 + n; i++) {
			symbols += (char) i;
		}
		return symbols;
	}

	// N=8: 22ms
	// N=9: 96ms
	// N=50: 22ms * (50! / 8!) = 1.6594991e+61ms
	private static void permutation(int pos, String symbols, char[] perm) {
		if(pos == perm.length) {
		} else {
			for(int i = 0; i< symbols.length(); i++) {
				perm[pos] = symbols.charAt(i);
				String front = symbols.substring(0, i);
				String back = symbols.substring(i+1, symbols.length());
				permutation(pos+1, front + back, perm);
			}
		}
	}

}

public class Recursion {

	public static boolean palindrome(String s) {
		if (s == null) { // returns true or false dependant on if palindrome
			return false;
		}
		String reversed = reverseString(s);
		return s.equals(reversed);
	}

	public static String reverseString(String s) {
		if (s == null) { // returns reverse
			return null;
		}
		if (s.length() <= 1) {
			return s;
		}
		return reverseString(s.substring(1)) + s.charAt(0);

	}

	public static int handshakes(int n) {
		if (n == 0) { // base
			return 0;
		}
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else {
			return handshakes(n - 1) + n - 1; // recursive
		}
	}

	public static long ackermann(long m, long n) {
		if (m == 0) // base
		{
			return n + 1;
		}
		if (n == 0) // recursive
		{
			return ackermann(m - 1, 1);
		} else // recursive
		{
			return ackermann(m - 1, ackermann(m, n - 1));
		}
	}

	public static void main(String[] args) {
		System.out.println(palindrome("racecar")); // expected true
		System.out.println(palindrome("abba")); // expected true
		System.out.println(palindrome("cat")); // expected false
		System.out.println(palindrome("cake")); // expected false
		System.out.println(reverseString("racecar")); // expected racecar
		System.out.println(reverseString("CS")); // expected SC
		System.out.println(handshakes(0)); // expected 0
		System.out.println(handshakes(3)); // expected 3
		System.out.println(handshakes(6)); // expected 15
		System.out.println(ackermann(0, 0)); // expected 1
		System.out.println(ackermann(3, 4)); // expected 125
	}

}

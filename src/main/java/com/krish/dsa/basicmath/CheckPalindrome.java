package com.krish.dsa.basicmath;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
 <pre>
User: vsingams
Date: 24-Mar-2025
 </pre>
*/

/*
 * Given an integer x, return true if x is a palindrome, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 */
public class CheckPalindrome {

	public static void main(String[] args) {

	}

	boolean isPalindrome(int n) {
		ReverseInteger reverseInteger = new ReverseInteger();
		int result = reverseInteger.reverse(n);

		if (result < 0)
			return false;

		return result == n;
	}

	@ParameterizedTest
	@ValueSource(ints = { 121 })
	void test121(int n) {
		boolean result = isPalindrome(n);
		assertTrue(result);
	}

	@ParameterizedTest
	@ValueSource(ints = { -121 })
	void testMinus121(int n) {
		boolean result = isPalindrome(n);
		assertFalse(result);
	}

	@ParameterizedTest
	@ValueSource(ints = { 1534236469 })
	void test1534236469(int n) {
		boolean result = isPalindrome(n);
		assertFalse(result);
	}
}

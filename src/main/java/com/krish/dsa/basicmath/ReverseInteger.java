package com.krish.dsa.basicmath;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
 <pre>
User: vsingams
Date: 24-Mar-2025
 </pre>
*/

/*
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1
 */
public class ReverseInteger {

	public static void main(String[] args) {

	}

	int reverse(int n) {
		int reverse = 0;

		boolean isNegative = n < 0;

		if (isNegative)
			n *= -1;

		while (n > 0) {
			int remainder = n % 10;

			// To check the overflow, check for reverse > Integer.MAX_VALUE / 10 as we are
			// multiplying by 10 in the next statement
			if (reverse > Integer.MAX_VALUE / 10)
				return 0;

			reverse = reverse * 10 + remainder;
			n /= 10;
		}

		if (isNegative)
			return reverse * -1;

		return reverse;
	}

	@ParameterizedTest
	@ValueSource(ints = { 123 })
	void testFor123(int n) {
		int result = reverse(n);
		assertEquals(321, result);
	}

	@ParameterizedTest
	@ValueSource(ints = { -321 })
	void testForMinus321(int n) {
		int result = reverse(n);
		assertEquals(-123, result);
	}

	@ParameterizedTest
	@ValueSource(ints = { 120 })
	void testForMinus120(int n) {
		int result = reverse(n);
		assertEquals(21, result);
	}

	@ParameterizedTest
	@ValueSource(ints = { 1534236469 })
	void testFor1534236469(int n) {
		int result = reverse(n);
		assertEquals(0, result);
	}
}

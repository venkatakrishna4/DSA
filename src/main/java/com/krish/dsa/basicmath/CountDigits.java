package com.krish.dsa.basicmath;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.LoggerFactory;

/*
 * <pre>
User: vsingams
Date: 24-Mar-2025
 * </pre>
 */

/*
 * Given a positive integer n, count the number of digits in n that divide
 * n evenly (i.e., without leaving a remainder). Return the total number of such
 * digits.
 * 
 * A digit d of n divides n evenly if the remainder when n is divided by d is 0
 * (n % d == 0). Digits of n should be checked individually. If a digit is 0, it
 * should be ignored because division by 0 is undefined.
 * 
 * Examples :
 * 
 * Input: n = 12 Output: 2 Explanation: 1, 2 when both divide 12 leaves
 * remainder 0. Input: n = 2446 Output: 1 Explanation: Here among 2, 4, 6 only 2
 * divides 2446 evenly while 4 and 6 do not. Input: n = 23 Output: 0
 * Explanation: 2 and 3, none of them divide 23 evenly. Constraints: 1<= n <=105
 * 
 */
public class CountDigits {

	public static void main(String[] args) {
		int number = 12;

		CountDigits countDigits = new CountDigits();
		int result = countDigits.evenlyDivides(number);

		LoggerFactory.getLogger(CountDigits.class).info("Result: {}", result);
	}

	int evenlyDivides(int n) {
		int originalNumber = n;
		int count = 0;

		while (n > 0) {
			int remainder = n % 10;
			if (remainder != 0 && originalNumber % remainder == 0)
				count++;
			n /= 10;
		}

		return count;
	}

	@ParameterizedTest
	@ValueSource(ints = { 12 })
	void dividesSuccessFor12(int n) {
		int result = evenlyDivides(n);
		assertEquals(2, result);
	}

	@ParameterizedTest
	@ValueSource(ints = { 2446 })
	void dividesSuccessFor2446(int n) {
		int result = evenlyDivides(n);
		assertEquals(1, result);
	}

	@ParameterizedTest
	@ValueSource(ints = { 1000 })
	void dividesSuccessFor1000(int n) {
		int result = evenlyDivides(n);
		assertEquals(1, result);
	}

	@ParameterizedTest
	@ValueSource(ints = { 23 })
	void dividesSuccessFor23(int n) {
		int result = evenlyDivides(n);
		assertEquals(0, result);
	}
}

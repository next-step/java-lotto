package com.java.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.java.stringcalculator.StringCalculator;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
	String input;
	StringCalculator stringCalculator;

	@BeforeEach
	public void setup() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void 숫자_하나_입력시_해당_숫자_반환() {
		input = "10";
		int output = stringCalculator.calculator(input);
		assertThat(output).isEqualTo(Integer.parseInt(input));
	}

	@Test
	public void 쉼표_구분자_숫자_두개_입력시_합계를_반환() {
		input = "2,3";
		int sum = stringCalculator.calculator(input);
		assertThat(sum).isEqualTo(5);
	}

	@Test
	public void 콜론_구분자_숫자_두개_입력시_합계를_반환() {
		input = "2:3";
		int sum = stringCalculator.calculator(input);
		assertThat(sum).isEqualTo(5);
	}

	@Test
	public void 쉼표_콜론_구분자_숫자_두개_입력시_합계를_반환() {
		input = "1:3,1";
		int sum = stringCalculator.calculator(input);
		assertThat(sum).isEqualTo(5);
	}

	@Test
	public void 커스텀_구분자_숫자_두개_입력시_합계를_반환() {
		input = "//;\n2;3";
		int sum = stringCalculator.calculator(input);
		assertThat(sum).isEqualTo(5);
	}

	@Test
	public void 빈_문자열_입력시_0_반환() {
		input = "";
		int output = stringCalculator.calculator(input);
		assertThat(output).isEqualTo(0);
	}

	@Test
	public void NULL_입력시_0_반환() {
		input = null;
		int output = stringCalculator.calculator(input);
		assertThat(output).isEqualTo(0);
	}

	@Test
	public void 음수_입력시_RuntimeException() {
		input = "-1";
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
			stringCalculator.calculator(input);
		});
	}

	@Test
	public void 숫자_이외의_값_입력시_RuntimeException() {
		input = "a";
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
			stringCalculator.calculator(input);
		});
	}

}

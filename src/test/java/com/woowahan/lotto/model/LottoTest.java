package com.woowahan.lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.woowahan.lotto.constant.Message;

class LottoTest {

	@DisplayName("of 메서드에 List<Integer> 형태의 파라미터를 전달하면 Lotto객체를 생성할 수 있다.")
	@ParameterizedTest
	@MethodSource("argOf")
	void of(List<Integer> numbers) {

		assertThat(Lotto.of(numbers)).isInstanceOf(Lotto.class);

	}

	public static Stream<Arguments> argOf() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 10, 20, 30, 40, 45)),
			Arguments.of(Arrays.asList(2, 5, 15, 25, 35, 40)),
			Arguments.of(Arrays.asList(3, 7, 17, 27, 37, 42))
		);
	}

	@DisplayName("of 메서드에 1 ~ 45 사이가 아닌 숫자가 전달되면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfThrowWrongNumber")
	void ofWrongNumber(List<Integer> numbers) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Lotto.of(numbers);
			}).withMessage(Message.MSG_ERROR_LOTTO_NUMBER);
	}

	public static Stream<Arguments> argOfThrowWrongNumber() {
		return Stream.of(
			Arguments.of(Arrays.asList(0, 10, 20, 30, 40, 45)),
			Arguments.of(Arrays.asList(-5, 5, 15, 25, 35, 40)),
			Arguments.of(Arrays.asList(3, 7, 17, 27, 37, 46)),
			Arguments.of(Arrays.asList(-3, -7, -17, -27, -37, -45)),
			Arguments.of(Arrays.asList(46, 56, 76, 86, 96, 100))
		);
	}

	@DisplayName("of 메서드에 전달된 파라미터 List 사이즈가 6이 아니면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfWrongSize")
	void ofWrongSize(List<Integer> numbers) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Lotto.of(numbers);
			}).withMessage(Message.MSG_ERROR_LOTTO_NUMBER);
	}

	public static Stream<Arguments> argOfWrongSize() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
			Arguments.of(Arrays.asList(45, 44, 43, 42)),
			Arguments.of(Arrays.asList(45, 44, 43, 42, 41, 40, 39))
		);
	}
}
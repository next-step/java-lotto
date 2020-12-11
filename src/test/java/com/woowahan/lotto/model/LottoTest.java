package com.woowahan.lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.woowahan.lotto.constant.Message;

class LottoTest {

	@DisplayName("of 메서드에 List<Integer> 형태의 파라미터를 전달하면 Lotto객체를 생성할 수 있다.")
	@ParameterizedTest
	@MethodSource("argOf")
	void of(List<LottoNo> numbers) {

		assertThat(Lotto.of(numbers)).isInstanceOf(Lotto.class);

	}

	@DisplayName("of 메서드에 LottoGenerator 형태의 파라미터를 전달하면 Lotto객체를 생성할 수 있다.")
	@Test
	void ofGenerator() {

		assertThat(Lotto.of(new LottoAutoGenerator())).isInstanceOf(Lotto.class);

	}

	public static Stream<Arguments> argOf() {
		return Stream.of(
			Arguments.of(Arrays.asList(LottoNo.of(1), LottoNo.of(10), LottoNo.of(20), LottoNo.of(30), LottoNo.of(40), LottoNo.of(45))),
			Arguments.of(Arrays.asList(LottoNo.of(2), LottoNo.of(5), LottoNo.of(15), LottoNo.of(25), LottoNo.of(35), LottoNo.of(40))),
			Arguments.of(Arrays.asList(LottoNo.of(3), LottoNo.of(7), LottoNo.of(17), LottoNo.of(27), LottoNo.of(37), LottoNo.of(42)))
		);
	}

	@DisplayName("of 메서드에 전달된 파라미터 List 사이즈가 6이 아니면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfWrongSize")
	void ofWrongSize(List<LottoNo> numbers) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Lotto.of(numbers);
			}).withMessage(Message.MSG_ERROR_LOTTO_NUMBER);
	}

	public static Stream<Arguments> argOfWrongSize() {
		return Stream.of(
			Arguments.of(Arrays.asList(LottoNo.of(1), LottoNo.of(10), LottoNo.of(20), LottoNo.of(30), LottoNo.of(40))),
			Arguments.of(Arrays.asList(LottoNo.of(2), LottoNo.of(5), LottoNo.of(15), LottoNo.of(25), LottoNo.of(35), LottoNo.of(40), LottoNo.of(45))),
			Arguments.of(Arrays.asList(LottoNo.of(3), LottoNo.of(7), LottoNo.of(17), LottoNo.of(27), LottoNo.of(37), LottoNo.of(42), LottoNo.of(43), LottoNo.of(45)))
		);
	}
}
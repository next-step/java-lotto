package com.woowahan.lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.woowahan.lotto.constant.Message;

class WinNumbersTest {

	@DisplayName("of 메서드는 로또번호에 만족하는 6개의 숫자가 쉼표로 구분되는 하나의 문자열(당첨번호)과 숫자하나인문자(보너스넘버)를 전달하면 WinNumbers 객체를 생성한다.")
	@ParameterizedTest
	@MethodSource("argOf")
	void of(String winNumbers, String bonusNumber) {

		WinNumbers result = WinNumbers.of(winNumbers, bonusNumber);
		assertThat(result).isInstanceOf(WinNumbers.class);
	}

	public static Stream<Arguments> argOf() {
		return Stream.of(
			Arguments.of("1,2,3,4,5,6", "45"),
			Arguments.of("45, 44, 43, 42, 41, 40", "1"),
			Arguments.of("1, 15, 25, 35, 40, 45", "10")
		);
	}

	@DisplayName("of 메서드에 첫번째 파라미터(당첨번호)에 숫자가 아닌 문자 또는 null 또는 empty문자를 전달하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfNotNumber")
	void ofNotNumber(String winNumbers, String bonusNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				WinNumbers.of(winNumbers, bonusNumber);
			}).withMessage(Message.MSG_NULL_OR_EMPTY);
	}

	public static Stream<Arguments> argOfNotNumber() {
		return Stream.of(
			Arguments.of("", "45"),
			Arguments.of(null, "1")
		);
	}

	@DisplayName("of 메서드 첫번째 파라미터(당첨번호)에 쉼표로 구분되는 문자가 6개가 아니면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfLength")
	void ofLength(String winNumbers, String bonusNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				WinNumbers.of(winNumbers, bonusNumber);
			}).withMessage(Message.MSG_WRONG_NUMBER);
	}

	public static Stream<Arguments> argOfLength() {
		return Stream.of(
			Arguments.of("1,2,3,4,5", "45"),
			Arguments.of("1,2,3,4,5,6,7", "10")
		);
	}

	@DisplayName("of 메서드 첫번째 파라미터(당첨번호)에 쉼표로 구분되는 문자에 숫자가 아닌 문자가 포함되면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfHasNotNumber")
	void ofHasNotNumber(String winNumbers, String bonusNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				WinNumbers.of(winNumbers, bonusNumber);
			}).withMessage(Message.MSG_WRONG_NUMBER);
	}

	public static Stream<Arguments> argOfHasNotNumber() {
		return Stream.of(
			Arguments.of("a,2,3,4,5,6", "45"),
			Arguments.of("null,2,3,4,5,6", "1"),
			Arguments.of("1,,3,4,5,6", "45")
		);
	}

	@DisplayName("of 메서드 첫번째 파라미터(당첨번호)에 쉼표로 구분되는 문자에 1과 45 사이가 아닌 문자가 포함되면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfHasWrongNumber")
	void ofHasWrongNumber(String winNumbers, String bonusNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				WinNumbers.of(winNumbers, bonusNumber);
			}).withMessage(Message.MSG_WRONG_NUMBER);
	}

	public static Stream<Arguments> argOfHasWrongNumber() {
		return Stream.of(
			Arguments.of("0,2,3,4,5,6", "45"),
			Arguments.of("1,2,3,4,5,46", "1")
		);
	}

	@DisplayName("of 메서드 두번째 파라미터(보너스번호)에 숫자가 아닌 문자 또는 null 또는 empty문자를 전달하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfBonusNotNumber")
	void ofBonusNotNumber(String winNumbers, String bonusNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				WinNumbers.of(winNumbers, bonusNumber);
				;
			}).withMessage(Message.MSG_WRONG_BONUS_NUMBER);

	}

	public static Stream<Arguments> argOfBonusNotNumber() {
		return Stream.of(
			Arguments.of("1,2,3,4,5,6", ""),
			Arguments.of("1, 15, 25, 35, 40, 45", null),
			Arguments.of("1, 15, 25, 35, 40, 45", "a"),
			Arguments.of("1, 15, 25, 35, 40, 45", "!"),
			Arguments.of("1, 15, 25, 35, 40, 45", "a3517")
		);
	}

	@DisplayName("of 메서드 두번째 파라미터(보너스번호)에 1에서 45사이가 아닌 숫자인 문자가 전달되면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfBonusWrongNumber")
	void ofBonusWrongNumber(String winNumbers, String bonusNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				WinNumbers.of(winNumbers, bonusNumber);
			}).withMessage(Message.MSG_WRONG_BONUS_NUMBER);

	}

	public static Stream<Arguments> argOfBonusWrongNumber() {
		return Stream.of(
			Arguments.of("1,2,3,4,5,6", "0"),
			Arguments.of("1, 15, 25, 35, 40, 45", "46"),
			Arguments.of("1, 15, 25, 35, 40, 45", "-1"),
			Arguments.of("1, 15, 25, 35, 40, 45", "-45")
		);
	}

	@DisplayName("of 메서드 두번째 파라미터(보너스번호)가 첫번째 파라미터의 숫자들과 중복되면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfDuplicate")
	void ofDuplicate(String winNumbers, String bonusNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				WinNumbers.of(winNumbers, bonusNumber);
			}).withMessage(Message.MSG_WRONG_DUPLICATE);

	}

	public static Stream<Arguments> argOfDuplicate() {
		return Stream.of(
			Arguments.of("1,2,3,4,5,6", "1"),
			Arguments.of("1, 15, 25, 35, 40, 45", "45")
		);
	}

}
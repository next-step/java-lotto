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

class PurchaseInputTest {

	@DisplayName("of 메서드는 1000의 배수의 숫자로된 문자 값과 수동 로또 구매번호(쉼표로 이루어진 6개의 숫자문자열리스트)를 전달 받으면 PurchaseInput 인스턴스를 반환한다.")
	@ParameterizedTest
	@MethodSource("argOf")
	void of(String amount, List<String> manualNumbers) {

		PurchaseInput result = PurchaseInput.of(amount, manualNumbers);
		assertThat(result).isInstanceOf(PurchaseInput.class);
	}

	public static Stream<Arguments> argOf() {
		return Stream.of(
			Arguments.of("1000", Arrays.asList("1,2,3,4,5,6")),
			Arguments.of("2000", Arrays.asList("40,41,42,43,44,45")),
			Arguments.of("3000", Arrays.asList("1,2,3,4,5,6", "40,41,42,43,44,45")),
			Arguments.of("10000", Arrays.asList("1,2,3,4,5,6", "40,41,42,43,44,45", "10,15,20,25,35,40")),
			Arguments.of("1000000", Arrays.asList("1,2,3,4,5,6"))
		);
	}

	@DisplayName("of 메서드 첫번째 파라미터에 숫자가 아닌 문자 또는 null 또는 empty문자를 전달하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfNotNumber")
	void ofNotNumber(String amount, List<String> manualNumbers) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				PurchaseInput.of(amount, manualNumbers);
			}).withMessage(Message.MSG_WRONG_AMOUNT);
	}

	public static Stream<Arguments> argOfNotNumber() {
		return Stream.of(
			Arguments.of("a", Arrays.asList("1,2,3,4,5,6")),
			Arguments.of("!", Arrays.asList("40,41,42,43,44,45")),
			Arguments.of("a3517", Arrays.asList("1,2,3,4,5,6", "40,41,42,43,44,45")),
			Arguments.of(null, Arrays.asList("1,2,3,4,5,6", "40,41,42,43,44,45", "10,15,20,25,35,40")),
			Arguments.of("", Arrays.asList("1,2,3,4,5,6"))
		);
	}

	@DisplayName("of 메소드 첫번째 파라미터에 0또는 음수 문자를 입력하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfZeroOrNegative")
	void ofZeroOrNegative(String amount, List<String> manualNumbers) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				PurchaseInput.of(amount, manualNumbers);
			}).withMessage(Message.MSG_WRONG_AMOUNT);
	}

	public static Stream<Arguments> argOfZeroOrNegative() {
		return Stream.of(
			Arguments.of("0", Arrays.asList("1,2,3,4,5,6")),
			Arguments.of("-5", Arrays.asList("40,41,42,43,44,45")),
			Arguments.of("-100", Arrays.asList("1,2,3,4,5,6", "40,41,42,43,44,45"))
		);
	}

	@DisplayName("of 메소드 첫번째 파라미터가 1000으로 나누어서 나머지가 남는 값을 전달할 경우 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argExistRemainder")
	void existRemainder(String amount, List<String> manualNumbers) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				PurchaseInput.of(amount, manualNumbers);
			}).withMessage(Message.MSG_WRONG_AMOUNT);
	}

	public static Stream<Arguments> argExistRemainder() {
		return Stream.of(
			Arguments.of("11", Arrays.asList("1,2,3,4,5,6")),
			Arguments.of("1001", Arrays.asList("40,41,42,43,44,45")),
			Arguments.of("10010", Arrays.asList("1,2,3,4,5,6", "40,41,42,43,44,45"))
		);
	}

	////

	@DisplayName("of 메서드에 두번째 파라미터(수동번호)에 숫자가 아닌 문자 또는 null 또는 empty문자를 전달하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfManualNotNumber")
	void ofManualNotNumber(String amount, List<String> manualNumbers) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				PurchaseInput.of(amount, manualNumbers);
			}).withMessage(Message.MSG_NULL_OR_EMPTY);
	}

	public static Stream<Arguments> argOfManualNotNumber() {
		return Stream.of(
			Arguments.of("1000", Arrays.asList("", "1,2,3,4,5,6")),
			Arguments.of("2000", Arrays.asList(null, "1,2,3,4,5,6"))
		);
	}

	@DisplayName("of 메서드 두번째 파라미터(수동번호)에 쉼표로 구분되는 문자가 6개가 아니면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfLength")
	void ofLength(String amount, List<String> manualNumbers) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				PurchaseInput.of(amount, manualNumbers);
			}).withMessage(Message.MSG_WRONG_NUMBER);
	}

	public static Stream<Arguments> argOfLength() {
		return Stream.of(
			Arguments.of("1000", Arrays.asList("1,2,3,4,5")),
			Arguments.of("2000", Arrays.asList("1,2,3,4,5,6,7")),
			Arguments.of("10000", Arrays.asList("40,41,42,43,44,45,100"))
		);
	}

	@DisplayName("of 메서드 두번째 파라미터(수동번호)에 쉼표로 구분되는 문자에 숫자가 아닌 문자가 포함되면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfHasNotNumber")
	void ofHasNotNumber(String amount, List<String> manualNumbers) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				PurchaseInput.of(amount, manualNumbers);
			}).withMessage(Message.MSG_WRONG_NUMBER);
	}

	public static Stream<Arguments> argOfHasNotNumber() {
		return Stream.of(
			Arguments.of("1000", Arrays.asList("1,null,3,4,5,6")),
			Arguments.of("2000", Arrays.asList("40,,42,43,44,45")),
			Arguments.of("10000", Arrays.asList("1,2,3,4,5,a", "40,41,42,43,44,45"))
		);
	}

	@DisplayName("of 메서드 두번째 파라미터(수동번호)에 쉼표로 구분되는 문자에 1과 45 사이가 아닌 문자가 포함되면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfHasWrongNumber")
	void ofHasWrongNumber(String amount, List<String> manualNumbers) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				PurchaseInput.of(amount, manualNumbers);
			}).withMessage(Message.MSG_WRONG_NUMBER);
	}

	public static Stream<Arguments> argOfHasWrongNumber() {
		return Stream.of(
			Arguments.of("1000", Arrays.asList("0,2,3,4,5,6")),
			Arguments.of("2000", Arrays.asList("40,41,42,43,44,46")),
			Arguments.of("10000", Arrays.asList("0,2,3,4,5,6", "40,41,42,43,44,46"))
		);
	}

	@DisplayName("구입 금액보다 수동로또수가 크면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argOfOverManual")
	void ofOverManual(String amount, List<String> manualNumbers) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				PurchaseInput.of(amount, manualNumbers);
			}).withMessage(Message.MSG_WRONG_MANUAL_COUNT);
	}

	public static Stream<Arguments> argOfOverManual() {
		return Stream.of(
			Arguments.of("1000", Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,45")),
			Arguments.of("2000", Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,45", "3,7,9,4,5,45"))
		);
	}

}
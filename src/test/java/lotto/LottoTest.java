package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.Lotto;
import lotto.domain.LottoNum;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.ErrorMessage;

class LottoTest {

	static Stream<Arguments> providerOfGettingMatchingCountArguments() {
		return Stream.of(
			Arguments.arguments(Stream.of(1, 2, 3, 4, 5, 6)
				.map(LottoNum::of)
				.collect(Collectors.toList()), Stream.of(1, 2, 3, 4, 5, 6)
				.map(LottoNum::of)
				.collect(Collectors.toList()), 6),
			Arguments.arguments(Stream.of(1, 2, 3, 4, 5, 6)
				.map(LottoNum::of)
				.collect(Collectors.toList()), Stream.of(1, 2, 3, 4, 5, 7)
				.map(LottoNum::of)
				.collect(Collectors.toList()), 5),
			Arguments.arguments(Stream.of(1, 2, 3, 4, 5, 6)
				.map(LottoNum::of)
				.collect(Collectors.toList()), Stream.of(1, 2, 3, 4, 7, 8)
				.map(LottoNum::of)
				.collect(Collectors.toList()), 4),
			Arguments.arguments(Stream.of(1, 2, 3, 4, 5, 6)
				.map(LottoNum::of)
				.collect(Collectors.toList()), Stream.of(1, 2, 3, 7, 8, 9)
				.map(LottoNum::of)
				.collect(Collectors.toList()), 3),
			Arguments.arguments(Stream.of(1, 2, 3, 4, 5, 6)
				.map(LottoNum::of)
				.collect(Collectors.toList()), Stream.of(1, 2, 7, 8, 9, 10)
				.map(LottoNum::of)
				.collect(Collectors.toList()), 2),
			Arguments.arguments(Stream.of(1, 2, 3, 4, 5, 6)
				.map(LottoNum::of)
				.collect(Collectors.toList()), Stream.of(1, 7, 8, 9, 10, 11)
				.map(LottoNum::of)
				.collect(Collectors.toList()), 1)
		);
	}

	static Stream<Arguments> providerOfDuplicatedLottoArguments() {
		return Stream.of(
			Arguments.arguments(Stream.of(1, 1, 3, 4, 5, 6)
				.map(LottoNum::of)
				.collect(Collectors.toList())),
			Arguments.arguments(Stream.of(1, 2, 3, 3, 3, 6)
				.map(LottoNum::of)
				.collect(Collectors.toList())),
			Arguments.arguments(Stream.of(1, 2, 6, 6, 6, 6)
				.map(LottoNum::of)
				.collect(Collectors.toList()))
		);
	}

	@DisplayName("Default Constructor로 로또를 생성하면 여섯개의 숫자를 생성한다.")
	@Test
	void Should_Have_Six_Number_When_Create_Lotto_By_Deafult_Constructor() {
		Lotto lotto = new Lotto();

		assertThat(lotto.getNumbers().size()).isEqualTo(Lotto.LOTTO_NUMBER_QUANTITY);
	}

	@DisplayName("생성된 로또의 여섯가지 숫자는 1~45 사이의 숫자이어야 한다.")
	@Test
	void Should_Be_Between_1_And_45_When_Create_Lotto() {
		Lotto lotto = new Lotto();

		assertThat(lotto.getNumbers().stream()
			.allMatch(number -> number.getValue() >= 1 && number.getValue() <= 45))
			.isTrue();
	}

	@DisplayName("당첨 번호를 입력하면 당첨된 숫자의 갯수를 반환한다.")
	@ParameterizedTest
	@MethodSource("providerOfGettingMatchingCountArguments")
	void Should_Return_Count_Of_Matching_Numbers_When_Enter_Winning_Numbers(
		List<LottoNum> winningNumbers,
		List<LottoNum> lottoNumbers,
		int expected
	) {
		Lotto lotto = new Lotto(lottoNumbers);

		assertThat(lotto.getMatchingCount(winningNumbers)).isEqualTo(expected);
	}

	@DisplayName("중복된 숫자가 있으면 중복 예외를 던진다.")
	@ParameterizedTest
	@MethodSource("providerOfDuplicatedLottoArguments")
	void Should_Throw_Duplicate_Exception_When_Lotto_Has_Duplicated_Number(
		List<LottoNum> duplicatedNumbers) {
		assertThatThrownBy(() -> {
			Lotto lotto = new Lotto(duplicatedNumbers);
		}).isInstanceOf(DuplicateLottoNumberException.class)
			.hasMessage(ErrorMessage.LOTTO_NUMBERS_MUST_NOT_BE_DUPLICATED.getMessage());
	}

}

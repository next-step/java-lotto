package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.Lotto;

class LottoTest {

	static Stream<Arguments> providerOfGettingMatchingCountArguments() {
		return Stream.of(
			Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 6),
			Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7), 5),
			Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 7, 8), 4),
			Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 7, 8, 9), 3),
			Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 7, 8, 9, 10), 2),
			Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 7, 8, 9, 10, 11), 1)
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
			.allMatch(number -> number >= 1 && number <= 45))
			.isTrue();
	}

	@DisplayName("당첨 번호를 입력하면 당첨된 숫자의 갯수를 반환한다.")
	@ParameterizedTest
	@MethodSource("providerOfGettingMatchingCountArguments")
	void Should_Return_Count_Of_Matching_Numbers_When_Enter_Winning_Numbers(
		List<Integer> winningNumbers,
		List<Integer> lottoNumbers,
		int expected
	) {
		Lotto lotto = new Lotto(lottoNumbers);
		assertThat(lotto.getMatchingCount(winningNumbers)).isEqualTo(expected);

	}

}

package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoValidatorTest {

	@DisplayName("추첨 번호와 당첨번호가 일치하는 개수에 따라서 Rank가 정해진다.")
	@ParameterizedTest
	@MethodSource("lottoNumbersAndRank")
	void test(Rank rank, Rank expected) {
		assertThat(rank).isEqualTo(expected);
	}

	static Stream<Arguments> lottoNumbersAndRank() {
		LottoValidator validator = new LottoValidator(1, 2, 3, 4, 5, 6);
		return Stream.of(
			Arguments.arguments(validator.valid(new LottoTicket(1, 2, 3, 4, 5, 6)), Rank.FIRST),
			Arguments.arguments(validator.valid(new LottoTicket(1, 2, 3, 4, 5, 7)), Rank.SECOND),
			Arguments.arguments(validator.valid(new LottoTicket(1, 2, 3, 4, 7, 8)), Rank.THIRD),
			Arguments.arguments(validator.valid(new LottoTicket(1, 2, 3, 7, 8, 9)), Rank.FOURTH),
			Arguments.arguments(validator.valid(new LottoTicket(1, 2, 7, 8, 9, 10)), Rank.NOT)
		);
	}
}

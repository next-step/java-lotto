package lotto;

import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinnerNumbers;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {

	@DisplayName("로또 번호가 일치하는 수에 따라서 등수를 나타내는 기능 테스트")
	@ParameterizedTest
	@MethodSource("sortNumbers")
	void 로또_등수_TEST(LottoNumbers targetLotto, Rank rank) {
		LottoNumbers lastWeekLottoNumbers = LottoNumberGenerator.ofInput("8, 21, 23, 41, 42, 43");
		LottoWinnerNumbers lottoWinnerNumbers = new LottoWinnerNumbers(lastWeekLottoNumbers);
		assertThat(LottoResult.matchesRank(targetLotto, lottoWinnerNumbers)).isEqualTo(rank);
	}

	public static Stream<Arguments> sortNumbers() {
		return Stream.of(
			Arguments.of(LottoNumberGenerator.ofInput("8, 21, 23, 41, 42, 43"), Rank.FIRST),
			Arguments.of(LottoNumberGenerator.ofInput("1, 2, 3, 41, 42, 43"), Rank.FIFTH),
			Arguments.of(LottoNumberGenerator.ofInput("1, 2, 3, 4, 5, 6"), Rank.MISS),
			Arguments.of(LottoNumberGenerator.ofInput("6, 7, 8, 9, 10"), Rank.MISS)
		);
	}

	@DisplayName("지난 주 당첨 번호와 비교해서 예측하는 당첨 통계와 일치하는지?")
	@Test
	void 당첨_통계_테스트() {
		LottoNumbers winnerNumber = LottoNumberGenerator.ofInput("8, 21, 23, 41, 42, 43");

		List<LottoNumbers> lottoTicket = new ArrayList();
		lottoTicket.add(LottoNumberGenerator.ofInput("8, 21, 23, 41, 42, 43"));
		lottoTicket.add(LottoNumberGenerator.ofInput("1, 2, 3, 41, 42, 43"));
		lottoTicket.add(LottoNumberGenerator.ofInput("1, 2, 3, 4, 5, 6"));
		lottoTicket.add(LottoNumberGenerator.ofInput("6, 7, 8, 9, 10"));

		LottoTicket lottoTicket1 = new LottoTicket(lottoTicket);

		LottoWinnerNumbers lottoWinnerNumbers = new LottoWinnerNumbers(winnerNumber);
		LottoResult lottoResults = LottoResult.compareTicketAndWinner(lottoTicket1, lottoWinnerNumbers);

		assertThat(lottoResults.askCountOfRank(Rank.FIFTH)).isEqualTo(1);
		assertThat(lottoResults.askCountOfRank(Rank.FIRST)).isEqualTo(1);
		assertThat(lottoResults.askCountOfRank(Rank.MISS)).isEqualTo(2);
	}

}

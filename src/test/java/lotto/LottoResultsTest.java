package lotto;

import lotto.domain.GenerateLottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.LottoResults;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinnerNumbers;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {

	@DisplayName("일치 수에 따라 등수를 가져온다")
	@Test
	void 로또_결과() {
		LottoResult lottoResult = new LottoResult(6);
		assertThat(lottoResult.isMatchesRank(Rank.WINNER)).isTrue();
	}

	@DisplayName("로또 번호가 일치하는 수에 따라서 등수를 나타내는 기능 테스트")
	@ParameterizedTest
	@MethodSource("sortNumbers")
	void 로또_등수_TEST(LottoNumbers targetLotto, Rank rank) {
		LottoNumbers lastWeekLottoNumbers = GenerateLottoNumber.manual(Arrays.asList(8, 21, 23, 41, 42, 43));
		LottoWinnerNumbers lottoWinnerNumbers = new LottoWinnerNumbers(lastWeekLottoNumbers);
		assertThat(LottoResult.compareNumbers(targetLotto, lottoWinnerNumbers).isMatchesRank(rank)).isTrue();
	}

	public static Stream<Arguments> sortNumbers() {
		return Stream.of(
			Arguments.of(GenerateLottoNumber.manual(Arrays.asList(8, 21, 23, 41, 42, 43)), Rank.WINNER),
			Arguments.of(GenerateLottoNumber.manual(Arrays.asList(1, 2, 3, 41, 42, 43)), Rank.FOURTH),
			Arguments.of(GenerateLottoNumber.manual(Arrays.asList(1, 2, 3, 4, 5, 6)), Rank.FIVE),
			Arguments.of(GenerateLottoNumber.manual(Arrays.asList(6, 7, 8, 9, 10)), Rank.FIVE)
		);
	}

	@DisplayName("지난 주 당첨 번호와 비교해서 예측하는 당첨 통계와 일치하는지?")
	@Test
	void 당첨_통계_테스트() {
		LottoNumbers winnerNumber = GenerateLottoNumber.manual(Arrays.asList(8, 21, 23, 41, 42, 43));

		LottoTicket lottoTicket = new LottoTicket();
		lottoTicket.add(GenerateLottoNumber.manual(Arrays.asList(8, 21, 23, 41, 42, 43)));
		lottoTicket.add(GenerateLottoNumber.manual(Arrays.asList(1, 2, 3, 41, 42, 43)));
		lottoTicket.add(GenerateLottoNumber.manual(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottoTicket.add(GenerateLottoNumber.manual(Arrays.asList(6, 7, 8, 9, 10)));


		LottoWinnerNumbers lottoWinnerNumbers = new LottoWinnerNumbers(winnerNumber);
		LottoResults lottoResults = LottoResults.compareTicketAndWinner(lottoTicket, lottoWinnerNumbers);

		assertThat(lottoResults.askCountOfRank(Rank.FOURTH)).isEqualTo(1);
		assertThat(lottoResults.askCountOfRank(Rank.WINNER)).isEqualTo(1);
		assertThat(lottoResults.askCountOfRank(Rank.FIVE)).isEqualTo(2);
	}

}

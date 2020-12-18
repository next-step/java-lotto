package lotto.view;

import lotto.LottoTicket;
import lotto.TestUtils;
import lotto.number.LottoNumbers;
import lotto.result.LottoResult;
import lotto.result.LottoStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoGameViewTest {

	@Test
	@DisplayName("구입한 로또번호 출력이 정상적으로 되는지 확인")
	void showBuyLottoNumbers() {
		// given
		LottoGameView lottoGameView = new LottoGameView();
		List<LottoNumbers> lottoNumbersList = Arrays.asList(
				TestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6),
				TestUtils.createLottoNumbers(16, 11, 12, 13, 14, 15),
				TestUtils.createLottoNumbers(1, 5, 10, 15, 20, 25)
		);

		// when & then
		assertDoesNotThrow(() -> lottoGameView.showLottoTicket(new LottoTicket(lottoNumbersList)));
	}

	@Test
	@DisplayName("로또 통계 메세지 출력이 정상적으로 되는지 확인")
	void showStatistics() {
		// given
		LottoGameView lottoGameView = new LottoGameView();
		List<LottoResult> lottoResultList = TestUtils.duplicate(LottoResult.NOTHING, 100000);
		lottoResultList.addAll(TestUtils.duplicate(LottoResult.MATCHED_THREE,2));
		lottoResultList.addAll(TestUtils.duplicate(LottoResult.MATCHED_FOUR,1));
		lottoResultList.addAll(TestUtils.duplicate(LottoResult.MATCHED_SIX,0));
		LottoStatistics lottoStatistics = new LottoStatistics(lottoResultList);

		// when & then
		assertDoesNotThrow(() -> lottoGameView.showStatistics(lottoStatistics));
	}

	@ParameterizedTest
	@ValueSource(booleans = {true, false})
	@DisplayName("로또 수익률 메세지 생성시 손해에 따른 추가메세지 확인")
	void createIncomeRateMessage(boolean isProfit) {
		// given
		List<LottoResult> lottoResultList = TestUtils.duplicate(LottoResult.NOTHING, 40);
		lottoResultList.add(LottoResult.MATCHED_THREE);
		if (isProfit) {
			lottoResultList.add(LottoResult.MATCHED_FOUR);
		}
		LottoStatistics lottoStatistics = new LottoStatistics(lottoResultList);
		LottoGameView lottoGameView = new LottoGameView();

		// when
		final String incomeRateMessage = lottoGameView.createIncomeRateMessage(lottoStatistics);

		// then
		assertThat(incomeRateMessage.contains("손해") != isProfit);
	}
}
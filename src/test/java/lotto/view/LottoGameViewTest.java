package lotto.view;

import lotto.result.LOTTO_RESULT;
import lotto.result.LottoStatistics;
import lotto.TestUtils;
import lotto.number.LottoNumbers;
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
		assertDoesNotThrow(() -> lottoGameView.showBuyLottoNumbers(lottoNumbersList));
	}

	@Test
	@DisplayName("로또 통계 메세지 출력이 정상적으로 되는지 확인")
	void showStatistics() {
		// given
		LottoGameView lottoGameView = new LottoGameView();
		List<LOTTO_RESULT> lottoResultList = TestUtils.duplicate(LOTTO_RESULT.NOTHING, 100000);
		lottoResultList.addAll(TestUtils.duplicate(LOTTO_RESULT.MATCHED_THREE,2));
		lottoResultList.addAll(TestUtils.duplicate(LOTTO_RESULT.MATCHED_FOUR,1));
		lottoResultList.addAll(TestUtils.duplicate(LOTTO_RESULT.MATCHED_SIX,0));
		LottoStatistics lottoStatistics = LottoStatistics.create(lottoResultList);

		// when & then
		assertDoesNotThrow(() -> lottoGameView.showStatistics(lottoStatistics));
	}

	@ParameterizedTest
	@ValueSource(booleans = {true, false})
	@DisplayName("로또 수익률 메세지 생성시 손해에 따른 추가메세지 확인")
	void createIncomeRateMessage(boolean isProfit) {
		// given
		List<LOTTO_RESULT> lottoResultList = TestUtils.duplicate(LOTTO_RESULT.NOTHING, 40);
		lottoResultList.add(LOTTO_RESULT.MATCHED_THREE);
		if (isProfit) {
			lottoResultList.add(LOTTO_RESULT.MATCHED_FOUR);
		}
		LottoStatistics lottoStatistics = LottoStatistics.create(lottoResultList);
		LottoGameView lottoGameView = new LottoGameView();

		// when
		final String incomeRateMessage = lottoGameView.createIncomeRateMessage(lottoStatistics);

		// then
		assertThat(incomeRateMessage.contains("손해") != isProfit);
	}
}
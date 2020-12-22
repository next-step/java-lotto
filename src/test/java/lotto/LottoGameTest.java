package lotto;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;
import lotto.option.LottoBuyPlan;
import lotto.option.LottoOption;
import lotto.result.LottoResult;
import lotto.result.LottoStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

	@ParameterizedTest
	@CsvSource(value = {"14000,10,14", "1000,0,1"})
	@DisplayName("로또 게임 전체 흐름을 테스트, 당첨 결과는 랜덤이기 때문에 중간 과정에서 인터페이스 호출 확인을 통해 입력 값에 상관이 있음을 확인")
	void play(long money, long manualNumbersSize, long expectedAllNumbersSize) {
		// given
		List<String> callList = new ArrayList<>();
		LottoOption lottoOption = new LottoOption() {
			@Override
			public WinningNumbers getWinningNumbers() {
				callList.add("getWinningNumbers");
				LottoNumbers lottoNumbers = TestUtils.createLottoNumbers(40, 41, 42, 43, 44, 45);
				return new WinningNumbers(lottoNumbers, new LottoNumber(8));
			}

			@Override
			public LottoBuyPlan getBuyPlan() {
				callList.add("getBuyPlan");
				return new LottoBuyPlan(money, createAnyNumbers(manualNumbersSize));
			}
		};

		LottoView lottoView = new LottoView() {
			@Override
			public void showLottoTicket(LottoTicket lottoTicket) {
				long allLottoNumbersSize = lottoTicket.autoNumbersSize() + lottoTicket.manualNumbersSize();
				if (allLottoNumbersSize == expectedAllNumbersSize) {
					callList.add("buyLottoRight");
				}
			}

			@Override
			public void showStatistics(LottoStatistics lottoStatistics) {
				if (lottoStatistics != null && lottoStatistics.getCount(LottoResult.NOTHING) == expectedAllNumbersSize) {
					callList.add("statisticsRight");
				}
			}
		};

		// when
		LottoGame lottoGame = new LottoGame(lottoOption, lottoView);
		lottoGame.play();

		// then
		assertThat(callList)
				.containsExactly("getBuyPlan", "buyLottoRight", "getWinningNumbers", "statisticsRight");
	}

	private List<LottoNumbers> createAnyNumbers(long size) {
		List<LottoNumbers> lottoNumbersList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			lottoNumbersList.add(TestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6));
		}
		return lottoNumbersList;
	}
}

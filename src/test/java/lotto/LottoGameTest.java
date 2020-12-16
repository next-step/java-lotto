package lotto;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

	@ParameterizedTest
	@CsvSource(value = {"14000,14", "1000,1"})
	@DisplayName("로또 게임 전체 흐름을 테스트, 당첨 결과는 랜덤이기 때문에 중간 과정에서 인터페이스 호출 확인을 통해 입력 값에 상관이 있음을 확인")
	void play(int money, int lottoSize) {
		// given
		List<String> callList = new ArrayList<>();
		LottoOption lottoOption = new LottoOption() {
			@Override
			public int getMoney() {
				callList.add("getMoney");
				return money;
			}

			@Override
			public LottoNumbers getWinningNumbers() {
				callList.add("getWinningNumbers");
				return createLottoNumbers(1, 2, 3, 4, 5, 6);
			}
		};

		LottoView lottoView = new LottoView() {
			@Override
			public void showBuyLottoNumbers(List<LottoNumbers> lottoNumbersList) {
				if (lottoNumbersList.size() == lottoSize) {
					callList.add("buyLottoRight");
				}

			}

			@Override
			public void showStatistics(LottoStatistics lottoStatistics) {
				if (lottoStatistics != null && lottoStatistics.calculateAllCount() == lottoSize) {
					callList.add("statisticsRight");
				}
			}
		};

		// when
		LottoGame lottoGame = new LottoGame(lottoOption, lottoView);
		lottoGame.play();

		// then
		assertThat(callList)
				.containsExactly("getMoney", "buyLottoRight", "getWinningNumbers", "statisticsRight");
	}

	private LottoNumbers createLottoNumbers(int n1, int n2, int n3, int n4, int n5, int n6) {
		List<LottoNumber> lottoNumberList = Arrays.asList(
				new LottoNumber(n1), new LottoNumber(n2), new LottoNumber(n3),
				new LottoNumber(n4), new LottoNumber(n5), new LottoNumber(n6));
		return new LottoNumbers(lottoNumberList);
	}
}

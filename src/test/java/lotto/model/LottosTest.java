package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottosTest {

	@ParameterizedTest
	@DisplayName("로또게임들을 등록하면 게임에 관한 내용이 반환된다.")
	@CsvSource(value = {"1,21,43", "2,8,24", "30,37,41"})
	public void createLottoGames(int firstNumber, int secondNumber, int thirdNumber) {
		List<Lotto> lotteries = new ArrayList<>();
		lotteries.add(getLottoGame(firstNumber, secondNumber, thirdNumber));
		Lottos lottos = new Lottos(lotteries);

		assertThat(lottos.getLottos().size()).isEqualTo(1);
		assertThat(lottos.getLottos().get(0).getLottoNumbers()).containsExactly(new LottoNumber(firstNumber),
			new LottoNumber(secondNumber),
			new LottoNumber(thirdNumber));
	}

	private Lotto getLottoGame(int firstNumber, int secondNumber, int thirdNumber) {
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(new LottoNumber(firstNumber));
		lottoNumbers.add(new LottoNumber(secondNumber));
		lottoNumbers.add(new LottoNumber(thirdNumber));
		return new Lotto(lottoNumbers);
	}

}
package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGameTest {

	@ParameterizedTest
	@DisplayName("로또게임들을 등록하면 게임에 관한 내용이 반환된다.")
	@CsvSource(value = {"1,21,43", "2,8,24", "30,37,41"})
	public void createLottoGames(int firstNumber, int secondNumber, int thirdNumber) {
		List<Lotto> lotto = new ArrayList<>();
		lotto.add(getLottoGame(firstNumber, secondNumber, thirdNumber));
		LottoGame lottoGame = new LottoGame(lotto);

		assertThat(lottoGame.getLotteries().size()).isEqualTo(1);
		assertThat(lottoGame.getLotteries().get(0).getLotto()).containsExactly(firstNumber, secondNumber,
			thirdNumber);
	}

	private Lotto getLottoGame(int firstNumber, int secondNumber, int thirdNumber) {
		List<Integer> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(firstNumber);
		lottoNumbers.add(secondNumber);
		lottoNumbers.add(thirdNumber);
		return new Lotto(lottoNumbers);
	}

}
package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGamesTest {

	@ParameterizedTest
	@DisplayName("로또게임들을 등록하면 게임에 관한 내용이 반환된다.")
	@CsvSource(value = {"1,21,43","2,8,24","30,37,41"})
	public void createLottoGames(int firstNumber, int secondNumber, int thirdNumber){
		List<LottoGame> lottoGame = new ArrayList<>();
		lottoGame.add(getLottoGame(firstNumber,secondNumber,thirdNumber));
		LottoGames lottoGames = new LottoGames(lottoGame);

		assertThat(lottoGames.getLottoGames().size()).isEqualTo(1);
		assertThat(lottoGames.getLottoGames().get(0).getLottoGame()).containsExactly(firstNumber,secondNumber,thirdNumber);
	}

	private LottoGame getLottoGame(int firstNumber, int secondNumber, int thirdNumber) {
		List<Integer> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(firstNumber);
		lottoNumbers.add(secondNumber);
		lottoNumbers.add(thirdNumber);
		return new LottoGame(lottoNumbers);
	}

}
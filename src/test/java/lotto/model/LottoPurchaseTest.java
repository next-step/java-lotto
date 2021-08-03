package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {


	@Test
	@DisplayName("입력된 로또게임 장수 만큼 로또게임이 생성된다.")
	public void createMoneyByLottoGame() {
		LottoPurchase lottoPurchase = new LottoPurchase(4);

		assertThat(lottoPurchase.resultLottoGame().size()).isEqualTo(4);

		LottoPurchase lottoPurchase2 = new LottoPurchase(6);

		assertThat(lottoPurchase2.resultLottoGame().size()).isEqualTo(6);
	}

	@Test
	@DisplayName("로또게임시 결과값을 반환한다.")
	public void resultLottoStatus() {
		List<LottoGame> lottoGame = new ArrayList<>();
		lottoGame.add(getLottoGame(1,2,3,4,5,7));
		lottoGame.add(getLottoGame(1,2,3,4,5,9));
		lottoGame.add(getLottoGame(1,2,3,4,5,6));
		lottoGame.add(getLottoGame(7,9,15,21,28,39));
		lottoGame.add(getLottoGame(2,2,3,32,38,45));
		LottoGames lottoGames = new LottoGames(lottoGame);
		LottoPurchase lottoPurchase = new LottoPurchase(lottoGames);
		Map<Prize, Integer> result = lottoPurchase.confirmWinLottoNumber("1,2,3,4,5,6");

		assertThat(result.size()).isEqualTo(2);
		assertThat(result.get(Prize.THIRD)).isEqualTo(2);

	}

	private LottoGame getLottoGame(int value1, int value2, int value3, int value4, int value5, int value6) {
		List<Integer> lottoNumber = new ArrayList<>();
		lottoNumber.add(value1);
		lottoNumber.add(value2);
		lottoNumber.add(value3);
		lottoNumber.add(value4);
		lottoNumber.add(value5);
		lottoNumber.add(value6);
		return new LottoGame(lottoNumber);
	}
}
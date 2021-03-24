package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameList;
import lotto.domain.LottoNumber;
import lotto.domain.ShuffleMakeStrategy;

public class LottoGamePurchaseTest {

	@Test
	@DisplayName("로또 게임 리스트 생성 테스트")
	void gameListMakeTest() {
		LottoGameList lottoGameList = new LottoGameList();

		lottoGameList.addLottoGame(new LottoGame(new ShuffleMakeStrategy()));
		lottoGameList.addLottoGame(new LottoGame(new ShuffleMakeStrategy()));
		lottoGameList.addLottoGame(new LottoGame(new ShuffleMakeStrategy()));
		lottoGameList.addLottoGame(new LottoGame(() -> {
			List<LottoNumber> gameNumberList = new ArrayList<>();
			gameNumberList.add(new LottoNumber(45));
			gameNumberList.add(new LottoNumber(5));
			gameNumberList.add(new LottoNumber(15));
			gameNumberList.add(new LottoNumber(31));
			gameNumberList.add(new LottoNumber(33));
			gameNumberList.add(new LottoNumber(25));
			return gameNumberList;
		}));

		assertThat(lottoGameList.getLottoGameList().size()).isEqualTo(4);
		assertThat(lottoGameList.getLottoGameList().get(3).getGameNumberList()).containsExactly(new LottoNumber(5),
			new LottoNumber(15), new LottoNumber(25), new LottoNumber(31), new LottoNumber(33), new LottoNumber(45));
	}

	@Test
	@DisplayName("로또 게임 리스트 생성 생성자를 통한 테스트")
	void gameListConstructMakeTest() {
		LottoGameList lottoGameList = new LottoGameList(10);
		assertThat(lottoGameList.getLottoGameList().size()).isEqualTo(10);
	}
}

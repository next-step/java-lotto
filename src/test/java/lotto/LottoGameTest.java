package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.ShuffleMakeStrategy;

public class LottoGameTest {

	@Test
	@DisplayName("로또 게임 생성 테스트 : 1~45 중 6개 자동 생성")
	void gameMakeTest() {
		LottoGame lottoGame = new LottoGame(() -> {
			List<LottoNumber> gameNumberList = new ArrayList<>();
			gameNumberList.add(new LottoNumber(45));
			gameNumberList.add(new LottoNumber(5));
			gameNumberList.add(new LottoNumber(15));
			gameNumberList.add(new LottoNumber(31));
			gameNumberList.add(new LottoNumber(33));
			gameNumberList.add(new LottoNumber(25));
			return gameNumberList;
		});

		assertThat(lottoGame.getGameNumberList().get(0)).isEqualTo(new LottoNumber(5));
		assertThat(lottoGame.getGameNumberList().get(1)).isEqualTo(new LottoNumber(15));
		assertThat(lottoGame.getGameNumberList().get(2)).isEqualTo(new LottoNumber(25));
		assertThat(lottoGame.getGameNumberList().get(3)).isEqualTo(new LottoNumber(31));
		assertThat(lottoGame.getGameNumberList().get(4)).isEqualTo(new LottoNumber(33));
		assertThat(lottoGame.getGameNumberList().get(5)).isEqualTo(new LottoNumber(45));
	}

	@Test
	@DisplayName("로또 게임 생성 테스트 : 셔플을 통한 자동 생성")
	void gameMakeShuffleTest() {
		LottoGame lottoGame = new LottoGame(new ShuffleMakeStrategy());
		assertThat(lottoGame.getGameNumberList().size()).isEqualTo(6);
	}
}

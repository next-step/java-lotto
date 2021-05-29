package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
	@Test
	@DisplayName("로또 컬렉션의 사이즈는 100을 넘을 수 없음")
	public void the_size_of_lottos_can_not_exceed_100() {
		List<Integer> randomNumberList;
		List<Lotto> lottosExceed100 = new ArrayList<>();
		for (int i = 0; i < 140; i++) {
			randomNumberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
			lottosExceed100.add(new Lotto(randomNumberList));
		}

		assertThatThrownBy(() -> new Lottos(lottosExceed100))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("로또 컬렉션의 크기를 확인")
	public void get_the_size_of_lottos() {
		List<Integer> randomNumberList;
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < 55; i++) {
			randomNumberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
			lottos.add(new Lotto(randomNumberList));
		}

		assertThat(new Lottos(lottos).size()).isEqualTo(55);
	}

	@Test
	@DisplayName("당첨 번호를 전달하여 구매한 로또 중 실제 당첨된 로또의 개수를 구함")
	public void send_winner_numbers_return_winner_lottos_from_bought_lottos() {
		List<Lotto> candidateLottos = new ArrayList<>();
		candidateLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		Lottos lottos = new Lottos(candidateLottos);

		WinnerTable winnerTable = lottos.announce(new WinnerLotto(Arrays.asList(1, 2, 3, 4, 5, 7), 8));

		assertThat(winnerTable.getWinnerCount(Ranking.RANKING_3)).isEqualTo(1);
	}
}

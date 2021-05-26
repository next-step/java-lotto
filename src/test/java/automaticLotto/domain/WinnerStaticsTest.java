package automaticLotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerStaticsTest {
	private List<Lotto> candidateLottos;

	@BeforeEach
	void setUp() {
		candidateLottos = new ArrayList<>();
		candidateLottos.add(new Lotto(Arrays.asList(45, 44, 43, 42, 41, 40)));
		candidateLottos.add(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)));
		candidateLottos.add(new Lotto(Arrays.asList(45, 44, 43, 42, 41, 39)));
		candidateLottos.add(new Lotto(Arrays.asList(45, 44, 43, 42, 41, 28)));
	}

	@Test
	@DisplayName("당첨이 아무도 안됐을 경우(ex, 숫자 2개 일치 등) 당첨되지 않은 개수 노출")
	public void present_no_winner_statics() {
		WinnerStatics winnerStatics = new WinnerStatics(new Lottos(candidateLottos),
			new Lotto(Arrays.asList(1, 2, 31, 32, 33, 34)));

		assertThat(winnerStatics.presentCount(Ranking.RANKING_LAST)).isEqualTo(4);
	}

	@Test
	@DisplayName("당첨 됐을 경우 해당 횟수 노출")
	public void present_winner_statics() {
		WinnerStatics winnerStatics = new WinnerStatics(new Lottos(candidateLottos),
			new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

		assertThat(winnerStatics.presentCount(Ranking.RANKING_2)).isEqualTo(1);
	}

	@Test
	@DisplayName("수익률 계산")
	public void calculate_profit_rate() {
		WinnerStatics winnerStatics = new WinnerStatics(new Lottos(candidateLottos),
			new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

		assertThat(winnerStatics.getProfitRate()).isEqualTo("375.00");
	}

	@Test
	@DisplayName("당첨 번호와 일치하는 로또의 개수를 노출")
	public void present_matched_lotto_size() {
		WinnerStatics winnerStatics = new WinnerStatics(new Lottos(candidateLottos),
			new Lotto(Arrays.asList(1, 41, 42, 43, 44, 45)));

		assertThat(winnerStatics.presentCount(Ranking.RANKING_2)).isEqualTo(3);
	}
}

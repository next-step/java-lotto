package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

	private Lottos lottos;
	private List<Lotto> lottoList;
	@BeforeEach
	void before() {
		lottoList = new ArrayList<>();
		lottoList.add(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)));
		lottoList.add(new Lotto(Arrays.asList(21, 22, 23, 24, 15, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 14, 15, 16)));

		lottos = new Lottos(lottoList);
	}

	@Test
	@DisplayName("생성 테스트")
	void create() {
		assertThat(lottos).isNotNull();
		for (Prize prize : Prize.values()) {
			assertThat(lottos.status(prize)).isEqualTo(0);
		}
		for (Lotto lotto : lottos.findAll()) {
			assertThat(lottoList.contains(lotto)).isTrue();
		}
	}

	@Test
	@DisplayName("당첨 현황 테스트")
	void statistics() {
		Lotto win = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		lottos.statistics(win);

		assertThat(lottos.status(Prize.SIX)).isEqualTo(0);
		assertThat(lottos.status(Prize.FIVE)).isEqualTo(0);
		assertThat(lottos.status(Prize.FOUR)).isEqualTo(0);
		assertThat(lottos.status(Prize.THREE)).isEqualTo(1);
	}
	@Test
	@DisplayName("수익률 계산")
	void profitRate() {
		Lotto win = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		lottos.statistics(win);

		Profit profit = lottos.profit();
		assertThat(profit.rate()).isEqualTo(0.71);
	}
}


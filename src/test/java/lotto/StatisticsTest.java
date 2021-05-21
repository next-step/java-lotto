package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsTest {

	Statistics statistics;

	@BeforeEach
	void before() {
		statistics = new Statistics(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}

	@Test
	@DisplayName("생성 테스트")
	void create() {
		assertThat(statistics).isNotNull();
		assertThat(statistics.prizeLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
	}

	@Test
	@DisplayName("로또 추가 테스트")
	void addLotto() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		statistics.addLotto(lotto);
		assertThat(statistics.contains(lotto)).isTrue();
	}

	@Test
	@DisplayName("통계 현황 테스트")
	void statistics() {
		for (Prize prize : Prize.values()) {
			assertThat(statistics.status(prize)).isEqualTo(0);
		}

		statistics.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16)));
		statistics.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 15, 16)));
		statistics.addLotto(new Lotto(Arrays.asList(1, 2, 3, 14, 5, 16)));
		statistics.addLotto(new Lotto(Arrays.asList(1, 2, 3, 14, 15, 16)));

		assertThat(statistics.status(Prize.SIX)).isEqualTo(0);
		assertThat(statistics.status(Prize.FIVE)).isEqualTo(1);
		assertThat(statistics.status(Prize.FOUR)).isEqualTo(2);
		assertThat(statistics.status(Prize.THREE)).isEqualTo(1);
	}
	@Test
	@DisplayName("수익률 계산")
	void profitRate() {
		statistics.addLotto(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)));
		statistics.addLotto(new Lotto(Arrays.asList(21, 22, 23, 24, 15, 16)));
		statistics.addLotto(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		statistics.addLotto(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		statistics.addLotto(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		statistics.addLotto(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		statistics.addLotto(new Lotto(Arrays.asList(1, 2, 3, 14, 15, 16)));

		Profit profit = statistics.profit();
		assertThat(profit.rate()).isEqualTo(0.71);
	}
}


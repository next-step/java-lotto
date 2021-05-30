package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsTest {

	private Lottos lottos;

	@BeforeEach
	void before() {
		List<Lotto> lottoList = new ArrayList<>();
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
		Statistics statistics = new Statistics();
		assertThat(statistics).isNotNull();
		for (Prize prize : Prize.values()) {
			assertThat(statistics.status(prize)).isEqualTo(0);
		}
	}

	@Test
	@DisplayName("당첨 현황 테스트")
	void statistics() {
		Statistics statistics = lottos.statistics(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(statistics.status(Prize.FIRST)).isEqualTo(0);
		assertThat(statistics.status(Prize.SECOND)).isEqualTo(0);
		assertThat(statistics.status(Prize.THIRD)).isEqualTo(0);
		assertThat(statistics.status(Prize.FOURTH)).isEqualTo(1);
	}
}


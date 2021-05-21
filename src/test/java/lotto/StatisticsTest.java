package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsTest {
	
	@Test
	@DisplayName("생성 테스트")
	void create() {
		Statistics statistics = new Statistics();
		assertThat(statistics).isNotNull();
	}

	@Test
	@DisplayName("로또 추가 테스트")
	void addLotto() {
		Statistics statistics = new Statistics();
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		statistics.addLotto(lotto);
		assertThat(statistics.contains(lotto)).isTrue();
	}

}


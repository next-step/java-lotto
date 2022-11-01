package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	@DisplayName("로또 결과 테스트")
	void result() {
		Lotto ex1 = new Lotto(new String[] {"1", "2", "3", "4", "5", "6"});
		Lotto ex2 = new Lotto(new String[] {"1", "2", "3", "4", "5", "9"});
		Lotto exBonus = new Lotto(new String[] {"1", "2", "3", "4", "5", "7"});

		Lotto winningLotto = new Lotto(new String[] {"1", "2", "3", "4", "5", "6"});
		int bonus = 7;

		Lottos lottos = new Lottos(Arrays.asList(ex1, ex2, exBonus));

		assertThat(lottos.results(ex1, winningLotto)).isEqualTo(6);
		assertThat(lottos.results(ex2, winningLotto)).isEqualTo(5);
		assertThat(lottos.results(exBonus, winningLotto)).isEqualTo(5);
	}
}

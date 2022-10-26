package step2.model.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

	@DisplayName("주어진 개수만큼 로또를 생성한다.")
	@Test
	void Given_Count_Then_GenerateLottos() {
		int count = 3;
		Lottos lottos = new Lottos(count);

		assertThat(lottos).hasSize(count);
	}

	@DisplayName("로또의 번호와 맞는 hashmap 을 생성한다.")
	@Test
	void Given_Lotto_Then_ReturnHashMap() {
		Lottos lottos = new Lottos(6);
		Lotto lotto = lottos.get(1);
		HashMap<Integer, Integer> countMap = lottos.getMatchCountMap(lotto);

		assertThat(countMap.get(6)).isEqualTo(1);
	}

	@DisplayName("hashmap 의 사이즈는 6이다.")
	@Test
	void Then_HashMapSizeTo6() {
		Lottos lottos = new Lottos(6);
		Lotto lotto = lottos.get(1);
		HashMap<Integer, Integer> countMap = lottos.getMatchCountMap(lotto);

		assertThat(countMap).hasSize(6);
	}
}
package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	@DisplayName("생성 테스트")
	void create() {
		List<Lotto> lottoList = new ArrayList<>();
		lottoList.add(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)));
		lottoList.add(new Lotto(Arrays.asList(21, 22, 23, 24, 15, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 14, 15, 16)));

		Lottos lottos = new Lottos(lottoList);
		assertThat(lottos).isNotNull();
	}
}


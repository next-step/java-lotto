package automaticLotto.domain;

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
}

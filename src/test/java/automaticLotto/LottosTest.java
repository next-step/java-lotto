package automaticLotto;

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
	@DisplayName("당첨 번호와 일치하는 로또의 개수를 노출")
	public void present_matched_lotto_size() {
		List<Lotto> candidateLottos = new ArrayList<>();
		candidateLottos.add(new Lotto(Arrays.asList(45, 44, 43, 42, 41, 40)));
		candidateLottos.add(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)));
		candidateLottos.add(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)));
		candidateLottos.add(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)));
		Lottos boughtLottos = new Lottos(candidateLottos);

		WinnerStatics winnerStatics = boughtLottos.announce(Arrays.asList(1, 41, 42, 43, 44, 45));

		assertThat(winnerStatics.presentCount(5)).isEqualTo(1);
	}
}

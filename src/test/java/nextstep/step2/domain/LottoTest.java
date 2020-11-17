package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LottoTest {
	@Test
	@DisplayName("로또 번호는 1~45 사이의 수이다.")
	public void getLottoNumbersTest() {
		Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
		assertThat(lotto.getNumbers()).hasSize(6);
		assertAll(() -> assertFalse(lotto.getNumbers().contains(0)),
				() -> assertFalse(lotto.getNumbers().contains(46)));
	}

	@Test
	@DisplayName("로또 번호의 리워드를 가질 수 있다.")
	public void lottoRewardTest() {
		List<Integer> lastWinnerNumbers = Arrays.asList(1,2,3,4,5,6);
		Lotto lotto = new Lotto(Arrays.asList(1,2,3,14,15,16));
		lotto.setLottoReward(lastWinnerNumbers);
		assertThat(LottoReward.values()).contains(lotto.getLottoReward());
		assertThat(lotto.getLottoReward()).isEqualTo(LottoReward.FOURTH);
	}
}

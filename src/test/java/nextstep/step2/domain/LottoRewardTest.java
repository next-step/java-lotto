package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRewardTest {

	@Test
	@DisplayName("로또 리워드를 얻을 수 있다.")
	public void getRewordTest() {
		LottoReward lottoReward = LottoReward.getReword(6);
		assertThat(lottoReward.getPrice()).isEqualTo("2000000000원");
		assertThat(lottoReward).isEqualTo(LottoReward.FIRST);
	}
}

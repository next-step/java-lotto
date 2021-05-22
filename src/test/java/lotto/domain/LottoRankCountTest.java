package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankCountTest {

	@Test
	@DisplayName("로또 순위 별 개수 가져오기 테스트")
	public void getLottoRankCount() {
		LottoRankCount lottoRankCount = new LottoRankCount(1, 2, 3, 4);
		assertThat(lottoRankCount.getFirstCount()).isEqualTo(1);
		assertThat(lottoRankCount.getSecondCount()).isEqualTo(2);
		assertThat(lottoRankCount.getThirdCount()).isEqualTo(3);
		assertThat(lottoRankCount.getFourthCount()).isEqualTo(4);
	}
}

package lotto.statistics;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EarnTest {

	@Test
	@DisplayName(value = "몇번 일치했는지 입력하면 그에 해당하는 상금을 반환한다")
	void matchAndWinningPrice() {
		assertThat(Earn.match(3)).isEqualTo(Earn.THREE_MATCHED);
		assertThat(Earn.match(6)).isEqualTo(Earn.SIX_MATCHED);
	}

}
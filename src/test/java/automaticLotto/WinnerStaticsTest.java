package automaticLotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerStaticsTest {
	@Test
	@DisplayName("당첨이 아무도 안됐을 경우(ex, 숫자 2개 일치 등) 0 노출")
	public void present_winner_statics() {
		WinnerStatics winnerStatics = new WinnerStatics();
		winnerStatics.addMatchedNumberCount(0);
		winnerStatics.addMatchedNumberCount(2);

		assertThat(winnerStatics.presentCount(0)).isEqualTo(0);
		assertThat(winnerStatics.presentCount(2)).isEqualTo(0);
	}
}

package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPaperTest {

	@Test
	@DisplayName("수익률 계산")
	void profit() {
		LottoPaper lottoPaper = new LottoPaper();
		LottoPaper result = lottoPaper.write(LottoRank.FIRST, new Money(1000));
		assertThat(result.profit()).isEqualTo(2_000_000_000.00 / 1000.00);
	}

	@Test
	@DisplayName("당첨 갯수 구하기")
	void result() {
		LottoPaper lottoPaper = new LottoPaper();
		LottoPaper result = lottoPaper.write(LottoRank.FIRST, new Money(1000))
			.write(LottoRank.SECOND, new Money(1000))
			.write(LottoRank.THIRD, new Money(1000));

		assertThat(result.lottoMatchCount(6, false)).isEqualTo(1);

		assertThat(result.lottoMatchCount(5, true)).isEqualTo(1);

		assertThat(result.lottoMatchCount(5, false)).isEqualTo(1);

		assertThat(result.lottoMatchCount(4, false)).isEqualTo(0);

		assertThat(result.lottoMatchCount(3, false)).isEqualTo(0);

		assertThat(result.lottoMatchCount(2, false)).isEqualTo(0);
	}
}

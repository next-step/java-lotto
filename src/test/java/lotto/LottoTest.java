package lotto;

import calculator.StringAddCalculator;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

	Lotto lotto = new Lotto();

	@Test
	public void calculateLottoCount_장당_천원_로또_구매_매수_테스트() {
		assertThat(lotto.calculateLottoCount(14000,1000)).isEqualTo(14);
		assertThat(lotto.calculateLottoCount(13500,1000)).isEqualTo(13);
	}

	@Test
	public void calculateLottoCount_장당_이천오백원_로또_구매_매수_테스트() {
		assertThat(lotto.calculateLottoCount(5000,2500)).isEqualTo(2);
		assertThat(lotto.calculateLottoCount(7800,2500)).isEqualTo(3);
	}
}

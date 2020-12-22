package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GeneratedLottoTest {

	@Test
	public void 지난주_당첨번호와_내가_산_로또번호_일치_카운트_확인() {
		Lotto lastPrizeNumber = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
		Lotto thisWeekBuyNumber = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
		assertThat(lastPrizeNumber.countMatchNumber(thisWeekBuyNumber)).isEqualTo(6);

		lastPrizeNumber = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
		thisWeekBuyNumber = new Lotto(new ArrayList<>(Arrays.asList(32,33,6,35,36,37)));
		assertThat(lastPrizeNumber.countMatchNumber(lastPrizeNumber, thisWeekBuyNumber)).isEqualTo(1);
	}

}
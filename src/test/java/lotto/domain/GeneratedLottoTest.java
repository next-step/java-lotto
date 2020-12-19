package lotto.domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GeneratedLottoTest {

	@Test
	public void 지난주_당첨번호와_내가_산_로또번호_일치_카운트_확인(){
		GeneratedLotto lastPrizeNumber = new GeneratedLotto(new String[]{"1","2","3","4","5","6"});
		GeneratedLotto thisWeekBuyNumber = new GeneratedLotto(new String[]{"1","2","3","4","5","6"});
		assertThat(GeneratedLotto.countMatchNumber(lastPrizeNumber, thisWeekBuyNumber)).isEqualTo(6);

		lastPrizeNumber = new GeneratedLotto(new String[]{"1","2","3","4","5","6"});
		thisWeekBuyNumber = new GeneratedLotto(new String[]{"32","33","6","35","36","37"});
		assertThat(GeneratedLotto.countMatchNumber(lastPrizeNumber, thisWeekBuyNumber)).isEqualTo(1);
	}

	@Test
	public void 로또번호가_중복없이_6개인지_확인(){
		assertThatIllegalArgumentException().isThrownBy(() -> {
			GeneratedLotto.validateMaxCount(Arrays.asList(1,1, 1, 1, 1, 1));
		});
	}

}
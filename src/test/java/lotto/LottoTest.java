package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.input.Money;
import lotto.domain.result.MatchCount;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

	@Test
	public void 지난주_당첨번호에서_내가_산_로또번호를_비교해서_결과를_확인한다() {
		Lotto lotto = new Lotto();
		Lotto buyLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),new LottoNumber(4), new LottoNumber(5),new LottoNumber(6)));
		Lotto lastPrizeNumber = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),new LottoNumber(4), new LottoNumber(5),new LottoNumber(6)));
		assertThat(lotto.getMatchCount(lastPrizeNumber, buyLotto).getMatchCount()).isEqualTo(6);
	}

	@Test
	public void 지난주_당첨번호와_내가_산_로또번호_일치_카운트_확인() {
		Lotto lastPrizeNumber = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),new LottoNumber(4), new LottoNumber(5),new LottoNumber(6)));
		Lotto thisWeekBuyNumber = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),new LottoNumber(4), new LottoNumber(5),new LottoNumber(6)));
		assertThat(lastPrizeNumber.countMatchNumber(thisWeekBuyNumber).getMatchCount()).isEqualTo(6);

		lastPrizeNumber = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),new LottoNumber(4), new LottoNumber(5),new LottoNumber(6)));
		thisWeekBuyNumber = new Lotto(Arrays.asList(new LottoNumber(32), new LottoNumber(33), new LottoNumber(6),new LottoNumber(35), new LottoNumber(36),new LottoNumber(37)));
		assertThat(lastPrizeNumber.countMatchNumber(lastPrizeNumber, thisWeekBuyNumber).getMatchCount()).isEqualTo(1);
	}

}

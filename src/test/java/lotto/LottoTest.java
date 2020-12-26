package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

	Lotto lotto = new Lotto();
	LottoTVShow lottoTVShow = new LottoTVShow();

	@Test
	public void calculateLottoCount_장당_천원_로또_구매_매수_테스트() {
		assertThat(lottoTVShow.calculateLottoCount(14000)).isEqualTo(14);
		assertThat(lottoTVShow.calculateLottoCount(13500)).isEqualTo(13);
	}

	@Test
	public void 지난주_당첨번호에서_내가_산_로또번호를_비교해서_결과를_확인한다(){
		Lotto lotto = new Lotto();
		Lotto buyLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
		Lotto lastPrizeNumber = new Lotto(Arrays.asList(1,2,3,4,5,6));
		assertThat(lotto.getMatchCount(lastPrizeNumber, buyLotto)).isEqualTo(6);
	}

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

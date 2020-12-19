package lotto;

import lotto.domain.GeneratedLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

	Lotto lotto = new Lotto();
	LottoTVShow lottoTVShow = new LottoTVShow();

	@Test
	public void calculateLottoCount_장당_천원_로또_구매_매수_테스트() {
		assertThat(lotto.calculateLottoCount(14000)).isEqualTo(14);
		assertThat(lotto.calculateLottoCount(13500)).isEqualTo(13);
	}

	@Test
	public void 구매장수에_맞게_6개의_번호의_로또가_뽑혔는지_테스트() {
		List<GeneratedLotto> result = lotto.generateAutoLottoNumbers(2);
		assertThat(result.size()).isEqualTo(2);
		GeneratedLotto lotto = result.get(0);
		assertThat(lotto.lottoNumbers.size()).isEqualTo(6);
	}

	@Test
	public void 지난주_당첨번호에서_내가_산_로또번호를_비교해서_결과를_확인한다(){
		GeneratedLotto generatedLotto = new GeneratedLotto();
		String[] arr = new String[6];
		for (int i = 0; i < 6; i++) {
			arr[i] = String.valueOf(generatedLotto.lottoNumbers.get(i));
		}
		GeneratedLotto lastPrizeNumber = new GeneratedLotto(arr);

		assertThat(lotto.getMatchCount(lastPrizeNumber, generatedLotto)).isEqualTo(6);
	}

	@Test
	public void 구매금액만큼_잘구매되었는지_확인(){
		assertThat(lotto.generatePurchagedAutoLotto(10000).size()).isEqualTo(10);
	}
}

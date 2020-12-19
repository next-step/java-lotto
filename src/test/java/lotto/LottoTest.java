package lotto;

import lotto.domain.GeneratedLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoResult;
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
	public void 본전케이스_당첨금_계산_테스트(){
		LottoResult lottoResult = new LottoResult();
		List<LottoMatchResult> lottoMatchCountList = new ArrayList<>();
		lottoMatchCountList.add(new LottoMatchResult(3, false));
		lottoMatchCountList.add(new LottoMatchResult(3, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));

		lottoResult.arrangePrize(lottoMatchCountList, 1000);
		assertThat(lottoResult.getEarningsRate()).isEqualTo(1);
		assertThat(lottoResult.getTotalPrizeMoney()).isEqualTo(10000);
	}

	@Test
	public void 손해케이스_당첨금_계산_테스트_손해(){
		LottoResult lottoResult = new LottoResult();
		List<LottoMatchResult> lottoMatchCountList = new ArrayList<>();
		lottoMatchCountList.add(new LottoMatchResult(3, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoResult.arrangePrize(lottoMatchCountList, 1000);
		assertThat(lottoResult.getEarningsRate()).isEqualTo(0.5);
		assertThat(lottoResult.getTotalPrizeMoney()).isEqualTo(5_000);
	}

	@Test
	public void 이익케이스_당첨금_계산_테스트(){
		LottoResult lottoResult = new LottoResult();
		List<LottoMatchResult> lottoMatchCountList = new ArrayList<>();
		lottoMatchCountList.add(new LottoMatchResult(6, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoMatchCountList.add(new LottoMatchResult(1, false));
		lottoResult.arrangePrize(lottoMatchCountList, 1000);
		assertThat(lottoResult.getEarningsRate()).isEqualTo(200000);
		assertThat(lottoResult.getTotalPrizeMoney()).isEqualTo(2_000_000_000);
	}


}

package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.model.LOTTO_PRIZE_POLICY;
import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

	Lotto lotto = new Lotto();

	@Test
	public void calculateLottoCount_장당_천원_로또_구매_매수_테스트() {
		assertThat(lotto.calculateLottoCount(14000)).isEqualTo(14);
		assertThat(lotto.calculateLottoCount(13500)).isEqualTo(13);
	}

	@Test
	public void 구매장수에_맞게_6개의_번호의_로또가_뽑혔는지_테스트() {
		List<List<Integer>> autoGeneratedLottos = new ArrayList<>();
		List<List<Integer>> result = lotto.generateAutoLottoNumbers(2, autoGeneratedLottos);
		assertThat(result.size()).isEqualTo(2);
		List<Integer> lotto = result.get(0);
		assertThat(lotto.size()).isEqualTo(6);
	}

	@Test
	public void 지난주_당첨번호에서_내가_산_로또번호를_비교해서_결과를_확인한다(){
		List<Integer> lastPrizeNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		List<Integer> autoGeneratedLotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(lotto.getMatchCount(lastPrizeNumber,autoGeneratedLotto)).isEqualTo(6);

		autoGeneratedLotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 7, 8));
		assertThat(lotto.getMatchCount(lastPrizeNumber,autoGeneratedLotto)).isEqualTo(4);

	}

	@Test
	public void 본전케이스_당첨금_계산_테스트(){
		LottoResult lottoResult = new LottoResult();
		List<Integer> lottoMatchCountList = new ArrayList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 0, 0, 0, 0));
		lottoResult.arrangePrize(lottoMatchCountList, 1000);
		assertThat(lottoResult.getEarningsRate()).isEqualTo(1);
		assertThat(lottoResult.getTotalPrizeMoney()).isEqualTo(10000);
	}

	@Test
	public void 손해케이스_당첨금_계산_테스트_손해(){
		LottoResult lottoResult = new LottoResult();
		List<Integer> lottoMatchCountList = new ArrayList<>(Arrays.asList(3, 1, 1, 1, 2, 2, 0, 0, 0, 0));
		lottoResult.arrangePrize(lottoMatchCountList, 1000);
		assertThat(lottoResult.getEarningsRate()).isEqualTo(0.5);
		assertThat(lottoResult.getTotalPrizeMoney()).isEqualTo(LOTTO_PRIZE_POLICY.THREE_MATCH_PRIZE.getPrizeMoney());
	}

	@Test
	public void 이익케이스_당첨금_계산_테스트(){
		LottoResult lottoResult = new LottoResult();
		List<Integer> lottoMatchCountList = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2, 2, 0, 0, 0, 6));
		lottoResult.arrangePrize(lottoMatchCountList, 1000);
		assertThat(lottoResult.getEarningsRate()).isEqualTo(200000);
		assertThat(lottoResult.getTotalPrizeMoney()).isEqualTo(LOTTO_PRIZE_POLICY.SIX_MATCH_PRIZE.getPrizeMoney());
	}


}

package lotto;

import lotto.domain.Lotto;
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
		assertThat(lotto.calculateLottoCount(14000,1000)).isEqualTo(14);
		assertThat(lotto.calculateLottoCount(13500,1000)).isEqualTo(13);
	}

	@Test
	public void calculateLottoCount_장당_이천오백원_로또_구매_매수_테스트() {
		assertThat(lotto.calculateLottoCount(5000,2500)).isEqualTo(2);
		assertThat(lotto.calculateLottoCount(7800,2500)).isEqualTo(3);
	}

	@Test
	public void 구매장수에_맞게_6개의_번호의_로또가_뽑혔는지_테스트() {
		List<List> result = lotto.generateAutoLottoNumbers(2);
		assertThat(result.size()).isEqualTo(2);
		List<Integer> lotto = result.get(0);
		assertThat(lotto.size()).isEqualTo(6);
	}

	@Test
	public void 지난주_당첨번호에서_내가_산_로또번호를_비교해서_결과를_확인한다(){
		List<Integer> lastPrizeNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		List<Integer> purchargedLottoNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(lotto.calculatePrizeStatistics(lastPrizeNumber,purchargedLottoNumber)).isEqualTo(6);

		purchargedLottoNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 7, 8));
		assertThat(lotto.calculatePrizeStatistics(lastPrizeNumber,purchargedLottoNumber)).isEqualTo(4);

	}

	@Test
	public void 지난주_당첨번호가_잘입력되었는가_테스트(){
		assertThat(lotto.convertStringToInteger("1, 2, 3, 4, 5, 6").size()).isEqualTo(6);

		assertThat(lotto.convertStringToInteger("1 , 2 , 3 , 4, 5, 6").size()).isEqualTo(6);

		assertThatIllegalArgumentException().isThrownBy(() -> {
			lotto.convertStringToInteger("1, 2, 3, 4, 5, 6, 7");
		});
		assertThatIllegalArgumentException().isThrownBy(() -> {
			lotto.convertStringToInteger("1, 1, 1, 1, 5");
		});

		assertThatIllegalArgumentException().isThrownBy(() -> {
			lotto.convertStringToInteger("A, 2, 3, 4, 5, 6, 7");
		});

	}
}

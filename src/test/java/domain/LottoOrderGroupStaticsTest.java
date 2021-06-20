package domain;

import org.junit.jupiter.api.Test;
import ui.Rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static domain.Lotto.LOTTO_PRICE;
import static domain.LottoFixture.로또_생성;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoOrderGroupStaticsTest {
	@Test
	public void 수익률_계산_자연수_1장_1등 () {
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(로또_생성(Arrays.asList(1, 2, 3, 4, 5, 6)));

		LottoOrderGroupStatics analysis = new LottoOrderGroupStatics(
				new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
				, 7
				, lottos
		);

		analysis.matchSetting();

		assertThat(Rank.FIRST.money() / LOTTO_PRICE + ".00")
				.isEqualTo(analysis.yield());
	}

	@Test
	public void 수익률_계산_자연수_소숫 () {
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(로또_생성(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottos.add(로또_생성(Arrays.asList(11, 12, 13, 14, 15, 16)));
		lottos.add(로또_생성(Arrays.asList(17, 18, 19, 20, 21, 22)));
		lottos.add(로또_생성(Arrays.asList(23, 24, 25, 26, 27, 28)));
		lottos.add(로또_생성(Arrays.asList(29, 30, 31, 32, 33, 34)));
		lottos.add(로또_생성(Arrays.asList(35, 36, 37, 38, 39, 40)));

		LottoOrderGroupStatics analysis = new LottoOrderGroupStatics(
				new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10))
				, 7
				, lottos
		);

		analysis.matchSetting();

		System.out.println(analysis.yield());

		assertThat("0.83")
				.isEqualTo(analysis.yield());
	}
}
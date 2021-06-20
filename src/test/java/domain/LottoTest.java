package domain;

import org.junit.jupiter.api.Test;
import ui.Rank;

import java.util.Arrays;
import java.util.List;

import static domain.LottoFixture.로또_생성;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
	@Test
	public void 로또번호생성테스트() {
		List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

		final Lotto lotto = 로또_생성(lottoNumber);

		assertThat(lotto.numbers()).isEqualTo(lottoNumber);
	}

	@Test
	public void 로또_랭킹세팅_테스트() {
		List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

		final Lotto lotto = 로또_생성(lottoNumber);
		assertThat(lotto.rank()).isEqualTo(Rank.NOT_YET);

		lotto.rank(Rank.FIFTH);

		assertThat(lotto.rank()).isEqualTo(Rank.FIFTH);
	}
}
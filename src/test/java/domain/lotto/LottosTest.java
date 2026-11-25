package domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	void 금액만큼_로또를_구입한다() {
		Lottos lottos = new Lottos(14000);
		assertThat(lottos.getLottos()).hasSize(14);
	}

	@Test
	void 당첨번호로_결과를_만든다() {
		Lottos lottos = new Lottos(List.of(
			new Lotto(List.of(
				new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
				new LottoNumber(7), new LottoNumber(8), new LottoNumber(9))),
			new Lotto(List.of(
				new LottoNumber(10), new LottoNumber(11), new LottoNumber(12),
				new LottoNumber(13), new LottoNumber(14), new LottoNumber(15)))
		));
		WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");

		LottoResult result = lottos.result(winningLotto);

		assertThat(result.profitRate(2000)).isEqualTo(2.5);
	}
}

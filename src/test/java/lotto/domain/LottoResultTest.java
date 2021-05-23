package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

	@Test
	@DisplayName("구매한 로또의 당첨 결과를 구하는 테스트")
	void findWinningResult() {
		List<Lotto> purchaseLottos = new ArrayList<>();
		purchaseLottos.add(new Lotto(1, 2, 3, 4, 5, 6));
		Lotto winningLotto = new Lotto(1, 2, 3, 43, 44, 45);

		LottoResult lottoResult = new LottoResult(purchaseLottos, winningLotto);
		assertThat(lottoResult.getStatMap().get(Rank.FOURTH)).isEqualTo(1);
		assertThat(lottoResult.calculateProfitRate()).isEqualTo(5.0f);
	}

}

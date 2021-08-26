package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	@DisplayName("로또 결과를 통해서 상금 확인")
	void compare() {
		Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto lotto1st = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto lotto2st = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
		Lotto lotto3st = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8));
		Lotto lotto4st = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
		Lotto failedLotto = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));

		assertThat(lotto1st.unmaskedLotto(winningNumber).lottoRank().reward()).isEqualTo(LottoRank.FIRST.reward());

		assertThat(lotto2st.unmaskedLotto(winningNumber).lottoRank().reward()).isEqualTo(LottoRank.SECOND.reward());

		assertThat(lotto3st.unmaskedLotto(winningNumber).lottoRank().reward()).isEqualTo(LottoRank.THIRD.reward());

		assertThat(lotto4st.unmaskedLotto(winningNumber).lottoRank().reward()).isEqualTo(LottoRank.FOURTH.reward());

		assertThat(failedLotto.unmaskedLotto(winningNumber).lottoRank().reward()).isEqualTo(LottoRank.NOTHING.reward());

	}
}

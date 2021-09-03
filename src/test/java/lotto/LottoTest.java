package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	@DisplayName("로또 결과를 통해서 상금 확인")
	void compare() {
		int lottoPrice = 1000;
		Lotto winningNumber = new Lotto(() -> Arrays.asList(8, 21, 23, 41, 42, 43), lottoPrice);
		Lotto lotto1st = new Lotto(() -> Arrays.asList(8, 21, 23, 41, 42, 43), lottoPrice);
		Lotto lotto2st = new Lotto(() -> Arrays.asList(8, 21, 23, 41, 42, 1), lottoPrice);
		Lotto lotto3st = new Lotto(() -> Arrays.asList(8, 21, 23, 41, 1, 2), lottoPrice);
		Lotto lotto4st = new Lotto(() -> Arrays.asList(8, 21, 23, 1, 2, 3), lottoPrice);
		Lotto failedLotto = new Lotto(() -> Arrays.asList(8, 21, 1, 2, 3, 4), lottoPrice);

		assertThat(lotto1st.unmaskedLotto(winningNumber).lottoRank().reward()).isEqualTo(LottoRank.FIRST.reward());

		assertThat(lotto2st.unmaskedLotto(winningNumber).lottoRank().reward()).isEqualTo(LottoRank.SECOND.reward());

		assertThat(lotto3st.unmaskedLotto(winningNumber).lottoRank().reward()).isEqualTo(LottoRank.THIRD.reward());

		assertThat(lotto4st.unmaskedLotto(winningNumber).lottoRank().reward()).isEqualTo(LottoRank.FOURTH.reward());

		assertThat(failedLotto.unmaskedLotto(winningNumber).lottoRank().reward()).isEqualTo(LottoRank.NOTHING.reward());

	}
}

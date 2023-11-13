package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningNumbersTest {
	@Test
	@DisplayName("isSame 은 주어진 로또 번호와 당첨 로또 번호가 같으면 true 를 반환한다")
	void isSame_lottoWinningNumbersWithSameNumbers_true() {
		Lotto lottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lottoNumbers);

		boolean isSame = lottoWinningNumbers.isSame(lottoNumbers);

		assertThat(isSame).isTrue();
	}

	@Test
	@DisplayName("isSame 은 주어진 로또 번호와 당첨 로또 번호가 다르면 false 를 반환한다")
	void isSame_lottoWinningNumbersWithDifferentNumbers_false() {
		Lotto differentNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 7));
		Lotto lottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lottoNumbers);

		boolean isSame = lottoWinningNumbers.isSame(differentNumbers);

		assertThat(isSame).isFalse();
	}
}

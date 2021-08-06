package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.enums.Rank;

class LottoTest {

	private final List<Integer> buyNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

	@Test
	@DisplayName("원하는 숫자로 로또 번호가 생성이 되었는가")
	void generateDesiredLottoNumber() {
		Lotto lotto = new Lotto(buyNumbers);

		assertThat(lotto.equals(new Lotto(buyNumbers))).isTrue();
	}

	@Test
	@DisplayName("당첨 번호와 3개 동일하면 4등")
	void figureOutRank() {
		Lotto buyLotto = new Lotto(buyNumbers);
		Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));

		assertThat(buyLotto.figureOutRank(winningLotto)).isEqualTo(Rank.FOURTH);
	}

	@Test
	@DisplayName("로또 번호가 8개 경우 예외 테스트")
	void validLottoNumbersLength() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
			}).withMessage("로또 번호는 6개의 숫자여야 합니다.");
	}
}
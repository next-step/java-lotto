package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoNumbersTest {

	@DisplayName("지난 주 당첨 번호 문자열로 새로운 객체를 생성한다.")
	@Test
	void create() {
		WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.from("1,2,3,4,5,6");
		assertThat(winningLottoNumbers.getWinningNumbers()).contains(1, 2, 3, 4, 5, 6).doesNotHaveDuplicates();
	}

	@DisplayName("지난 주 당첨 번호가 중복되거나, 6개보다 적거나 많으면 IllegalArgumentException 예외가 발생한다.")
	@ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,5", "1,2,3,4,5,6,7"})
	@ParameterizedTest
	void duplicateWinningNumbers(String winningNumbers) {
		assertThatThrownBy(() -> WinningLottoNumbers.from(winningNumbers))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
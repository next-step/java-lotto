package lotto.model;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

	private LottoNumbers lottoNumbers;

	@BeforeEach
	void setup() {
		this.lottoNumbers = LottoNumbers.of(asList(1, 2, 3, 4, 5, 6));
	}

	@Test
	@DisplayName("당첨 번호에는 로또 번호와 보너스 숫자가 포함되어 있다.")
	public void createTest() {
		LottoNumber lottoNumber = LottoNumber.of(7);

		WinningNumbers winningNumbers = WinningNumbers.of(lottoNumbers, lottoNumber);

		assertThat(winningNumbers.getLottoNumbers()).isEqualTo(lottoNumbers);
		assertThat(winningNumbers.getBonusNumber()).isEqualTo(lottoNumber);
	}

	@Test
	@DisplayName("보너스 숫자는 당첨 번호에 포함되면 안된다.")
	public void validateTest() {
		LottoNumber lottoNumber = LottoNumber.of(6);

		assertThatThrownBy(() -> WinningNumbers.of(lottoNumbers, lottoNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}
}

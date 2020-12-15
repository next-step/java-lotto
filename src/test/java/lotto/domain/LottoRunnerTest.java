package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRunnerTest {

	@Test
	@DisplayName("(총 금액으로 구입할 수 있는 로또) - (수동 로또 리스트의 사이즈) 만큼 자동 생성해야한다.")
	void autoAmountWithManualTest() {
		ManualLottoNumbers numbers = new ManualLottoNumbers(Arrays.asList(new LottoNumber(Arrays.asList(3, 6, 11, 28, 30, 31)) // 4개 일치
			, new LottoNumber(Arrays.asList(1, 2, 40, 41, 42, 45)) // 0개 일치
			, new LottoNumber(Arrays.asList(1, 2, 40, 41, 42, 44)))); // 0개 일치
		LottoRunner runner = new LottoRunner(5000, numbers);
		assertThat(runner.autoAmountWithManual(5000, numbers)).isEqualTo(2);
		assertThat(runner.totalAmount()).isEqualTo(5);
	}
}

package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoNumberTest {

	@DisplayName("당첨번호는 무조건 1과 45 사이여야 한다.")
	@CsvSource({"0", "46", "-99", "103", "-1"})
	@ParameterizedTest
	void 당첨번호가_1과_45_사이임이_보장된다(Integer number) {
		assertThatThrownBy(
			() -> new LottoNumber(number))
			.isInstanceOf(RuntimeException.class);
	}
}

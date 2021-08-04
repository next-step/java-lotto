package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UtilsTest {

	@ParameterizedTest
	@DisplayName("숫자를 입력하면 천단위로 몫이 반환된다.")
	@CsvSource(value = {"2000,2", "14000,14", "25500,25"})
	public void returnThousandUnit(int value, int portion) {
		int result1 = Utils.getLottoTicketNumber(value);

		assertThat(result1).isEqualTo(portion);
	}

	@ParameterizedTest
	@DisplayName("A와 B를 나눈 퍼센트 값이 반환된다.(퍼센트 기준은 1)")
	@CsvSource(value = {"5000,14000,0.36", "14000,14000,1", "28000,14000,2"})
	public void returnPercent(int value1, int value2, String percent) {
		String result = Utils.getPrizeEarningRate(value1, value2);

		assertThat(result).isEqualTo(percent);
	}
}

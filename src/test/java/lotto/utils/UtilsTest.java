package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UtilsTest {

	@ParameterizedTest
	@DisplayName("숫자를 입력하면 천단위로 몫이 반환된다.")
	@CsvSource(value = {"2000,2","14000,14","25500,25"})
	public void thousandUnitDivide(int value, int portion){
		int result1 = Utils.returnThousandUnit(value);

		assertThat(result1).isEqualTo(portion);
	}
}

package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoGameTest {
	LottoGame lotto = new LottoGame();

	@DisplayName("로또 구매 개수 계산 테스트")
	@ParameterizedTest
	@CsvSource({"14000,14", "1000,1", "10000,10"})
	public void divideByThousandTest(int input, int expected) {
		int actual = lotto.calculateLottoCount(input);
		assertThat(expected).isEqualTo(actual);
	}

	@DisplayName("로또 번호 생성 테스트")
	@Test
	public void generateLottoNumberTest() {
		int expected = 6;
		int actual = lotto.generateLottoNumber().size();
		assertThat(expected).isEqualTo(actual);
	}
}

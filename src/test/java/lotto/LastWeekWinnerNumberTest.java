package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LastWeekWinnerNumber;
import lotto.domain.LottoNumber;

public class LastWeekWinnerNumberTest {

	@Test
	@DisplayName("지난주 당첨 번호 생성")
	void lastWeekWinnerMakeTest() {
		LastWeekWinnerNumber lastWeekWinnerNumber = new LastWeekWinnerNumber("3, 1, 5, 10, 15, 25");
		assertThat(lastWeekWinnerNumber.getLastWinnerNumber().getGameNumberList()).containsExactly(new LottoNumber(1),
			new LottoNumber(3), new LottoNumber(5), new LottoNumber(10), new LottoNumber(15), new LottoNumber(25));
	}

	@Test
	@DisplayName("지난주 당첨 번호 생성 : 비정상 케이스 - 숫자가 아닌 경우")
	void lastWeekWinnerMakeInvalidTest() {
		assertThatThrownBy(() -> {
			new LastWeekWinnerNumber("3, 1, a, 10, 15, 25");
		}).isInstanceOf(NumberFormatException.class);
	}

	@Test
	@DisplayName("지난주 당첨 번호 생성 : 비정상 케이스 - 당첨번호가 6개가 아닌 경")
	void lastWeekWinnerMakeInvalid2Test() {
		assertThatThrownBy(() -> {
			new LastWeekWinnerNumber("3, 1, 10, 15, 25");
			new LastWeekWinnerNumber("3, 1, 10, 15, 25, 30, 35");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}

package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinLottoTest {

	@Test
	@DisplayName("당첨 테스트")
	void prize() {
		WinLotto win = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

		Lotto six = new Lotto(Arrays.asList(6, 4, 2, 1, 5, 3));
		Lotto five = new Lotto(Arrays.asList(6, 4, 2, 1, 5, 13));
		Lotto four = new Lotto(Arrays.asList(6, 4, 2, 1, 15, 13));
		Lotto three = new Lotto(Arrays.asList(6, 4, 2, 11, 15, 13));
		Lotto two = new Lotto(Arrays.asList(6, 4, 12, 11, 15, 13));
		Lotto one = new Lotto(Arrays.asList(6, 14, 12, 11, 15, 13));
		Lotto zero = new Lotto(Arrays.asList(16, 14, 12, 11, 15, 13));

		assertThat(six.result(win)).isEqualTo(Prize.FIRST);
		assertThat(five.result(win)).isEqualTo(Prize.SECOND);
		assertThat(four.result(win)).isEqualTo(Prize.THIRD);
		assertThat(three.result(win)).isEqualTo(Prize.FOURTH);
		assertThat(two.result(win)).isEqualTo(Prize.NOTHING);
		assertThat(one.result(win)).isEqualTo(Prize.NOTHING);
		assertThat(zero.result(win)).isEqualTo(Prize.NOTHING);
	}
}
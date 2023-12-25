package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DigitTest {
	@DisplayName("숫자 크기 비교.")
	@Test
	void 숫자_비교() {
		Digit boundaryStartPoint = new Digit(1);
		Digit boundaryEndPoint = new Digit(45);
		Digit withinDigit = new Digit(1);
		Digit outOfRangeDigit = new Digit(46);

		assertThat(withinDigit.compareTo(boundaryStartPoint)).isTrue();
		assertThat(boundaryEndPoint.compareTo(outOfRangeDigit)).isFalse();
	}
}

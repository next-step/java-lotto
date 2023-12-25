package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.EnumSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
	@DisplayName("1~45 범위 안의 숫자인지 확인.")
	@Test
	void 범위_내의_숫자인지_확인() {
		EnumSet<Lotto> lottoEnumSet;
		lottoEnumSet = EnumSet.range(Lotto.ONE, Lotto.FOURTYFIVE);
		Digit boundaryStartPoint = new Digit(1);
		Digit boundaryEndPoint = new Digit(45);
		Digit withinDigit = new Digit(1);
		Digit outOfRangeDigit = new Digit(46);

		assertThat(lottoEnumSet.stream().filter(value -> value.equalTo(withinDigit)).findFirst().get().isBetween(boundaryStartPoint, boundaryEndPoint)).isTrue();
		assertThat(lottoEnumSet.stream().filter(value -> value.equalTo(outOfRangeDigit)).findFirst().get().isBetween(boundaryStartPoint, boundaryEndPoint)).isFalse();
	}
}

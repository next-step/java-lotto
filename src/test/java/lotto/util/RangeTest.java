package lotto.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RangeTest {

	@DisplayName("1~45 범위 내로 범위체크하는지 확인")
	@ValueSource(ints = {1, 45})
	@ParameterizedTest
	public void When_numberIn1to45_Expected_contain(int value) {
		assertThat(Range.of(1, 45).contain(value))
			.isTrue();
	}

	@DisplayName("1~45 범위 밖인지 확인")
	@ValueSource(ints = {0, 46})
	@ParameterizedTest
	public void When_numberOutOf1to45_Expected_notContain(int value) {
		assertThat(Range.of(1, 45).notContain(value))
			.isTrue();
	}
}

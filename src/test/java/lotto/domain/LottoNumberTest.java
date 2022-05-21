package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import exception.OutOfRangeException;

public class LottoNumberTest {

	@DisplayName("로또번호 동등성 비교")
	@Test
	public void When_lottoNumberCreatedSameNum_expected_equalObject() {
		LottoNumber lottoNumber = LottoNumber.from(4);

		assertThat(lottoNumber.equals(LottoNumber.from(4))).isTrue();
	}

	@DisplayName("로또번호가 범위를 벗어난 경우 OutOfRangeException")
	@Test
	public void When_lottoNumberOutOfRange_expected_OutOfRangeException() {
		assertThatThrownBy(() -> LottoNumber.from(46))
			.isInstanceOf(OutOfRangeException.class);
	}

	@DisplayName("로또번호가 빈 값이거나 null 인 경우 IllegalArgumentException")
	@NullAndEmptySource
	@ParameterizedTest
	public void When_lottoNumberBlankOrNull_expected_IllegalArgumentException(String blankLottoNumber) {
		assertThatThrownBy(() -> LottoNumber.from(blankLottoNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}
}

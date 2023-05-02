package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumbersTest {

	@DisplayName("로또 넘버가 캐싱되는지 확인")
	@Test
	void test1() {
		assertThat(LottoNumber.of(1) == LottoNumber.of(1)).isTrue();
	}

	@DisplayName("로또 넘버 예외 케이스 - 범위를 벗어남")
	@ValueSource(ints = {0, 46})
	@ParameterizedTest
	void test2(int input) {
		assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(input));
	}

	@DisplayName("로또 넘버에 포함된 숫자가 있는지 판별한다.")
	@Test
	void test3() {
		LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(
			LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
			LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)
		));
		assertThat(lottoNumbers.contains(LottoNumber.of(3))).isTrue();
		assertThat(lottoNumbers.contains(LottoNumber.of(7))).isFalse();
	}
}

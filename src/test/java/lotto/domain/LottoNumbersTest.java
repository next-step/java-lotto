package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

	@DisplayName("로또 넘버에 포함된 숫자가 있는지 판별한다.")
	@Test
	void test1() {
		LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
		assertThat(lottoNumbers.contains(LottoNumber.of(3))).isTrue();
		assertThat(lottoNumbers.contains(LottoNumber.of(7))).isFalse();
	}

	@DisplayName("로또 넘버와 당첨 넘버 간 일치하는 수의 개수를 계산한다.")
	@Test
	void test2() {
		LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
		assertThat(lottoNumbers.matchCount(new LottoNumbers(1, 3, 5, 7, 9))).isEqualTo(3);
	}
}

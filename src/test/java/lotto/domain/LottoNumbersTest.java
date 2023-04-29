package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

	@DisplayName("로또 넘버에 포함된 숫자가 있는지 판별한다.")
	@Test
	void test1() {
		LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(lottoNumbers.contains(3)).isTrue();
		assertThat(lottoNumbers.contains(7)).isFalse();
	}
}

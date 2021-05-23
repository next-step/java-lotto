package lotto.converter;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.LottoNumber;

public class NumberToLottoTest {

	@ParameterizedTest
	@DisplayName(value = "숫자를 받으면 LottoNumber 로 변경한다")
	@ValueSource(ints = {10, 20, 30})
	void convertIntToLottoNumber(int number) {
		assertThat(NumberToLotto.convert(number)).isEqualTo(new LottoNumber(number));
	}

	@Test
	@DisplayName(value = "숫자 리스트를 받으면 LottoNumber를 만들어 리스트로 반환한다")
	void convertTo() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		assertThat(NumberToLotto.convert(numbers)).isEqualTo(Arrays.asList(
			new LottoNumber(1),
			new LottoNumber(2),
			new LottoNumber(3),
			new LottoNumber(4),
			new LottoNumber(5),
			new LottoNumber(6)
		));
	}

}

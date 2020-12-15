package edu.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoNumbers: LottoNumber 목록의 일급 콜렉션 클래스")
class LottoNumbersTest {
	@DisplayName("생성자: LottoNumbers 객체를 정상적으로 생성하여 리턴함")
	@Test
	void generate() {
		LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(lottoNumbers)
			.isNotNull()
			.isInstanceOf(LottoNumbers.class)
			.hasNoNullFieldsOrPropertiesExcept("lottoNumbers");
	}

	@DisplayName("생성자: 로또 번호가 개수가 지정된 것보다 많거나 적으면 Exception 발생.")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
	public void generate_shouldException(String numbers) {
		List<Integer> intNumbers = Arrays.stream(numbers.split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		assertThatThrownBy(() -> new LottoNumbers(intNumbers))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
package com.woowahan.lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class LottoAutoGeneratorTest {

	@DisplayName("generate메서드의 컬렉션 결과 사이즈는 6개이며, 1과 45 사이의 숫자를 갖는다.")
	@RepeatedTest(100)
	void generateValidation() {
		LottoGenerator lottoGenerator = new LottoAutoGenerator();
		List<Integer> numbers = lottoGenerator.generate();

		assertAll(
			() -> assertThat(numbers).hasSize(Lotto.LOTTO_NUMBER_LENGTH),
			() -> assertThat(numbers.stream()
				.allMatch(num -> num >= Lotto.LOTTO_START_NUMBER && num <= Lotto.LOTTO_END_NUMBER)).isEqualTo(true)
		);
	}
}
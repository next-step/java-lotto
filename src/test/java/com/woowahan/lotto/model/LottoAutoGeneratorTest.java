package com.woowahan.lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoAutoGeneratorTest {

	@DisplayName("generate메서드로 자동 번호로 생성된 로또 객체를 얻을 수 있다.")
	@Test
	void generate() {
		LottoGenerator lottoGenerator = new LottoAutoGenerator();
		assertThat(lottoGenerator.generate()).isInstanceOf(Lotto.class);
	}

	@DisplayName("generate메서드로 생성된 로또 객체의 numbers필드의 사이즈는 6개이며, 1과 45 사이의 숫자를 갖는다.")
	@RepeatedTest(100)
	void generateValidation() {
		LottoGenerator lottoGenerator = new LottoAutoGenerator();
		Lotto lotto = lottoGenerator.generate();
		List<Integer> numbers = lotto.getNumbers();

		assertAll(
			() -> assertThat(numbers).hasSize(Lotto.LOTTO_NUMBER_LENGTH),
			() -> assertThat(numbers.stream()
				.allMatch(num -> num >= Lotto.LOTTO_START_NUMBER && num <= Lotto.LOTTO_END_NUMBER)).isEqualTo(true)
		);
	}
}
package com.woowahan.lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAutoGeneratorTest {

	@DisplayName("generate메서드의 컬렉션 결과 사이즈는 6개이며, LottoNo 객체 타입을 가진다.")
	@Test
	void generateValidation() {
		LottoGenerator lottoGenerator = new LottoAutoGenerator();
		List<LottoNo> numbers = lottoGenerator.generate();

		assertAll(
			() -> assertThat(numbers).hasSize(Lotto.LOTTO_NUMBER_LENGTH),
			() -> assertThat(numbers).hasOnlyElementsOfType(LottoNo.class)
		);
	}
}
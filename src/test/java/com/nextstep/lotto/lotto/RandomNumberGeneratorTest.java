package com.nextstep.lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
	@Test
	void create_randomNumbers() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		Set<LottoNumber> randomNumbers = randomNumberGenerator.makeNumbers();
		assertThat(randomNumbers.size()).isEqualTo(6);
	}

	@RepeatedTest(10)
	void create_bonusNumber() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		Set<LottoNumber> randomNumbers = randomNumberGenerator.makeNumbers();
		LottoNumber bonusNumber = randomNumberGenerator.makeNumber();
		assertThat(randomNumbers.contains(bonusNumber)).isFalse();
	}
}

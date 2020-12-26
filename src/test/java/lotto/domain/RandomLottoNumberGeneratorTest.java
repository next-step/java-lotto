package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumber;
import lotto.domain.RandomLottoNumberGenerator;

class RandomLottoNumberGeneratorTest {
	private final RandomLottoNumberGenerator generator = new RandomLottoNumberGenerator();

	@Test
	@DisplayName("6개의 숫자를 생성한다.")
	void generate_size_test() {
		assertThat(generator.generate()).hasSize(6);
	}

	@Test
	@DisplayName("서로 다른 숫자를 생성한다.")
	void generate_distinct_test() {
		List<LottoNumber> lottoNumbers = generator.generate()
			.stream()
			.distinct()
			.collect(Collectors.toList());

		assertThat(lottoNumbers).hasSize(6);
	}

	@Test
	@DisplayName("생성된 숫자는 서로 다르다.")
	void generate_overlap_test() {
		List<LottoNumber> lottoNumbers1 = generator.generate();
		List<LottoNumber> lottoNumbers2 = generator.generate();

		assertThat(lottoNumbers1).isNotEqualTo(lottoNumbers2);
	}
}
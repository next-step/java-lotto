package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberGeneratorTest {

	private LottoNumberGenerator generator;

	@BeforeEach
	void setUp() {
		generator = new LottoNumberGenerator();
	}

	@DisplayName("로또를 잘 생성하는지 확인하는 테스트")
	@Test
	void test_generate_lotto() {
		Lotto lottoNumber = generator.getLottoNumber();
		assertThat(lottoNumber.size()).isEqualTo(6);
	}
}

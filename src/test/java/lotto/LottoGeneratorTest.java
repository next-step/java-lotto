package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.DrawNumber;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

	private LottoGenerator lottoGenerator;

	@BeforeEach
	void setUp() {
		lottoGenerator = new LottoGenerator(new LottoNumbersFactory(), DrawNumber.range(1, 45));
	}


	@Test
	@DisplayName("Client가 직접 생성한 Lotto를 추가하는 테스트")
	void addTest(){
		// when
		lottoGenerator.add(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)));
		lottoGenerator.add(new LottoNumbers(Arrays.asList(1,2,3,4,5,7)));

		// then
		assertThat(lottoGenerator.size())
			.isEqualTo(2);
	}


	@ParameterizedTest(name = "금액에 맞춰 자동으로 로또를 사는 기능 테스트. price[{0}], expectedSize[{1}]")
	@CsvSource(value = {
		"10000, 10", "10500, 10", "11000, 11"
	})
	void buyTest(final int price, final int expectedSize) {
		// given
		final LottoCount lottoCount = new LottoCount(new LottoMoney(price), 0);

		// when
		lottoGenerator.autoGenerate(lottoCount);

		assertThat(lottoGenerator.size())
			.isEqualTo(expectedSize);
	}

	@Test
	@DisplayName("자동으로 구매하는 로또와 수동으로 추가하는 로또의 통합 테스트")
	void totalTest(){
		// given
		final LottoCount lottoCount = new LottoCount(new LottoMoney(10000), 3);

		// when
		lottoGenerator.add(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)));
		lottoGenerator.add(new LottoNumbers(Arrays.asList(1,2,3,4,5,7)));
		lottoGenerator.add(new LottoNumbers(Arrays.asList(1,2,3,4,5,8)));
		lottoGenerator.autoGenerate(lottoCount);

		// then
		assertThat(lottoGenerator.size())
			.isEqualTo(10);
	}
}

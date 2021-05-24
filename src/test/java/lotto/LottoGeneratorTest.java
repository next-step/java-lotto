package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.DrawNumber;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

	private LottoGenerator lottoGenerator;

	@BeforeEach
	void setUp(){
		lottoGenerator = new LottoGenerator(new LottoNumbersFactory(), DrawNumber.range(1, 45));
	}

	@ParameterizedTest(name = "금액에 맞춰 로또를 사는 기능 테스트. price[{0}], expectedSize[{1}]")
	@CsvSource(value = {
		"10000, 10", "10500, 10", "11000, 11"
	})
	void buyTest(final int price, final int expectedSize) {
		assertThat(lottoGenerator.buy(new LottoMoney(price)).size())
			.isEqualTo(expectedSize);
	}
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

	private LottoGenerator lottoGenerator;

	@BeforeEach
	void setUp(){
		lottoGenerator = new LottoGenerator(new LottoNumbersFactory(), DrawNumber.range(1, 45));
	}

	@ParameterizedTest(name = "금액에 맞춰 로또를 사는 기능 테스트. price[{0}], expectedSize[{1}]")
	@CsvSource(value = {
		"10000, 10", "10500, 10", "11000, 11", "0, 0", "-1000, 0"
	})
	void buyTest(final int price, final int expectedSize) {
		// when
		lottoGenerator.buy(price);

		// then
		assertThat(lottoGenerator.lottoSize())
			.isEqualTo(expectedSize);
	}
}

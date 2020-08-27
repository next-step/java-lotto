package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.LottoGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoGameTest {

	@DisplayName(value = "로또 구입 금액에 오류가 있을 때 에러 처리 테스트")
	@ParameterizedTest
	@ValueSource(ints = {0, 500, 1500, 3256})
	void lottoPrice(int price) {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> new LottoGame().getLottos(price))
				.withMessage("로또 구입 금액은 1000원 단위만 가능합니다.");
	}

	@DisplayName(value = "로또 구입 금액만큼 발급한 로또 개수 테스트")
	@ParameterizedTest
	@CsvSource(value = {"3000:3", "14000:14"}, delimiter = ':')
	void lottoCount(int price, int expected) {
		assertThat(new LottoGame().getLottos(price)).hasSize(expected);
	}
}
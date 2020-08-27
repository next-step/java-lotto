package step4.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoGameTest {
	private static LottoGame lottoGame;

	@BeforeAll
	static void createLottoGame() {
		lottoGame = new LottoGame();
	}

	@DisplayName(value = "로또 구입 금액에 오류가 있을 때 에러 처리 테스트")
	@ParameterizedTest
	@ValueSource(ints = {0, 500, 1500, 3256})
	void lottoPriceException(int price) {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> lottoGame.checkLottoPurchase(price, 0))
				.withMessage("로또 구입 금액은 1000원 단위만 가능합니다.");
	}

	@DisplayName(value = "구입하려는 수동 로또 개수가 입력한 금액 초과 시 에러 처리 테스트")
	@Test
	void manualLottoCountException() {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> lottoGame.checkLottoPurchase(4000, 5));
	}

	@DisplayName(value = "로또 구입 금액만큼 발급한 로또 개수 테스트")
	@ParameterizedTest
	@CsvSource(value = {"3000:3", "14000:14"}, delimiter = ':')
	void lottoCount(int price, int expected) {
		lottoGame.checkLottoPurchase(price, 0);
		assertThat(lottoGame.getLottos()).hasSize(expected);
	}

}
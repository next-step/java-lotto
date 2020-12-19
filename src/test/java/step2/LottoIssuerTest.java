package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.Lotto;
import step2.domain.LottoPrice;

public class LottoIssuerTest {

	@DisplayName("로또 1장 발급")
	@Test
	void given_lotto_when_size_then_return_six() {
		Lotto lotto = new Lotto();
		assertThat(lotto.getNumbers().size()).isEqualTo(6);
	}

	@DisplayName("로또 구입금액 단위 미만의 금액 입력시 익셉션 발생")
	@Test
	void given_lotto_paid_when_lower_than_unit_price_then_exception() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			LottoPrice lottoPrice = new LottoPrice(999);
		});
	}

}

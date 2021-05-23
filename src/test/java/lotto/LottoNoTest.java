package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNoTest {
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("로또 번호 유효성 성공 테스트")
	void noValidSuccess(int number) {
		LottoNo lottoNo = new LottoNo(number);
		assertThat(lottoNo.number()).isEqualTo(number);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 46})
	@DisplayName("로또 번호 유효성 실패 테스트")
	void noValidFail(int number) {
		assertThatIllegalArgumentException().isThrownBy(() -> new LottoNo(number))
			.withMessage("로또 번호는 %d ~ %d 사이의 수여야만 합니다.", LottoNo.MIN, LottoNo.MAX);
	}
}
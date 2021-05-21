package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

	@Test
	@DisplayName("생성 테스트")
	void create() {
		assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))).isNotNull();
		assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
			.withMessage("잘못된 번호 모음입니다.");
	}

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
			.withMessage("로또 번호는 1과 45사이의 수여야만 합니다.");
	}
}

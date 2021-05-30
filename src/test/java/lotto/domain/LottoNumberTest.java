package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
	@Test
	@DisplayName("같은 숫자이면 같은 객체로 판단")
	public void same_number_then_same_object() {
		assertThat(LottoNumber.of(3)).isEqualTo(LottoNumber.of(3));
	}

	@Test
	@DisplayName("로또 번호는 1부터 45까지 가능")
	public void lotto_number_range_from_1_to_45() {
		assertThat(LottoNumber.of(3)).isEqualTo(LottoNumber.of(3));

		assertThatThrownBy(() -> LottoNumber.of(-1))
			.isInstanceOf(RuntimeException.class);

		assertThatThrownBy(() -> LottoNumber.of(0))
			.isInstanceOf(RuntimeException.class);

		assertThatThrownBy(() -> LottoNumber.of(100))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("같은 숫자이면 같은 주소값으로 판단(팩토리 메서드)")
	public void same_number_then_same_address() {
		assertThat(LottoNumber.of(3) == LottoNumber.of(3)).isTrue();
	}
}

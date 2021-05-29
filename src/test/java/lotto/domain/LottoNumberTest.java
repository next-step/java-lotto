package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
	@Test
	@DisplayName("같은 숫자이면 같은 객체로 판단")
	public void same_number_then_same_object() {
		assertThat(new LottoNumber(3)).isEqualTo(new LottoNumber(3));
	}

	@Test
	@DisplayName("로또 번호는 1부터 45까지 가능")
	public void lotto_number_range_from_1_to_45() {
		assertThat(new LottoNumber(3)).isEqualTo(new LottoNumber(3));

		assertThatThrownBy(() -> new LottoNumber(-1))
			.isInstanceOf(RuntimeException.class);

		assertThatThrownBy(() -> new LottoNumber(0))
			.isInstanceOf(RuntimeException.class);

		assertThatThrownBy(() -> new LottoNumber(100))
			.isInstanceOf(RuntimeException.class);
	}
}

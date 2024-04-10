package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
	@Test
	@DisplayName("로또 생성 테스트")
	void create_lotto_test() {
		Lotto lotto = Lotto.of("1,2,3,4,5,6");
		assertThat(lotto).isEqualTo(Lotto.of(1, 2, 3, 4, 5, 6));
	}

	@Test
	@DisplayName("로또 생성 개수 예외 처리")
	void validate_lotto_size_test() {
		assertThatThrownBy(() -> {
			Lotto.of("1,2,3,4,5");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}

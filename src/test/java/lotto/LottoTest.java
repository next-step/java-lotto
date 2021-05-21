package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	void create() {
		assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))).isNotNull();
		assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
			.withMessage("잘못된 번호 모음입니다.");
	}
}

package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	@DisplayName("생성 테스트")
	void create() {
		assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))).isNotNull();
		assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
			.withMessage("잘못된 번호 모음입니다.");
	}

	@Test
	@DisplayName("정렬 테스트")
	void sorted() {
		Lotto lotto = new Lotto(Arrays.asList(4, 3, 2, 1, 6, 5));
		assertThat(lotto.numbers()).containsExactly(1, 2, 3, 4, 5, 6);
	}

	@Test
	@DisplayName("중복 테스트")
	void duplicated() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 1, 2, 3, 4, 5)))
			.withMessage("잘못된 번호 모음입니다.");
	}
}
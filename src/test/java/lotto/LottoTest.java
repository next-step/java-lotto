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

	@Test
	@DisplayName("당첨 테스트")
	void prize() {
		Lotto win = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto six = new Lotto(Arrays.asList(6, 4, 2, 1, 5, 3));
		Lotto five = new Lotto(Arrays.asList(6, 4, 2, 1, 5, 13));
		Lotto four = new Lotto(Arrays.asList(6, 4, 2, 1, 15, 13));
		Lotto three = new Lotto(Arrays.asList(6, 4, 2, 11, 15, 13));
		Lotto two = new Lotto(Arrays.asList(6, 4, 12, 11, 15, 13));
		Lotto one = new Lotto(Arrays.asList(6, 14, 12, 11, 15, 13));
		Lotto zero = new Lotto(Arrays.asList(16, 14, 12, 11, 15, 13));

		assertThat(six.result(win)).isEqualTo(Prize.SIX);
		assertThat(five.result(win)).isEqualTo(Prize.FIVE);
		assertThat(four.result(win)).isEqualTo(Prize.FOUR);
		assertThat(three.result(win)).isEqualTo(Prize.THREE);
		assertThat(two.result(win)).isEqualTo(Prize.NOTHING);
		assertThat(one.result(win)).isEqualTo(Prize.NOTHING);
		assertThat(zero.result(win)).isEqualTo(Prize.NOTHING);
	}
}
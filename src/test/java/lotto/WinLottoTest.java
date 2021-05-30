package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinLottoTest {
	@Test
	@DisplayName("생성 테스트")
	void create() {
		assertThat(new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7)).isNotNull();
		assertThatIllegalArgumentException().isThrownBy(()
			-> new WinLotto(Arrays.asList(1, 2, 3, 4, 5), 7))
			.withMessage("잘못된 번호 모음입니다.");
	}

	@Test
	@DisplayName("중복 테스트")
	void duplicated() {
		assertThatIllegalArgumentException().isThrownBy(()
			-> new WinLotto(Arrays.asList(1, 1, 2, 3, 4, 5), 7))
			.withMessage("잘못된 번호 모음입니다.");
		assertThatIllegalArgumentException().isThrownBy(()
			-> new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 7), 7))
			.withMessage("잘못된 번호 모음입니다.");
	}

	@Test
	@DisplayName("당첨 테스트")
	void prize() {
		WinLotto win = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

		Lotto first = new Lotto(Arrays.asList(6, 4, 2, 1, 5, 3));
		Lotto second = new Lotto(Arrays.asList(6, 4, 2, 1, 5, 7));
		Lotto third = new Lotto(Arrays.asList(6, 4, 2, 1, 5, 13));
		Lotto fourth = new Lotto(Arrays.asList(6, 4, 2, 1, 15, 13));
		Lotto fifth = new Lotto(Arrays.asList(6, 4, 2, 7, 15, 13));

		Lotto matchOfTwo = new Lotto(Arrays.asList(6, 4, 12, 11, 15, 13));
		Lotto matchOfOne = new Lotto(Arrays.asList(6, 14, 12, 11, 15, 7));
		Lotto matchOfZero = new Lotto(Arrays.asList(16, 14, 12, 11, 15, 13));

		assertThat(first.result(win)).isEqualTo(Prize.FIRST);
		assertThat(second.result(win)).isEqualTo(Prize.SECOND);
		assertThat(third.result(win)).isEqualTo(Prize.THIRD);
		assertThat(fourth.result(win)).isEqualTo(Prize.FOURTH);
		assertThat(fifth.result(win)).isEqualTo(Prize.FIFTH);
		assertThat(matchOfTwo.result(win)).isEqualTo(Prize.NOTHING);
		assertThat(matchOfOne.result(win)).isEqualTo(Prize.NOTHING);
		assertThat(matchOfZero.result(win)).isEqualTo(Prize.NOTHING);
	}
}
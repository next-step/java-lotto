package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

	@Test
	@DisplayName("매개변수 set 일 때")
	void create() {
		Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6);
		Lotto lotto = new Lotto(set);

		assertThat(lotto.getLotto()).isEqualTo(set);
	}

	@Test
	@DisplayName("매개변수 String[], 당첨 번호 로또 생성")
	void createWinLotto() {
		String[] winLotto = {"1", "2", "3", "4", "5", "6"};
		Lotto lotto = new Lotto(winLotto);

		assertThat(lotto.getLotto()).isEqualTo(Set.of(1, 2, 3, 4, 5, 6));
	}

	@Test
	@DisplayName("보너스 번호 포함 여부")
	void bonus() {
		Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

		assertThat(lotto.isBonus(7)).isFalse();
		assertThat(lotto.isBonus(6)).isTrue();
	}

	@Test
	@DisplayName("자동로또, 당첨번호 포함 여부")
	void lotto() {
		Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

		assertThat(lotto.isExist(7)).isFalse();
		assertThat(lotto.isExist(6)).isTrue();
	}
}

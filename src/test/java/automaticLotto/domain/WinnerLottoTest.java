package automaticLotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerLottoTest {
	@Test
	@DisplayName("매치되는 로또 번호의 동일한 숫자의 사이즈를 구함")
	public void get_size_of_matched_lotto() {
		WinnerLotto lotto1 = new WinnerLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 8);

		assertThat(lotto1.match(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)))).isEqualTo(Ranking.RANKING_3);
	}

	@Test
	@DisplayName("보너스 번호는 로또 번호와 중복되지 않음")
	public void bonus_number_can_not_be_duplicated_with_the_six_numbers() {
		assertThatThrownBy(() -> new WinnerLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 6))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("로또 번호 5개만 맞으면 3위")
	public void five_numbers_matched_and_bonus_number_not_contained_then_ranking3() {
		WinnerLotto lotto1 = new WinnerLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

		assertThat(lotto1.match(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)))).isEqualTo(Ranking.RANKING_3);
	}

	@Test
	@DisplayName("로또 번호 5개가 맞고 보너스 번호도 포함되면 랭킹 2위")
	public void five_numbers_matched_and_bonus_number_contained_then_ranking2() {
		WinnerLotto lotto1 = new WinnerLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 8);

		assertThat(lotto1.match(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)))).isEqualTo(Ranking.RANKING_2);
	}
}

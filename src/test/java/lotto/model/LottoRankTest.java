package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class LottoRankTest {

	@Test
	@DisplayName("로또 번호 3개가 일치하면 4등 당첨이다")
	void draw_winning_3() {

//		Draw draw = new Draw();
//
//		int result = draw.match(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 7, 8, 9));
		int result = LottoRank.match(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 7, 8, 9));

		assertThat(result).isEqualTo(LottoRank.FOURTH.money());
	}
}
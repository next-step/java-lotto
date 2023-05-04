package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTest {

	@DisplayName("당첨넘버와 선택한 로또 넘버 간 일치하는 넘버가 몇개인지 계산한다.")
	@Test
	void test1() {
		Lotto lotto = new Lotto(1, 3, 5, 14, 22, 45);
		assertThat(lotto.calculateScore(new Lotto(1, 2, 3, 4, 5, 6), LottoNumber.of(7))).isEqualTo(new Score(3, 0));
	}

	@DisplayName("로또 넘버에 보너스 넘버가 있는 경우.")
	@Test
	void test2() {
		Lotto lotto = new Lotto(1, 3, 5, 14, 22, 45);
		Score score = lotto.calculateScore(new Lotto(1, 3, 5, 22, 45, 40), LottoNumber.of(14));
		assertThat(score).isEqualTo(new Score(5, 1));
	}

	@DisplayName("로또 넘버에 보너스 넘버가 없는 경우.")
	@Test
	void test3() {
		Lotto lotto = new Lotto(1, 3, 5, 14, 22, 45);
		Score score = lotto.calculateScore(new Lotto(1, 3, 5, 22, 45, 40), LottoNumber.of(23));
		assertThat(score).isEqualTo(new Score(5, 0));
	}

	@DisplayName("랭크를 추출한다.")
	@CsvSource(value = {"6,0,FIRST", "5,1,SECOND", "5,0,THIRD", "4,0,FOURTH", "3,0,FIFTH", "2,0,MISS", "1,0,MISS", "0,0,MISS"}, delimiter = ',')
	@ParameterizedTest
	void test4(int score, int bonusScore, Rank rank) {
		assertThat(new Lotto(new Score(score, bonusScore)).rank()).isEqualTo(rank);
	}
}

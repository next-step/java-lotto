package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.Lotteries;
import step2.model.Lotto;
import step2.model.Rank;

public class LotteriesTest {

	List<Integer> winNumber;
	List<Lotto> handLotto;

	@BeforeEach
	void before() {
		winNumber = Arrays.asList(1, 2, 3, 4, 5, 44);
		handLotto =
			Arrays.asList(new Lotto(Arrays.asList(14, 32, 23, 41, 25, 26)));
	}

	@Test
	@DisplayName("로또(여러장)이 맞은 개수를 보관한다.")
	void matchMap() {
		int bonusNumber = 9;
		Lotteries lotteries = Lotteries.of(handLotto, 2, new FixLottoFactory());
		assertThat(lotteries.isMatch(winNumber, bonusNumber)
			.get(Rank.THIRD))
			.isEqualTo(2);
	}

	@Test
	@DisplayName("로또(여러장)이 맞은 개수를 보관한다.")
	void matchMap_first() {
		List<Integer> winNum = Arrays.asList(1, 2, 3, 4, 5, 6);
		int bonusNumber = 9;

		Lotteries lotteries = Lotteries.of(handLotto, 2, new FixLottoFactory());

		assertThat(lotteries.isMatch(winNum, bonusNumber).get(Rank.FIRST)).isEqualTo(2);
	}

}

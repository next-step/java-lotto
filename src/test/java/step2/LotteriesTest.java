package step2;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static step2.model.Lotteries.handLotteries;
import static step2.model.Lotto.handLotto;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
	int bonusNumber;

	@BeforeEach
	void before() {
		winNumber = asList(1, 2, 3, 4, 5, 44);
		bonusNumber = 9;
	}

	@Test
	@DisplayName("로또(여러장)이 맞은 개수를 보관한다.")
	void matchMap() {

		Lotto thirdLotto = handLotto(asList(1,2,3,4,5,6));
		handLotteries(thirdLotto);

		Lotteries lotteries = Lotteries.of( 0);
		assertThat(lotteries.isMatch(winNumber, bonusNumber)
			.get(Rank.THIRD))
			.isEqualTo(1);
	}

	@Test
	@DisplayName("로또(여러장)이 맞은 개수를 보관한다.")
	void matchMap_first() {
		int bonusNumber = 9;
		Lotto firstLotto = handLotto(asList(1,2,3,4,5,44));
		handLotteries(firstLotto);
		Lotteries lotteries = Lotteries.of( 0);

		assertThat(lotteries.isMatch(winNumber, bonusNumber).get(Rank.FIRST)).isEqualTo(1);
	}

}

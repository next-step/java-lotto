package step2;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static step2.model.LottoNumbers.handNumbers;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.Lotteries;
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
		Lotteries lotteries = Lotteries.of(0);
		lotteries.handLotteries(handNumbers(asList(1, 2, 3, 4, 5, 6)));

		assertThat(lotteries.isMatch(winNumber, bonusNumber)
			.get(Rank.THIRD))
			.isEqualTo(1);
	}

	@Test
	@DisplayName("로또(여러장)이 맞은 개수를 보관한다.")
	void matchMap_first() {
		int bonusNumber = 9;
		Lotteries lotteries = Lotteries.of(0);
		lotteries.handLotteries(handNumbers(asList(1, 2, 3, 4, 5, 44)));

		assertThat(lotteries.isMatch(winNumber, bonusNumber).get(Rank.FIRST)).isEqualTo(1);
	}

}

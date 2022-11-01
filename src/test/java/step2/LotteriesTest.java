package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import step2.controller.LottoController;
import step2.model.Lotteries;
import step2.model.Lotto;
import step2.model.Rank;

public class LotteriesTest {

	@Test
	@DisplayName("로또(여러장)이 맞은 개수를 보관한다.")
	void matchMap() {
		List<Integer> winNum = Arrays.asList(1, 2, 12, 22, 33, 44);
		int bonusNumber = 9;

		Lotteries lotteries = Lotteries.of(2, new FixLottoFactory());

		assertThat(lotteries.isMatch(winNum, bonusNumber).get(Rank.MISS)).isEqualTo(2);
	}

	@Test
	@DisplayName("로또(여러장)이 맞은 개수를 보관한다.")
	void matchMap_first() {
		List<Integer> winNum = Arrays.asList(1, 2, 3, 4, 5, 6);
		int bonusNumber = 9;

		Lotteries lotteries = Lotteries.of(2, new FixLottoFactory());

		assertThat(lotteries.isMatch(winNum, bonusNumber).get(Rank.FIRST)).isEqualTo(2);
	}

}

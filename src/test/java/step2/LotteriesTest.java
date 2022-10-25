package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.Lotteries;

public class LotteriesTest {

	@Test
	@DisplayName("로또(여러장)이 맞은 개수를 보관한다.")
	void matchMap() {
		List<Integer> winNum = Arrays.asList(1, 2, 12, 22, 33, 44);
		int bonusNumber = 9;

		Lotteries lotteries = Lotteries.of(2, new FixLottoFactory());

		assertThat(lotteries.isMatch(winNum,bonusNumber).get(2)).isEqualTo(2);
	}

	@Test
	@DisplayName("맞은 개수가 5라면 bonus 번호인지 확인하고 보관한다.")
	void bonusMap(){
		List<Integer> winNum = Arrays.asList(1, 2, 3, 4, 5, 8);
		int bonusNumber = 6;

		Lotteries lotteries = Lotteries.of(2, new FixLottoFactory());
		lotteries.isMatch(winNum,bonusNumber);
		assertThat(lotteries.countOfMatchBonus()).isEqualTo(2);
	}
}

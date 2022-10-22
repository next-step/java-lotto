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
		List<Integer> winNum = Arrays.asList(1, 2, 3, 4, 5, 6);

		Lotteries lotteries = Lotteries.of(2, new FixLottoFactory());

		assertThat(lotteries.isMatch(winNum).get(2)).isEqualTo(2);
	}

}

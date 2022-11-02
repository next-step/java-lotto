package step2;

import static org.assertj.core.api.Assertions.assertThat;

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
	List<Integer> handLotto;

	@BeforeEach
	void before() {
		winNumber = Arrays.asList(1, 2, 3, 4, 5, 44);
		handLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
	}

	@Test
	@DisplayName("로또(여러장)이 맞은 개수를 보관한다.")
	void matchMap() {
		int bonusNumber = 9;
		Lotteries lotteries = Lotteries.of(handLotto, 0);
		assertThat(lotteries.isMatch(winNumber, bonusNumber)
			.get(Rank.THIRD))
			.isEqualTo(1);
	}

	@Test
	@DisplayName("로또(여러장)이 맞은 개수를 보관한다.")
	void matchMap_first() {
		int bonusNumber = 9;
		handLotto = Arrays.asList(1, 2, 3, 4, 5, 44);
		Lotteries lotteries = Lotteries.of(handLotto, 0);

		assertThat(lotteries.isMatch(winNumber, bonusNumber).get(Rank.FIRST)).isEqualTo(1);
	}

}

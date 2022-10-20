package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.FixLottoFactory.FIX_NUM_LIST;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.Lotteries;
import step2.model.Lotto;

public class LotteriesTest {

	@Test
	@DisplayName("여러장의 로또를 생성하여 가지고 있는다.")
	void lotteries(){
		assertThat(Lotteries.of(2,new FixLottoFactory())).isEqualTo(
			new Lotteries(Arrays.asList(new Lotto(FIX_NUM_LIST),new Lotto(FIX_NUM_LIST))));

	}

	@Test
	@DisplayName("로또(여러장)이 맞은 개수를 보관한다.")
	void matchMap(){
		List<Integer> winNum = Arrays.asList(1,2,3,4,5,6);

		Lotteries lotteries = Lotteries.of(2,new FixLottoFactory());

		assertThat(lotteries.isMatch(winNum).get(2)).isEqualTo(2);
	}

}

package step2;

import static step2.FixLottoFactory.FIX_NUM_LIST;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.Lotteries;
import step2.model.Lotto;

public class LotteriesTest {

	@Test
	@DisplayName("여러장의 로또를 생성하여 가지고 있는다.")
	void lotteries(){
		Assertions.assertThat(Lotteries.of(2,new FixLottoFactory())).isEqualTo(
			new Lotteries(Arrays.asList(new Lotto(FIX_NUM_LIST),new Lotto(FIX_NUM_LIST))));

	}

}

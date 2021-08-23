package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottosTest {
	@DisplayName(value = "구입 금액에 해당하는 로또 개수를 발급하는지 테스트")
	@CsvSource(value = {"14900,14", "10000,10", "5000,5", "0,0"})
	@ParameterizedTest
	void createLotto(int amount, int expect) {
		Lottos lottos = new Lottos(amount);
		List<Lotto> lottoList = lottos.getLottos();
		int numberOfLotto = lottoList.size();
		assertThat(numberOfLotto).isEqualTo(expect);
	}
}

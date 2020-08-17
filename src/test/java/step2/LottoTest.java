package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

	@DisplayName(value = "입력받은 금액에서 발급할 수 있는 로또 갯수 구하는 기능")
	@Test
	void howManyLotto() {
		int result = Lotto.getLottoCountByPrice(14000);
		assertThat(result).isEqualTo(14);
	}

	@DisplayName(value = "입력받은 갯수만큼 로또를 자동 발급 하는 기능")
	@Test
	void issueAutoLotto() {
		List<Integer[]> lottoResult = Lotto.issueAutoLotto(14);
		assertThat(lottoResult).hasSize(14);
	}
}

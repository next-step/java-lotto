package step2_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2_3.domain.Lotto;
import step2_3.domain.LottoIssuer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoIssuerTest {

	@DisplayName(value = "입력받은 금액에서 발급할 수 있는 로또 갯수 구하는 기능 테스트")
	@Test
	void howManyLotto() {
		int result = LottoIssuer.getLottoCountByPrice(14000);
		assertThat(result).isEqualTo(14);
	}

	@DisplayName(value = "입력받은 갯수만큼 로또를 자동 발급 하는 기능 테스트")
	@Test
	void issueAutoLotto() {
		List<Lotto> lottoResult = LottoIssuer.issueAutoLottos(14);
		assertThat(lottoResult).hasSize(14);
	}

}

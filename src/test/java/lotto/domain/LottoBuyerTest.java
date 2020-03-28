package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBuyerTest {

	@Test
	@DisplayName("로또 번호 구매 갯수 테스트")
	void buyLottoNumbers(){
		LottoBuyer buyer = new LottoBuyer();
		List<LottoNumber> lottoNumbers = buyer.buyLottoNumbers(14000);

		assertThat(lottoNumbers.size())
				.isEqualTo(14);

		assertThat(buyer.buyLottoNumbers(14999).size())
				.isEqualTo(14);
	}


}
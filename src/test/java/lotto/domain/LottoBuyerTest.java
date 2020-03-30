package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBuyerTest {

	@Test
	@DisplayName("로또 번호 구매 갯수 테스트")
	void buyLottoNumbersCountTest(){
		LottoBuyer buyer = new LottoBuyer();

		assertThat(buyer.buyLottoNumbers(14000).size())
				.isEqualTo(14);
		assertThat(buyer.buyLottoNumbers(14999).size())
				.isEqualTo(14);
	}

	@Test
	@DisplayName("로또 번호 전부 다 같은 번호 나오지는 않는지 확인 테스트")
	void LottoDistinctionTest(){
		LottoBuyer buyer = new LottoBuyer();
		List<LottoNumber> lottoNumbers = buyer.buyLottoNumbers(2000);

		assertThat(lottoNumbers.get(0))
				.isNotEqualTo(lottoNumbers.get(1));
	}


}
package lotto.domain;

import lotto.dto.PurchasedLottoNumbersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBuyerTest {

	@Test
	@DisplayName("로또 번호 구매 갯수 테스트")
	void buyLottoNumbersCountTest() {
		LottoBuyer buyer = new LottoBuyer(Collections.emptyList());

		assertThat(getPurchasedLottoNumbersDto(buyer, 14000).getAutoCount())
				.isEqualTo(getPurchasedLottoNumbersDto(buyer, 14999).getAutoCount())
				.isEqualTo(14);
	}

	private PurchasedLottoNumbersDto getPurchasedLottoNumbersDto(LottoBuyer buyer, int money) {
		return buyer.buyLottoNumbers(new LottoMoney(money));
	}


	@Test
	@DisplayName("로또 수동 포함한 테스트")
	void LottoPassiveTest() {
		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
		LottoBuyer buyer = new LottoBuyer(
				Arrays.asList(new LottoNumber(numberList),
						new LottoNumber(numberList),
						new LottoNumber(numberList)));
		PurchasedLottoNumbersDto lottoNumbers = getPurchasedLottoNumbersDto(buyer, 4000);

		assertThat(lottoNumbers.getAutoCount())
				.isEqualTo(1);

		assertThat(lottoNumbers.getPassiveCount())
				.isEqualTo(3);

		assertThat(lottoNumbers.getLottoNumbers())
				.anyMatch(number -> number.getNumbers().equals(numberList))
				.hasSize(4);
	}

	@Test
	@DisplayName("로또 구매 시 돈 에러처리 테스트")
	void LottoLessMoneyExceptionTest() {
		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
		LottoBuyer buyer = new LottoBuyer(
				Arrays.asList(new LottoNumber(numberList),
						new LottoNumber(numberList),
						new LottoNumber(numberList)));

		assertThatThrownBy(() -> getPurchasedLottoNumbersDto(buyer, 2000))
				.isInstanceOf(RuntimeException.class);

		assertThat(getPurchasedLottoNumbersDto(buyer,3000).getAutoCount())
				.isEqualTo(0);
	}

}
package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

	int buyingAmount;
	int manualBuyingCount;
	List<List<Integer>> userInputs;

	@BeforeEach
	void setUp() {
		buyingAmount = 14000;
		manualBuyingCount = 3;
		userInputs = new ArrayList<>();
		for (int i = 0; i < manualBuyingCount; i++) {
			userInputs.add(Arrays.asList(1, 2, 3, 4, 5, 6));
		}

	}

	@Test
	@DisplayName("자동으로 생성된 로또가 중복없이 6자리인지 확인")
	void createAutoLotto() {
		LottoNumbers lottoNumbers = LottoNumbers.createAutoLottoNumber();
		List<LottoNumber> collect = lottoNumbers.lottoNumbers().stream().distinct().collect(Collectors.toList());
		assertThat(collect.size()).isEqualTo(6);
	}

	@Test
	@DisplayName("자동 구매")
	void buyingLottoByAuto() {
		//given
		//when
		LottoStore lottoStore = new LottoStore(buyingAmount);
		List<LottoNumbers> lottoNumbers = lottoStore.buyingAutoLotto();

		//then
		assertThat(lottoNumbers.size()).isEqualTo(14);
	}

	@Test
	@DisplayName("수동, 자동 함께 구매")
	void buyingLottoByManualAndAuto() {
		//given
		//when
		LottoStore lottoStore = new LottoStore(buyingAmount, manualBuyingCount);
		List<LottoNumbers> lottoNumbers = lottoStore.buyingAutoAndManualLotto(userInputs);

		//then
		assertThat(lottoNumbers.size()).isEqualTo(14);
		assertThat(lottoNumbers).contains(
			LottoNumbers.createManualLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}

	@Test
	@DisplayName("수동 로또만 구매할 때")
	void createManualLotto() {
		//given
		//when
		LottoStore lottoStore = new LottoStore(buyingAmount, 14);
		List<LottoNumbers> lottoNumbers = lottoStore.buyingAutoAndManualLotto(userInputs);

		//then
		assertThat(lottoNumbers.size()).isEqualTo(3);
		assertThat(lottoNumbers).contains(
			LottoNumbers.createManualLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));

	}
}
package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import type.LottoRewardType;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersFactoryTest {

	private LottoNumbersFactory lottoNumbersFactory;

	@BeforeEach
	void setUp(){
		List<LottoNumbers> lottoList = Arrays.asList(
			new LottoNumbers(Arrays.asList(1,2,3,4,5,6)), 	// 6 matches
			new LottoNumbers(Arrays.asList(1,20,3,25,12,7)),// 2 matches
			new LottoNumbers(Arrays.asList(7,8,9,10,11,12)),// 0 matches
			new LottoNumbers(Arrays.asList(1,2,3,4,11,12))	// 4 matches
													);
		lottoNumbersFactory = new LottoNumbersFactory(lottoList);
	}

	@Test
	@DisplayName("당첨 로또 번호를 가지고 Summary하는 기능 테스트")
	void summaryTest(){
		// given
		LottoNumbers winnerLottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber bonusNumber = new LottoNumber(7);

		// when
		LottoResult lottoResult = lottoNumbersFactory.summary(winnerLottoNumbers, bonusNumber);

		// then
		assertThat(lottoResult).isNotNull();
		assertThat(lottoResult.count(LottoRewardType.FIRST)).isEqualTo(1);
		assertThat(lottoResult.count(LottoRewardType.FOURTH)).isEqualTo(1);

	}

}

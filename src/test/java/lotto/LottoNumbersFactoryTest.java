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
	void setUp() {
		List<LottoNumbers> lottoList = Arrays.asList(
			new LottoNumbers(Arrays.asList(1,2,3,4,5,6)), 	// 6 matches
			new LottoNumbers(Arrays.asList(1,2,3,4,5,7)), 	// 5 matches + 1 bonus
			new LottoNumbers(Arrays.asList(1,2,3,4,5,8)), 	// 5 matches
			new LottoNumbers(Arrays.asList(1,2,3,4,8,9)), 	// 4 matches
			new LottoNumbers(Arrays.asList(1,2,3,8,9,10)), 	// 3 matches
			new LottoNumbers(Arrays.asList(1,2,8,9,10,11)), // 2 matches
			new LottoNumbers(Arrays.asList(1,8,9,10,11,12)) // 1 matches
													);
		lottoNumbersFactory = new LottoNumbersFactory(lottoList);
	}

	@Test
	@DisplayName("당첨 로또 번호를 가지고 Summary하는 기능 테스트")
	void summaryTest() {
		// given
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
																		  new LottoNumber(7));

		// when
		LottoResult lottoResult = lottoNumbersFactory.summary(winningLottoNumbers);

		// then
		assertThat(lottoResult).isNotNull();
		assertThat(lottoResult.count(LottoRewardType.FIRST)).isEqualTo(1);
		assertThat(lottoResult.count(LottoRewardType.SECOND)).isEqualTo(1);
		assertThat(lottoResult.count(LottoRewardType.THIRD)).isEqualTo(1);
		assertThat(lottoResult.count(LottoRewardType.FOURTH)).isEqualTo(1);
		assertThat(lottoResult.count(LottoRewardType.FIFTH)).isEqualTo(1);
		assertThat(lottoResult.count(LottoRewardType.NONE)).isEqualTo(2);

	}

}

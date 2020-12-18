package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoLotteriesTest {
	private List<LottoNumber> lottoNumbers;

	@BeforeEach
	void setUp() {
		lottoNumbers = new ArrayList<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(5));
		lottoNumbers.add(new LottoNumber(6));
	}

	@Test
	void getCountTest() {
		LottoLotteries lottoLotteries = new LottoLotteries(
			Arrays.asList(
				new LottoLottery(lottoNumbers),
				new LottoLottery(lottoNumbers),
				new LottoLottery(lottoNumbers)
			)
		);

		assertThat(lottoLotteries.getCount()).isEqualTo(3);
	}
}

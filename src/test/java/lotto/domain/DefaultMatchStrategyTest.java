package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultMatchStrategyTest {
	List<LottoNumber> lottoNumbers;

	@BeforeEach
	void setUp() {
		lottoNumbers = Arrays.asList(
			new LottoNumber(1),
			new LottoNumber(2),
			new LottoNumber(3),
			new LottoNumber(4),
			new LottoNumber(5),
			new LottoNumber(6)
		);
	}

	@Test
	void isMatch_true_test() {
		LottoLottery lottoLottery = new LottoLottery(lottoNumbers);
		WinLottoNumbers winLottoNumbers = new WinLottoNumbers("1,2,3,4,7,8");

		assertThat(new DefaultMatchStrategy(4).isMatch(lottoLottery, winLottoNumbers)).isTrue();
	}

	@Test
	void isMatch_false_test() {
		LottoLottery lottoLottery = new LottoLottery(lottoNumbers);
		WinLottoNumbers winLottoNumbers = new WinLottoNumbers("1,2,3,4,6,8");

		assertThat(new DefaultMatchStrategy(4).isMatch(lottoLottery, winLottoNumbers)).isFalse();
	}

}

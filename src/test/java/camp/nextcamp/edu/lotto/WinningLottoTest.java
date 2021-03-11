package camp.nextcamp.edu.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoNumber;
import camp.nextcamp.edu.lotto.module.LottoModule;
import camp.nextcamp.edu.lotto.module.LottoScoreBoardModule;
import camp.nextcamp.edu.lotto.module.WinningScore;

public class WinningLottoTest {

	private static Set<LottoNumber> getMock(String input) {
		return Arrays.stream(input.split(","))
			.map(Integer::parseInt)
			.map(LottoNumber::new)
			.collect(Collectors.toSet());
	}

	@ParameterizedTest
	@DisplayName("로또 6개 맞추기")
	@CsvSource(value = {"1,2,3,4,5,6=1,2,3,4,5,6", "2,3,4,5,6,7=2,3,4,5,6,7"}, delimiter = '=')
	void 로또_6(String input, String winning) {

		// given
		Lotto lotto = new Lotto(getMock(input));
		Lotto winningLotto = new Lotto(getMock(winning));

		// when
		LottoScoreBoardModule lottoModule = LottoScoreBoardModule.getInstance();
		WinningScore winningScore = lottoModule.getWinningScore(lotto, winningLotto);

		// then
		assertThat(winningScore)
			.isEqualTo(WinningScore.SIX);
	}

	@ParameterizedTest
	@DisplayName("로또 5개 맞추기")
	@CsvSource(value = {"1,2,3,4,5,6=1,2,3,4,5,7", "2,3,4,5,6,7=2,3,4,5,6,8"}, delimiter = '=')
	void 로또_5(String input, String winning) {

		// given
		Lotto lotto = new Lotto(getMock(input));
		Lotto winningLotto = new Lotto(getMock(winning));

		// when
		LottoScoreBoardModule lottoModule = LottoScoreBoardModule.getInstance();
		WinningScore winningScore = lottoModule.getWinningScore(lotto, winningLotto);
		// then
		assertThat(winningScore)
			.isEqualTo(WinningScore.FIVE);
	}

	@ParameterizedTest
	@DisplayName("로또 4개 맞추기")
	@CsvSource(value = {"1,2,3,4,5,6=1,2,3,4,7,9", "2,3,4,10,33,7=2,3,4,5,6,7"}, delimiter = '=')
	void 로또_4(String input, String winning) {

		// given
		Lotto lotto = new Lotto(getMock(input));
		Lotto winningLotto = new Lotto(getMock(winning));

		// when
		LottoScoreBoardModule lottoModule = LottoScoreBoardModule.getInstance();
		WinningScore winningScore = lottoModule.getWinningScore(lotto, winningLotto);

		// then
		assertThat(winningScore)
			.isEqualTo(WinningScore.FOUR);
	}

	@ParameterizedTest
	@DisplayName("로또 3개 맞추")
	@CsvSource(value = {"1,2,3,4,5,6=1,10,11,33,5,6", "2,3,4,5,6,7=2,9,10,11,6,7"}, delimiter = '=')
	void 로또_3(String input, String winning) {

		// given
		Lotto lotto = new Lotto(getMock(input));
		Lotto winningLotto = new Lotto(getMock(winning));

		// when
		LottoScoreBoardModule lottoModule = LottoScoreBoardModule.getInstance();
		WinningScore winningScore = lottoModule.getWinningScore(lotto, winningLotto);

		// then
		assertThat(winningScore)
			.isEqualTo(WinningScore.THREE);
	}

	@ParameterizedTest
	@DisplayName("로또 fail")
	@CsvSource(value = {"1,2,3,4,5,6=1,11,7,8,9,10", "2,3,4,5,6,7=11,12,13,14,16,18"}, delimiter = '=')
	void 로또_fail(String input, String winning) {

		// given
		Lotto lotto = new Lotto(getMock(input));
		Lotto winningLotto = new Lotto(getMock(winning));

		// when
		LottoScoreBoardModule lottoModule = LottoScoreBoardModule.getInstance();
		WinningScore winningScore = lottoModule.getWinningScore(lotto, winningLotto);

		// then
		assertThat(winningScore)
			.isEqualTo(WinningScore.NONE);
	}
}

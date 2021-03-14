package camp.nextcamp.edu.lotto.entity;

import static camp.nextcamp.edu.lotto.exception.UserExceptionMesssage.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextcamp.edu.lotto.exception.UserException;
import camp.nextcamp.edu.lotto.module.WinningScore;

public class WinningLottoTest {

	private static Set<LottoNumber> getMock(String input) {
		return Arrays.stream(input.split(","))
			.map(Integer::parseInt)
			.map(LottoNumber::valueOf)
			.collect(Collectors.toSet());
	}

	@ParameterizedTest
	@DisplayName("로또 6개 맞추기")
	@CsvSource(value = {"1,2,3,4,5,6=1,2,3,4,5,6", "2,3,4,5,6,7=2,3,4,5,6,7"}, delimiter = '=')
	void 로또_6(String input, String winning) {

		// given
		Lotto lotto = new Lotto(getMock(input));
		WinningLotto winningLotto = new WinningLotto(new Lotto(getMock(winning)), LottoNumber.valueOf(11));

		// when
		WinningScore winningScore = winningLotto.getWinningScore(lotto);

		// then
		assertThat(winningScore)
			.isEqualTo(WinningScore.FIRST);
	}

	@ParameterizedTest
	@DisplayName("로또 5개 맞추기")
	@CsvSource(value = {"1,2,3,4,5,6=1,2,3,4,5,7", "2,3,4,5,6,7=2,3,4,5,6,8"}, delimiter = '=')
	void 로또_5(String input, String winning) {

		// given
		Lotto lotto = new Lotto(getMock(input));
		WinningLotto winningLotto = new WinningLotto(new Lotto(getMock(winning)), LottoNumber.valueOf(11));

		// when
		WinningScore winningScore = winningLotto.getWinningScore(lotto);

		// then
		assertThat(winningScore)
			.isEqualTo(WinningScore.THIRD);
	}

	@ParameterizedTest
	@DisplayName("로또 4개 맞추기")
	@CsvSource(value = {"1,2,3,4,5,6=1,2,3,4,7,9", "2,3,4,10,33,7=2,3,4,5,6,7"}, delimiter = '=')
	void 로또_4(String input, String winning) {

		// given
		Lotto lotto = new Lotto(getMock(input));
		WinningLotto winningLotto = new WinningLotto(new Lotto(getMock(winning)), LottoNumber.valueOf(11));

		// when
		WinningScore winningScore = winningLotto.getWinningScore(lotto);

		// then
		assertThat(winningScore)
			.isEqualTo(WinningScore.FOURTH);
	}

	@ParameterizedTest
	@DisplayName("로또 3개 맞추기")
	@CsvSource(value = {"1,2,3,4,5,6=1,10,11,33,5,6", "2,3,4,5,6,7=2,9,10,11,6,7"}, delimiter = '=')
	void 로또_3(String input, String winning) {

		// given
		Lotto lotto = new Lotto(getMock(input));
		WinningLotto winningLotto = new WinningLotto(new Lotto(getMock(winning)), LottoNumber.valueOf(45));

		// when
		WinningScore winningScore = winningLotto.getWinningScore(lotto);

		// then
		assertThat(winningScore)
			.isEqualTo(WinningScore.FIFTH);
	}

	@ParameterizedTest
	@DisplayName("로또 5개와 보너스 1개")
	@CsvSource(value = {"1,2,3,4,5,9=1,2,3,4,5,7", "2,3,4,5,6,9=2,3,4,5,6,7"}, delimiter = '=')
	void 로또_5_보너스(String input, String winning) {

		// given
		Lotto lotto = new Lotto(getMock(input));
		WinningLotto winningLotto = new WinningLotto(new Lotto(getMock(winning)), LottoNumber.valueOf(9));

		// when
		WinningScore winningScore = winningLotto.getWinningScore(lotto);

		// then
		assertThat(winningScore)
			.isEqualTo(WinningScore.SECOND);
	}


	@ParameterizedTest
	@DisplayName("로또 5개와 보너스 1개 중복 에러")
	@ValueSource(strings = {"1,2,3,4,5,6", "2,3,4,5,6,8"})
	void 로또_5_보너스_에러(String input) {
		// then
		assertThatExceptionOfType(UserException.class)
			.isThrownBy(() -> new WinningLotto(new Lotto(getMock(input)), LottoNumber.valueOf(5)))
			.withMessageMatching(OVERLAP_BONUS_NUMBER.getMessage());
	}


	@ParameterizedTest
	@DisplayName("로또 fail")
	@CsvSource(value = {"1,2,3,4,5,6=1,11,7,8,9,10", "2,3,4,5,6,7=11,12,13,14,16,18"}, delimiter = '=')
	void 로또_fail(String input, String winning) {

		// given
		Lotto lotto = new Lotto(getMock(input));
		WinningLotto winningLotto = new WinningLotto(new Lotto(getMock(winning)), LottoNumber.valueOf(25));

		// when
		WinningScore winningScore = winningLotto.getWinningScore(lotto);

		// then
		assertThat(winningScore)
			.isEqualTo(WinningScore.NONE);
	}


}

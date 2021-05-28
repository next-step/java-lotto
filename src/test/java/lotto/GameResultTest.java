package lotto;

import static lotto.Rank.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameResultTest {

	Lottos lottos;

	@BeforeEach
	void setUp() {
		Lotto lotto1 = LottoGenerator.generate("1,2,3,4,5,6");
		Lotto lotto2 = LottoGenerator.generate("7,8,9,10,11,12");
		Lotto lotto3 = LottoGenerator.generate("40,41,42,43,44,45");
		Lotto lotto4 = LottoGenerator.generate("40,41,42,43,44,45");
		Lotto lotto5 = LottoGenerator.generate("40,41,42,43,44,45");
		lottos = new Lottos(new ArrayList<>(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5)));
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3,4,5,6		:7		:0:0:0:0:1",
		"2,3,4,5,6,7		:1		:0:0:0:1:0",
		"2,3,4,5,6,7		:45		:0:0:1:0:0",
		"4,5,6,7,8,9		:45		:2:0:0:0:0",
		"40,41,42,43,44,45	:1		:0:0:0:0:3"
	}, delimiter = ':')
	@DisplayName("당첨 결과 확인")
	void 당첨_결과_확인(String lottoNumbers, int bonusNumber,
			int fifth, int fourth, int third, int second, int first) {
		Lotto winLotto = LottoGenerator.generate(lottoNumbers);
		LottoNumber bonusBall = LottoNumber.valueOf(bonusNumber);
		WinningLotto winningLotto = new WinningLotto(winLotto, bonusBall);

		GameResult result = new GameResult(winningLotto, lottos);
		assertThat(result.dashboard().get(FIFTH)).isEqualTo(fifth);
		assertThat(result.dashboard().get(FOURTH)).isEqualTo(fourth);
		assertThat(result.dashboard().get(THIRD)).isEqualTo(third);
		assertThat(result.dashboard().get(SECOND)).isEqualTo(second);
		assertThat(result.dashboard().get(FIRST)).isEqualTo(first);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3,4,5,6		:7		:400000.00",
		"2,3,4,5,6,7		:1		:6000.00",
		"2,3,4,5,6,7		:45		:300.00",
		"4,5,6,7,8,9		:45		:2",
		"40,41,42,43,44,45	:1		:1200000.00"
	}, delimiter = ':')
	@DisplayName("당첨 수익률 확인")
	void 당첨_수익률_확인(String lottoNumbers, int bonusNumber, double expectedRatio) {
		Lotto winLotto = LottoGenerator.generate(lottoNumbers);
		LottoNumber bonusBall = LottoNumber.valueOf(bonusNumber);
		WinningLotto winningLotto = new WinningLotto(winLotto, bonusBall);
		GameResult result = new GameResult(winningLotto, lottos);
		assertThat(result.earningRate()).isEqualTo(expectedRatio);
	}

	@Test
	@DisplayName("대시보드 불변 여부 확인")
	void checkUnmodifiedDashboard() {
		Lotto winLotto = LottoGenerator.generate("1,2,3,4,5,6");
		LottoNumber bonusBall = LottoNumber.valueOf(7);
		WinningLotto winningLotto = new WinningLotto(winLotto, bonusBall);
		GameResult result = new GameResult(winningLotto, lottos);
		Map<Rank, Integer> dashboard = result.dashboard();
		assertThatThrownBy(() -> dashboard.remove(NONE))
			.isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> dashboard.put(NONE, 1))
			.isInstanceOf(RuntimeException.class);
	}
}

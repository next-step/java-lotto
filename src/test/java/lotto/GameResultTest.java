package lotto;

import static lotto.LottoGenerator.*;
import static lotto.Rank.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.shop.Lottos;

public class GameResultTest {

	Lottos lottos;

	@BeforeEach
	void setUp() {
		Lotto lotto1 = generate("1,2,3,4,5,6");
		Lotto lotto2 = generate("7,8,9,10,11,12");
		Lotto lotto3 = generate("40,41,42,43,44,45");
		Lotto lotto4 = generate("40,41,42,43,44,45");
		Lotto lotto5 = generate("40,41,42,43,44,45");
		lottos = new Lottos(new ArrayList<>(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5)));
	}

	@ParameterizedTest
	@MethodSource("winningLottoAndGameResultProvider")
	@DisplayName("당첨 결과 확인")
	void 당첨_결과_확인(WinningLotto winningLotto,
			int fifth, int fourth, int third, int second, int first) {
		GameResult result = new GameResult(winningLotto, lottos);
		assertThat(result.dashboard().get(FIFTH)).isEqualTo(fifth);
		assertThat(result.dashboard().get(FOURTH)).isEqualTo(fourth);
		assertThat(result.dashboard().get(THIRD)).isEqualTo(third);
		assertThat(result.dashboard().get(SECOND)).isEqualTo(second);
		assertThat(result.dashboard().get(FIRST)).isEqualTo(first);
	}

	static Stream<Arguments> winningLottoAndGameResultProvider() {
		return Stream.of(
			arguments(new WinningLotto(generate("1,2,3,4,5,6"), LottoNumber.valueOf(7)),		0,0,0,0,1),
			arguments(new WinningLotto(generate("2,3,4,5,6,7"), LottoNumber.valueOf(1)),		0,0,0,1,0),
			arguments(new WinningLotto(generate("2,3,4,5,6,7"), LottoNumber.valueOf(45)),		0,0,1,0,0),
			arguments(new WinningLotto(generate("4,5,6,7,8,9"), LottoNumber.valueOf(45)),		2,0,0,0,0),
			arguments(new WinningLotto(generate("40,41,42,43,44,45"), LottoNumber.valueOf(1)),	0,0,0,0,3)
		);
	}

	@ParameterizedTest
	@MethodSource("winningLottoAndEarningRateProvider")
	@DisplayName("당첨 수익률 확인")
	void 당첨_수익률_확인(WinningLotto winningLotto, double expectedRatio) {
		GameResult result = new GameResult(winningLotto, lottos);
		assertThat(result.earningRate()).isEqualTo(expectedRatio);
	}

	static Stream<Arguments> winningLottoAndEarningRateProvider() {
		return Stream.of(
			arguments(new WinningLotto(generate("1,2,3,4,5,6"), LottoNumber.valueOf(7)),		400000.00),
			arguments(new WinningLotto(generate("2,3,4,5,6,7"), LottoNumber.valueOf(1)),		6000.00),
			arguments(new WinningLotto(generate("2,3,4,5,6,7"), LottoNumber.valueOf(45)),		300.00),
			arguments(new WinningLotto(generate("4,5,6,7,8,9"), LottoNumber.valueOf(45)),		2),
			arguments(new WinningLotto(generate("40,41,42,43,44,45"), LottoNumber.valueOf(1)),	1200000.00)
		);
	}

	@Test
	@DisplayName("대시보드 불변 여부 확인")
	void checkUnmodifiedDashboard() {
		Lotto winningNumber = generate("1,2,3,4,5,6");
		LottoNumber bonusBall = LottoNumber.valueOf(7);
		WinningLotto winningLotto = new WinningLotto(winningNumber, bonusBall);
		GameResult result = new GameResult(winningLotto, lottos);
		Map<Rank, Integer> dashboard = result.dashboard();
		assertThatThrownBy(() -> dashboard.remove(NONE))
			.isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> dashboard.put(NONE, 1))
			.isInstanceOf(RuntimeException.class);
	}
}

package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTest {
	@ParameterizedTest
	@DisplayName("로또 번호는 1~45 사이의 수이다.")
	@MethodSource("provideLottos")
	public void getLottoNumbersTest(Lotto lotto, LottoNumber expected) {
		assertThat(lotto.getNumbers()).hasSize(6);
		assertAll(() -> assertFalse(lotto.getNumbers().contains(expected)),
				() -> assertFalse(lotto.getNumbers().contains(expected)));
	}

	@ParameterizedTest
	@DisplayName("로또 당첨번호에서 공백을 제거한다.")
	@MethodSource("provideLastWeekLotto")
	public void inpuLastLottoNumberTest(Lotto lotto, LottoNumber expected) {
		assertTrue(lotto.getNumbers().contains(expected));
		assertTrue(lotto.getNumbers().contains(expected));
	}

	@Test
	@DisplayName("지난주 로또당첨 번호는 6개여야 한다.")
	public void lastLottoWrongTest() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> Lotto.of("1, 2, 3, 4, 5"))
				.withMessage("로또 번호는 6개여야 합니다.");
	}

	@Test
	@DisplayName("로또 리워드를 갖는 로또를 생성한다.")
	public void winningLottoTest() {
		Lotto winningLotto = getLottoReward();
		assertThat(winningLotto.getLottoReward()).isEqualTo(LottoReward.FIFTH);
	}

	@Test
	@DisplayName("로또 보너스 번호를 가지고 있는지 테스트")
	public void hasBonusNumberTest() {
		Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
		assertTrue(getWinningLotto().hasBonusNumber(lotto, LottoNumber.of(6)));
		assertFalse(getWinningLotto().hasBonusNumber(lotto, LottoNumber.of(7)));
	}

	private Lotto getLottoReward() {
		Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
		lotto.setLottoReward(getWinningLotto().getLottoReward(lotto));
		return lotto;
	}

	private WinningLotto getWinningLotto() {
		Lotto lastWinningLotto = Lotto.of("1, 2, 3, 14, 15, 16");
		return new WinningLotto(lastWinningLotto, LottoNumber.of(7));
	}
	private static Stream<Arguments> provideLottos() {
		return Stream.of(
				Arguments.of(Lotto.of("1,2,3,4,5,6"), LottoNumber.of(7)),
				Arguments.of(Lotto.of("1,2,3,4,5,7"), LottoNumber.of(8))
		);
	}

	private static Stream<Arguments> provideLastWeekLotto() {
		return Stream.of(
				Arguments.of(Lotto.of("1,2,3,4, 5,  6"), LottoNumber.of(5)),
				Arguments.of(Lotto.of("1,2,3,4,  40,  45"), LottoNumber.of(45))
		);
	}
}

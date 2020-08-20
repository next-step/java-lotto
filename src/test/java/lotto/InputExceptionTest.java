package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lotto.factory.WinningBallsFactory;

public class InputExceptionTest {

	@Test
	public void exceptionTest() {
		assertThatThrownBy(() -> WinningBallsFactory.create("", ""))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("당첨번호를 입력하셔야 합니다.");

		assertThatThrownBy(() -> LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("당첨번호는 6개를 입력해주세요.");

		assertThatThrownBy(() -> LottoKiosk.issue(LottoPayAmounts.of("asdf")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("구입금액은 숫자로 입력해주세요.");

		assertThatThrownBy(() -> LottoKiosk.issue(LottoPayAmounts.of("100")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("구입금액은 최소 1000원 이상 입력해주세요.");

		assertThatThrownBy(() -> BonusBall.of(""))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("보너스볼을 입력하셔야 합니다.");

		assertThatThrownBy(() -> BonusBall.of("bonusBall"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("보너스볼은 숫자로 입력하셔야 합니다.");

	}
}

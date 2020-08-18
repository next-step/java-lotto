package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import lotto.factory.WinningBallsFactory;

public class InputExceptionTest {

	@Test
	public void exceptionTest() {
		assertThatThrownBy(() -> Ranking.getRakingOf(7))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("당첨 개수는 6개를 넘을 수 없습니다.");

		assertThatThrownBy(() -> WinningBallsFactory.create(""))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("당첨번호를 입력하셔야 합니다.");

		assertThatThrownBy(() -> WinningBallsFactory.create("1,2,3,4,5,6,7"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("당첨번호는 6개를 입력해주세요.");

		assertThatThrownBy(() -> LottoKiosk.issue(LottoPayAmounts.of("asdf")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("구입금액은 숫자로 입력해주세요.");

		assertThatThrownBy(() -> LottoKiosk.issue(LottoPayAmounts.of("100")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("구입금액은 최소 1000원 이상 입력해주세요.");


	}
}

package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lotto.factory.ManualLottoNumbersFactory;
import lotto.factory.WinningBallsFactory;

public class InputExceptionTest {

	@Test
	public void exceptionTest() {
		assertThatThrownBy(() -> WinningBallsFactory.create("", ""))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("당첨번호를 입력하셔야 합니다.");

		assertThatThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("당첨번호는 6개를 입력해주세요.");

		LottoNumbers lottoNumbers1 = ManualLottoNumbersFactory.create("1,2,3,4,5,6");
		LottoNumbers lottoNumbers2 = ManualLottoNumbersFactory.create("10,11,12,13,14,15");

		assertThatThrownBy(() -> LottoKiosk.issue(LottoPurchaseArgument.of(LottoPayAmounts.of("asdf"), Arrays.asList(lottoNumbers1, lottoNumbers2))))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("구입금액은 숫자로 입력해주세요.");

		assertThatThrownBy(() -> LottoKiosk.issue(LottoPurchaseArgument.of(LottoPayAmounts.of("100"), Arrays.asList(lottoNumbers1, lottoNumbers2))))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("구입금액은 최소 1000원 이상 입력해주세요.");

		assertThatThrownBy(() -> BonusBall.of(""))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("보너스볼을 입력하셔야 합니다.");

		assertThatThrownBy(() -> BonusBall.of("bonusBall"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("보너스볼은 숫자로 입력하셔야 합니다.");

		assertThatThrownBy(() -> ManualLottoCount.of(null, "3"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("로또 구매량이 없습니다.");

		assertThatThrownBy(() -> ManualLottoCount.of(LottoPayAmounts.of("1000"), null))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("수동으로 구매할 수를 입력하셔야 합니다.");

		assertThatThrownBy(() -> ManualLottoCount.of(LottoPayAmounts.of("1000"), "lotto"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("수동으로 구매할 수를 숫자로 입력하셔야 합니다.");

		assertThatThrownBy(() -> ManualLottoCount.of(LottoPayAmounts.of("1000"), "3"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("수동으로 구매할 수는 로또 구매한 전체 양보다 적어야 합니다.");


	}
}

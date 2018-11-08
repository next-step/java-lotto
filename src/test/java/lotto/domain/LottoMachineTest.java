package lotto.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import lotto.dto.PurchaseInfo;
import lotto.dto.WinningNumber;
import org.junit.Test;

public class LottoMachineTest {

	private LottoMachine lottoMachine = new LottoMachine(new PurchaseInfo(LottoMachine.LOTTO_PRICE, Collections.emptyList()));

	@Test
	public void 자동으로_구매한_로또_확인() {
		final int lottoCount = 6;
		int money = lottoCount * LottoMachine.LOTTO_PRICE;
		LottoMachine lottoMachine = new LottoMachine(new PurchaseInfo(money, Collections.emptyList()));
		LottoTicket lottoTicket = lottoMachine.getLottos();

		assertThat(lottoTicket.getLottos()).hasSize(lottoCount);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 잘못된_구매_개수_검증() {
		int money = LottoMachine.LOTTO_PRICE - LottoMachine.LOTTO_PRICE;
		new LottoMachine(new PurchaseInfo(money, Collections.emptyList()));
	}

	@Test
	public void 문자얼로_로또_생성_검증() {
		// 주어진 문자열로부터 로또 번호 생성
		final int number1 = 1, number2 = 2, number3 = 3, number4 = 4, number5 = 5, number6 = 6;
		String numbers = String.join(", ",
				String.valueOf(number1), String.valueOf(number2), String.valueOf(number3),
				String.valueOf(number4), String.valueOf(number5), String.valueOf(number6));

		// 로또 생성
		Lotto lotto = lottoMachine.getLotto(numbers);

		assertThat(lotto.hasNumber(number1)).isTrue();
		assertThat(lotto.hasNumber(number2)).isTrue();
		assertThat(lotto.hasNumber(number3)).isTrue();
		assertThat(lotto.hasNumber(number4)).isTrue();
		assertThat(lotto.hasNumber(number5)).isTrue();
		assertThat(lotto.hasNumber(number6)).isTrue();
	}

	@Test(expected = IllegalArgumentException.class)
	public void 당첨번호와_로또번호_중복_검증() {
		// 주어진 문자열로부터 로또 번호 생성
		final int number1 = 1, number2 = 2, number3 = 3, number4 = 4, number5 = 5, number6 = 6;
		String numbers = String.join(", ",
				String.valueOf(number1), String.valueOf(number2), String.valueOf(number3),
				String.valueOf(number4), String.valueOf(number5), String.valueOf(number6));

		// 로또 생성
		WinningNumber winningNumber = new WinningNumber(numbers, 1);
		lottoMachine.getWinningLotto(winningNumber);
	}

	@Test
	public void 수동_구매_검증() {
		final int totalPickCount = 10;
		final List<String> manualNumbers = asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7", "8, 9, 12, 13, 14, 15");
		PurchaseInfo purchaseInfo = new PurchaseInfo(totalPickCount * LottoMachine.LOTTO_PRICE, manualNumbers);
		LottoMachine lottoMachine = new LottoMachine(purchaseInfo);
		LottoTicket lottoTicket = lottoMachine.getLottos();

		assertThat(lottoTicket.getLottos()).hasSize(totalPickCount);
	}
}
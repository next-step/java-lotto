package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Money;

public class LottoAppInputTest {

	private static final String INPUT_NEW_LINE = "\n";

	@Test
	@DisplayName("로또를 구매할 숫자를 입력 하면 Money 가 만들어 진다.")
	public void inputMoneyTest() {
		int inputMoneyValue = 1000;
		LottoAppInput lottoAppInput = createLottoAppInput(inputMoneyValue + INPUT_NEW_LINE);

		Money money = lottoAppInput.inputMoney();

		assertThat(money).isEqualTo(Money.wons(inputMoneyValue));
	}

	@Test
	@DisplayName("당첨 번호는 ', ' 를 구분자로 입력 받은 후 Integer List 로 리턴한다.")
	public void inputWinningNumbersTest() {
		String inputWinningNumbers = "1, 2, 3, 4, 5, 6" + INPUT_NEW_LINE;
		LottoAppInput lottoAppInput = createLottoAppInput(inputWinningNumbers);

		List<Integer> winningNumbers = lottoAppInput.inputWinningNumbers();

		assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
	}

	private LottoAppInput createLottoAppInput(String input) {
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		return new LottoAppInput(new Scanner(inputStream));
	}
}

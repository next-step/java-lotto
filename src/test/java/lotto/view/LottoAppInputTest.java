package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Money;

public class LottoAppInputTest {

	@Test
	@DisplayName("로또를 구매할 숫자를 입력 하면 Money 가 만들어 진다.")
	public void inputMoneyTest() {
		int inputMoneyValue = 1000;
		String inputMoney = inputMoneyValue + "\n";
		InputStream inputStream = new ByteArrayInputStream(inputMoney.getBytes());
		LottoAppInput lottoAppInput = new LottoAppInput(new Scanner(inputStream));

		Money money = lottoAppInput.inputMoney();

		assertThat(money).isEqualTo(Money.of(inputMoneyValue));
	}
}

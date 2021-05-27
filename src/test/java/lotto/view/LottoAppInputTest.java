package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoAppInputTest {

	private static final String INPUT_NEW_LINE = "\n";

	@Test
	@DisplayName("번호들은 ',' 또는 ', ' 를 구분자로 입력 받은 후 Integer List 로 리턴한다.")
	public void inputNumbersTest() {
		String inputWinningNumbers = "1,2, 3,4, 5,6" + INPUT_NEW_LINE;
		LottoAppInput lottoAppInput = createLottoAppInput(inputWinningNumbers);

		List<Integer> winningNumbers = lottoAppInput.inputNumbers();

		assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
	}

	@Test
	@DisplayName("숫자가 아닌 문자를 입력할 수 없다.")
	public void numberFormatExceptionTest() {
		LottoAppInput lottoAppInput = createLottoAppInput("일이삼사");

		assertThatThrownBy(lottoAppInput::inputNumber)
			.isInstanceOf(NumberFormatException.class)
			.hasMessageContaining("숫자를 입력해주세요");
	}

	private LottoAppInput createLottoAppInput(String input) {
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		return new LottoAppInput(new Scanner(inputStream));
	}
}

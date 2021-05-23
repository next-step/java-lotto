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
	@DisplayName("당첨 번호는 ',' 또는 ', ' 를 구분자로 입력 받은 후 Integer List 로 리턴한다.")
	public void inputWinningNumbersTest() {
		String inputWinningNumbers = "1,2, 3,4, 5,6" + INPUT_NEW_LINE;
		LottoAppInput lottoAppInput = createLottoAppInput(inputWinningNumbers);

		List<Integer> winningNumbers = lottoAppInput.inputWinningNumbers();

		assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
	}

	private LottoAppInput createLottoAppInput(String input) {
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		return new LottoAppInput(new Scanner(inputStream));
	}
}

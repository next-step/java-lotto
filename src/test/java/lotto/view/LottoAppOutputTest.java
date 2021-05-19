package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoAppOutputTest {

	private LottoAppOutput lottoAppOutput;
	private ByteArrayOutputStream outputStream;

	@BeforeEach
	public void setup() {
		outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		lottoAppOutput = new LottoAppOutput(printStream);
	}

	@Test
	@DisplayName("구입금액을 입력 받을때는 '구매금액을 입력해 주세요.' 라는 메시지가 출력된다.")
	public void printMoneyInputViewTest() {
		lottoAppOutput.printMoneyInputView();

		assertThat(outputStream.toString()).contains("구매금액을 입력해 주세요.");
	}

	@Test
	@DisplayName("구매한 로또 개수는 '{로또개수}개를 구매했습니다.' 라고 출력해야 한다.")
	public void printLottoCountViewTest() {
		int lottoCount = 10;

		lottoAppOutput.printBoughtLottoCountView(lottoCount);

		assertThat(outputStream.toString()).contains(lottoCount + "개를 구매했습니다.");
	}

}

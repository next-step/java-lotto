package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.LottoRank;
import lotto.view.dro.LottoRankResultDto;
import lotto.view.dro.LottoResultDto;

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

	@Test
	@DisplayName("하나의 로또 번호는 오름차순 정렬이 되어 출력된다.")
	public void printLottoNumbersTest() {
		lottoAppOutput.printLottoNumbers(Arrays.asList(4, 3, 2, 5, 6, 1));

		assertThat(outputStream.toString()).contains("[1, 2, 3, 4, 5, 6]");
	}

	@Test
	@DisplayName("당첨 번호를 입력 받을 때는 '지난 주 당첨 번호를 입력해 주세요.' 라고 출력해야 한다.")
	public void printWinningNumberInputViewTest() {
		lottoAppOutput.printWinningNumbersInputView();

		assertThat(outputStream.toString()).contains("지난 주 당첨 번호를 입력해 주세요.");
	}

	@Test
	@DisplayName("당첨 통계는 등수 별 일치하는 로또 번호 개수, 당첨 금액, 당첨 개수를 출력한다.")
	public void printLottoResultTest() {
		LottoResultDto lottoResultDto = new LottoResultDto(Arrays.asList(
			new LottoRankResultDto(LottoRank.FOUR, 1),
			new LottoRankResultDto(LottoRank.THIRD, 0),
			new LottoRankResultDto(LottoRank.SECOND, 1),
			new LottoRankResultDto(LottoRank.FIRST, 0)
		));

		lottoAppOutput.printLottoResult(lottoResultDto);

		assertThat(outputStream.toString()).contains(
			"3개 일치 (5000원)- 1개\n"
			+ "4개 일치 (50000원)- 0개\n"
			+ "5개 일치 (1500000원)- 1개\n"
			+ "6개 일치 (2000000000원)- 0개\n");
	}
}

package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.model.LottoRank;
import lotto.model.Rate;
import lotto.view.dto.LottoEarningRateDto;
import lotto.view.dto.LottoRankResultDto;
import lotto.view.dto.LottoResultDto;

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

		lottoAppOutput.printBoughtLottoNumbersCountView(lottoCount);

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
	@DisplayName("당첨 통계는 등수 별 일치하는 로또 번호 개수, 당첨 금액, 보너스볼 일치 여부 (2등만), 당첨 개수를 출력한다.")
	public void printLottoResultTest() {
		LottoResultDto lottoResultDto = new LottoResultDto(Arrays.asList(
			new LottoRankResultDto(LottoRank.FIFTH, 1),
			new LottoRankResultDto(LottoRank.FOURTH, 1),
			new LottoRankResultDto(LottoRank.THIRD, 0),
			new LottoRankResultDto(LottoRank.SECOND, 1),
			new LottoRankResultDto(LottoRank.FIRST, 0)
		), new LottoEarningRateDto(Rate.of(1.1)));

		lottoAppOutput.printLottoResult(lottoResultDto);

		assertThat(outputStream.toString()).contains(
			"3개 일치 (5000원)- 1개\n"
			+ "4개 일치 (50000원)- 1개\n"
			+ "5개 일치 (1500000원)- 0개\n"
			+ "5개 일치, 보너스 볼 일치 (30000000원)- 1개\n"
			+ "6개 일치 (2000000000원)- 0개\n");
	}

	@ParameterizedTest
	@DisplayName("수익률은 소수점 2자리 까지 출력하고 1을 기준으로 손해 or 이익 이라는 메시지를 포함하여 출력한다.")
	@CsvSource(value = {
		"0.351234f:총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)",
		"1.1f:총 수익률은 1.10입니다.(기준이 1이기 때문에 결과적으로 이익이라는 의미임)",
	}, delimiter = ':')
	public void printLottoRateResultTest(double earningRate, String expectedMessage) {
		LottoEarningRateDto lottoEarningRateDto = new LottoEarningRateDto(Rate.of(earningRate));

		lottoAppOutput.printLottoEarningsRate(lottoEarningRateDto);

		assertThat(outputStream.toString()).contains(expectedMessage);
	}

	@Test
	@DisplayName("보너스볼을 입력 받을때 '보너스 볼을 입력해 주세요.' 라고 출력해야 한다.")
	public void inputBonusNumberInputViewTest() {
		lottoAppOutput.printBonusNumberInputView();

		assertThat(outputStream.toString()).contains("보너스 볼을 입력해 주세요.");
	}

	@Test
	@DisplayName("수동 로또 수롤 입력 받을때 '수동으로 구매할 로또 수를 입력해 주세요.' 라고 출략해야 한다.")
	public void inputManualCountInputViewTest() {
		lottoAppOutput.printManualCountInputView();

		assertThat(outputStream.toString()).contains("수동으로 구매할 로또 수를 입력해 주세요.");
	}

	@Test
	@DisplayName("수동 로또 번호롤 입력 받을때 '수동으로 구매할 번호를 입력해 주세요.' 라고 출략해야 한다.")
	public void inputManualLottoNumbersInputViewTest() {
		lottoAppOutput.printManualLottoNumbersInputView();

		assertThat(outputStream.toString()).contains("수동으로 구매할 번호를 입력해 주세요.");
	}
}

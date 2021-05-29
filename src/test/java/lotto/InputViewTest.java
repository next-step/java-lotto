package lotto;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberText;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketConverter;
import lotto.domain.ManualLottoCount;
import lotto.domain.ManualLottoNumbers;
import lotto.domain.Money;

class InputViewTest {

	@Test
	void receiveMoney() {
		// given
		String userInputData = "100000\r\n";
		System.setIn(new ByteArrayInputStream(userInputData.getBytes()));
		InputView inputView = new InputView(new Console());
		Money expected = new Money("100000");

		// when
		Money actual = inputView.receiveMoney();

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void receiveManualLottoCount() {
		// given
		String userInputData = "3\r\n";
		System.setIn(new ByteArrayInputStream(userInputData.getBytes()));
		InputView inputView = new InputView(new Console());
		ManualLottoCount expected = new ManualLottoCount("3", new Money("10000"));

		// when
		ManualLottoCount actual = inputView.receiveManualLottoCount(new Money("10000"));

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void receiveManualLottoNumbers() {
		// given
		String userInputData = "1,2,3,4,5,6\r\n";
		System.setIn(new ByteArrayInputStream(userInputData.getBytes()));
		InputView inputView = new InputView(new Console());
		ManualLottoCount manualLottoCount = new ManualLottoCount("1", new Money("10000"));
		List<LottoNumberText> lottoNumberTextList = new ArrayList<>();
		lottoNumberTextList.add(new LottoNumberText("1,2,3,4,5,6"));
		ManualLottoNumbers expected = new ManualLottoNumbers(lottoNumberTextList);

		// when
		ManualLottoNumbers actual = inputView.receiveManualLottoNumbers(manualLottoCount);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void receiveWinningLottoNumber() {
		// given
		String userInputData = "1,2,3,4,5,6\r\n";
		System.setIn(new ByteArrayInputStream(userInputData.getBytes()));
		InputView inputView = new InputView(new Console());
		LottoTicket expected = LottoTicketConverter.convert("1,2,3,4,5,6");

		// when
		LottoTicket actual = inputView.receiveWinningLottoNumber();

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void receiveBonusNumber() {
		// given
		String userInputData = "7\r\n";
		System.setIn(new ByteArrayInputStream(userInputData.getBytes()));
		InputView inputView = new InputView(new Console());
		LottoNumber expected = LottoNumber.of(7);

		// when
		LottoNumber actual = inputView.receiveBonusNumber();

		// then
		assertThat(actual).isEqualTo(expected);
	}
}

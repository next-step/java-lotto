package lotto.view.input;

import lotto.number.LottoNumbers;
import lotto.option.LottoBuyPlan;
import lotto.option.LottoMoney;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyPlanInputView {

	private static final String MANUAL_NUMBER_INPUT_GUIDE_FORMAT = "수동으로 구매할 로또 번호를 입력해주세요.(총 %d장 중 %d장 째)";
	private final LottoNumbersInputView lottoNumbersInputView;
	private final ManualNumbersSizeInputView lottoManualNumbersSizeInputView;
	private final MoneyInputView moneyInputView;

	public LottoBuyPlanInputView() {
		this.lottoNumbersInputView = LottoNumbersInputView.getInstance();
		this.lottoManualNumbersSizeInputView = new ManualNumbersSizeInputView();
		this.moneyInputView = new MoneyInputView();
	}

	public LottoBuyPlan inputLottoBuyPlan() {
		LottoMoney lottoMoney = moneyInputView.getMoney();
		final long manualNumbersSize = lottoManualNumbersSizeInputView.inputManualNumbersSize(lottoMoney);
		List<LottoNumbers> lottoNumbersList = inputLottoNumbersList(manualNumbersSize);
		return new LottoBuyPlan(lottoMoney, lottoNumbersList);
	}

	private List<LottoNumbers> inputLottoNumbersList(long size) {
		List<LottoNumbers> lottoNumbersList = new ArrayList<>();
		for (long i = 0; i < size; i++) {
			final long currentInputSize = i + 1;
			final String guideMessage = String.format(MANUAL_NUMBER_INPUT_GUIDE_FORMAT, size, currentInputSize);
			LottoNumbers lottoNumbers = lottoNumbersInputView.inputLottoNumbers(guideMessage);
			lottoNumbersList.add(lottoNumbers);
		}

		return lottoNumbersList;
	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import lotto.Lotto;
import lotto.LottoGroup;
import lotto.LottoNumber;
import lotto.LottoNumbers;
import lotto.LottoRank;
import lotto.LottoReport;
import lotto.LottoUtil;
import ui.InputView;
import ui.ResultView;

public class Application {

	private final InputView inputView;
	private final ResultView resultView;

	public Application() {
		this.inputView = new InputView();
		this.resultView = new ResultView();
	}

	private List<Integer> getIntegers(String lottoNumber) {
		List<Integer> winningNumber = Arrays
			.stream(lottoNumber.split(", "))
			.map(number -> Integer.parseInt(number))
			.collect(Collectors.toList());
		return winningNumber;
	}

	public void startLottoGame() {
		int lottoPrice = 1000;
		int lottoNumberCount = 6;

		this.inputView.drawQuestionOfMoney();
		int money = this.inputView.inputAmountOfMoney();

		List<List<Integer>> lottoNumbers = LottoUtil.createRandomLottoNumbers(money / lottoPrice, lottoNumberCount);

		this.inputView.drawLottoNumbers(lottoNumbers);
		this.inputView.drawQuestionOf1stLotto();
		String lottoNumber = this.inputView.inputLottoNumbers();

		LottoGroup lottoGroup = new LottoGroup(lottoNumbers, lottoPrice, lottoNumberCount);

		this.resultView.drawResult(lottoGroup.lottoResultReport(this.getIntegers(lottoNumber)));
	}

	public static void main(String[] args) {
		Application application = new Application();
		application.startLottoGame();
	}
}

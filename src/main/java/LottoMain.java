import controller.LottoController;
import lotto.domain.Records;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

	public static void main(String[] args) {

		LottoController lottoController = new LottoController(InputView.inputMoney());

		lottoController.buyLotto();

		ResultView.outputNewLine();

		lottoController.winLotto(InputView.inputWinLottoNumbers());

		ResultView.outputNewLine();

		outputStatistics(lottoController.getMoney(), lottoController.getRecords());
	}

	private static void outputStatistics(int money, Records records) {
		ResultView.outputStatisticsTitle();
		records.getRecords().forEach(ResultView::outputLottoNumbers);
		ResultView.outputYield(money, records.sumRevenue());
	}
}

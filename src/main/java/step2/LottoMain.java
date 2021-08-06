package step2;

import java.util.List;
import java.util.Scanner;

public class LottoMain {
    private final static int LOTTO_UNIT_PRICE = 1000;

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            LottoPrice lottoPrice = new LottoPrice(LOTTO_UNIT_PRICE);

            int budget = LottoInputView.getBudgetWithPrompt("구입금액을 입력해 주세요.");

            LottoStore lottoStore = new LottoStore(lottoPrice);
            LottoBucket lottoBucket = lottoStore.buyLottoEntries(budget, new LottoRandomNumberGenerator());

            LottoResultView.printLottoQuantity(lottoBucket);
            LottoResultView.printAllLottoEntries(lottoBucket);

            List<Integer> numbers = LottoInputView.getLastDrawNumbersWithPrompt("지난 주 당첨 번호를 입력해 주세요.");

            int bonusNumber = LottoInputView.getBonusNumberWithPrompt("보너스 볼을 입력해 주세요.");

            DrawnLotto drawnLotto = new DrawnLotto(numbers, bonusNumber);

            LottoWinStatistics lottoWinStatistics = new LottoWinStatistics(lottoPrice, drawnLotto);
            lottoWinStatistics.addLottoSamples(lottoBucket);

            LottoResultView.printLottoWinStatus(lottoWinStatistics);
            LottoResultView.printProfitRate(lottoWinStatistics);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

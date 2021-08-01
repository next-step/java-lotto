package step2;

import java.util.List;
import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int budget = LottoInputView.getBudgetWithPrompt(scanner);

            LottoStore lottoStore = new LottoStore();
            LottoBucket lottoBucket = lottoStore.buyLottoEntriesByRandomNumber(budget, new LottoRandomNumberGenerator());

            LottoOutputView.printLottoQuantity(lottoBucket);
            LottoOutputView.printLottoAll(lottoBucket);

            List<Integer> numbers = LottoInputView.getLastDrawNumbersWithPrompt(scanner);
            LottoEntry lastDrawnLottoEntry = new LottoEntry(numbers);

            LottoWinStatistics lottoWinStatistics = new LottoWinStatistics(lastDrawnLottoEntry);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

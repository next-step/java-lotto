package step2;

import java.util.List;
import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int budget = LottoInputView.getBudgetWithPrompt(scanner);

            LottoService lottoService = new LottoService(budget);
            LottoBucket lottoBucket = lottoService.generateLottoes(new LottoRandomNumberGenerator());

            LottoOutputView.printLottoQuantity(lottoBucket);
            LottoOutputView.printLottoAll(lottoBucket);

            List<Integer> numbers = LottoInputView.getLastDrawNumbersWithPrompt(scanner);

            Lotto lastDrawnLotto = new Lotto(numbers);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

package step2;

public class LottoMain {
    public static void main(String[] args) {
        int budget = LottoInputView.getBudgetWithPrompt();

        LottoService lottoService = new LottoService(budget);

        LottoBucket lottoBucket = lottoService.generateLottoes(new LottoRandomNumberGenerator());

        LottoOutputView.printLottoQuantity(lottoBucket);
        LottoOutputView.printLottoAll(lottoBucket);
    }
}

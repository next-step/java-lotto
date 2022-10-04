package lotto;

public class Main {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService(new InputView(new LottoFactory()), new OutputView(
                new Calculator()));
        lottoService.purchaseLotto();
    }
}

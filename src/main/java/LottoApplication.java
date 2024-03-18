public class LottoApplication {

    public static void main(String[] args) {
        int price = InputView.promptForPurchasePrice();
        Lottos lottos = new Lottos(price);
        ResultView.print(lottos);
    }
}

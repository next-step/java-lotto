package lotto;

public class OutputView {
    private final LottoController lottoController;

    public OutputView(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public void showLottos(int money) {
        int count = money / Lotto.PRICE;

        lottoController.buy(money);

        System.out.println(count + "개를 구매했습니다.");

        for (Lotto lotto : lottoController.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}

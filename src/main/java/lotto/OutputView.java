package lotto;

import java.util.Set;

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

    public void showResult(Set<Integer> winningNumbers, int bonus) {
        LottoGameResult lottoGameResult = lottoController.play(winningNumbers, bonus);

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottoGameResult.getFifth() + "개");
        System.out.println("4개 일치 (50000원)- " + lottoGameResult.getFourth() + "개");
        System.out.println("5개 일치 (1500000원)- " + lottoGameResult.getThird() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + lottoGameResult.getSecond() + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottoGameResult.getFirst() + "개");
        System.out.println("총 수익률은 " + lottoGameResult.getProfitRatio() + "입니다.");
    }
}

package AutoLotto.view;

import AutoLotto.model.Lottos;

public class OutputView {
    private static final String PURCHASED_DONE = "개를 구매했습니다.";

    public void outputPurchasedLottos(Lottos lottos, int chances) {
        outputPurchasedLottos(chances);

        for (int i = 0; i < chances; i++) {
            String lotto = lottos.retrieveStringLotto(i).toString();
            System.out.println(lotto);
        }
    }

    private void outputPurchasedLottos(int chances) {
        System.out.println(String.format("%d%s.", chances, PURCHASED_DONE));
    }

}

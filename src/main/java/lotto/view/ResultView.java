package lotto.view;

import lotto.domain.Lottos;

public class ResultView {

    public void viewPurchaseLottoCount(int purchaseLottoCount) {
        StringBuilder sb = new StringBuilder();
        sb.append(purchaseLottoCount).append("개를 구매하였습니다.");
        System.out.println(sb.toString());
    }
    public void viewLottoNumber(Lottos lottos) {
        lottos.lottos.stream().forEach(lotto -> {
            lotto.getLottoNums().toString();
            System.out.println();
        });
    }
}

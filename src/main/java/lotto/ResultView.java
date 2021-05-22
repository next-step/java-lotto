package lotto;

import java.util.List;

public class ResultView {
    public void printPurchasedCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(LottoNumberList lottoNumberList) {
        for(int i=0; i<lottoNumberList.count(); i++) {
            System.out.println(lottoNumberList.get(i).getLottoNumbers());
        }
    }
}

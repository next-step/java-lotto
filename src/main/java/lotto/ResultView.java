package lotto;

import java.util.List;

public class ResultView {
    public void printPurchasedCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(List<LottoNumber> lottoNumberList) {
        for(int i=0; i<lottoNumberList.size(); i++) {
            System.out.println(lottoNumberList.get(i).getLottoNumbers());
        }
    }
}

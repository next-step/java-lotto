package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    public void showMyLotto(List<Lotto> lottoBundle) {
        System.out.println(lottoBundle.size() + "개를 구매하셨습니다.");

        for(Lotto lotto : lottoBundle) {
            System.out.println(lotto.checkNumber());
        }
    }
}

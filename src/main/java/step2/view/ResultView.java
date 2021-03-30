package step2.view;

import step2.domain.Lotto;

import java.util.List;

public class ResultView {
    public void displayLotto(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList){
            System.out.println(lotto.displayLottoNumber());
        }
    }

    public void displayLottoCount(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
    }
}

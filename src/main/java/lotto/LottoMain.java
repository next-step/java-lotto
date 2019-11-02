package lotto;

import lotto.view.LottoResultView;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 22:36
 */
public class LottoMain {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(14000);
        LottoResultView.printLotto(lottoMachine.getLottoNumbers());


    }
}

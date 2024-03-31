package lotto.ui;

import lotto.domain.*;
import lotto.match.LottoPrizeCountCalculator;
import lotto.match.LottoResult;

import java.util.List;


public class LottoService {

    public final static int LOTTO_VALUE = 1000;


    public LottoList purchaseLotto(String requestMoney, String passiveLottoCount, List<String> lottoNumbers) {
        int count = getCount(requestMoney, passiveLottoCount);

        List<Lotto> passiveLotto = LottoMaker.convertPassiveLotto(lottoNumbers);

        List<Lotto> autoLotto = LottoMaker.createAutoLotto(count);

        passiveLotto.addAll(autoLotto);
        return new LottoList(passiveLotto);
    }

    private static int getCount(String requestMoney, String passiveLottoCount) {
        return (Integer.parseInt(requestMoney) - Integer.parseInt(passiveLottoCount) * LOTTO_VALUE) / LOTTO_VALUE;
    }

    public AnswerSheet getAnswerSheet(String answerSheet, String bonusNumberText) {
        Lotto answerLotto = new Lotto(LottoMaker.convertTextToLotto(answerSheet));
        LottoNumber bonusNumber = LottoNumber.of(Integer.parseInt(bonusNumberText));

        return new AnswerSheet(answerLotto, bonusNumber);
    }

    public LottoResult createLottoResult(LottoList lottoList, AnswerSheet answerSheet) {

        LottoPrizeCountCalculator calculator = new LottoPrizeCountCalculator(lottoList, answerSheet);
        return new LottoResult(calculator.getLottoPrizeCount());
    }

}

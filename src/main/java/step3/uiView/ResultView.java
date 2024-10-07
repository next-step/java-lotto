package step3.uiView;


import step3.enums.LottoPrize;
import step3.enums.PrizeMessage;
import step3.enums.ResultMessage;
import step3.model.Lotto;
import step3.model.LottoConfirmation;

import java.util.Arrays;
import java.util.Set;

public class ResultView {

    private final static String LOTTO_COUNT = "{count}";
    private final static String LOTTO_RATE = "{rate}";

    //구매한 로또 번호를 출력한다.
    public void lottoView(Lotto lotto) {
        System.out.println(ResultMessage.RESULT_LOTTO_COUNT.message().replace(LOTTO_COUNT, String.valueOf(lotto.getLottos().size())));
        for (Set<Integer> lottoNum : lotto.getLottos()) {
            System.out.println(lottoNum.toString());
        }
    }

    //당첨통계를 출력한다.
    public void lottoPrizeView(LottoConfirmation lottoConfirmation) {
        System.out.println(ResultMessage.RESULT_LOTTO_STATICS.message());
        Arrays.stream(LottoPrize.values())
                .forEach(lottoPrize -> System.out.println(PrizeMessage.matchCountMessage(lottoPrize, lottoConfirmation.getPrize(lottoPrize))));
    }

    //수익율을 출력한다.
    public void lottoRateReturn(LottoConfirmation lottoConfirmation) {
        System.out.println(ResultMessage.RESULT_RATE_RETURN.message().replace(LOTTO_RATE, String.valueOf(lottoConfirmation.rateOfReturn())));
    }

}

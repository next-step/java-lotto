package step2.uiView;


import step2.enums.PrizeMessage;
import step2.enums.ResultMessage;
import step2.model.Lotto;
import step2.model.LottoConfirmation;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private final static String LOTTO_COUNT = "{count}";
    private final static String LOTTO_RATE = "{rate}";

    //구매한 로또 번호를 출력한다.
    public void lottoView(Lotto lotto) {
        System.out.println(ResultMessage.RESULT_LOTTO_COUNT.message().replace(LOTTO_COUNT, String.valueOf(lotto.getLottos().size())));
        for (List<Integer> lottoNum : lotto.getLottos()) {
            System.out.println(lottoNum.toString());
        }
    }

    //당첨통계를 출력한다.
    public void lottoPrizeView(LottoConfirmation lottoConfirmation) {
        System.out.println(ResultMessage.RESULT_LOTTO_STATICS.message());
        IntStream.range(3, 7).forEach(matchCount -> {
            System.out.println(PrizeMessage.matchCountMessage(matchCount, lottoConfirmation.getPrize(matchCount)));
        });
    }

    //수익율을 출력한다.
    public void lottoRateReturn(LottoConfirmation lottoConfirmation) {
        System.out.println(ResultMessage.RESULT_RATE_RETURN.message().replace(LOTTO_RATE, String.valueOf(lottoConfirmation.rateOfReturn())));
    }

}

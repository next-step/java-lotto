package step2.uiView;


import step2.enums.Message;
import step2.enums.PrizeMessage;
import step2.model.Lotto;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private final static String LOTTO_COUNT = "{count}";
    private final static String LOTTO_RATE = "{rate}";

    //구매한 로또 번호를 출력한다.
    public void lottoView(Lotto lotto) {
        System.out.println(Message.RESULT_LOTTO_COUNT.message().replace(LOTTO_COUNT, String.valueOf(lotto.getLottos().size())));
        for (List<Integer> lottoNum : lotto.getLottos()) {
            System.out.println(lottoNum.toString());
        }
    }

    //당첨통계를 출력한다.
    public void lottoPrizeView(Lotto lotto) {
        System.out.println(Message.RESULT_LOTTO_STATICS.message());
        IntStream.range(3, 7).forEach(matchCount -> {
            System.out.println(PrizeMessage.matchCountMessage(matchCount, lotto.getPrizeStatics().getPrize(matchCount)));
        });
    }

    //수익율을 출력한다.
    public void lottoRateReturn(Lotto lotto) {
        System.out.println(Message.RESULT_RATE_RETURN.message().replace(LOTTO_RATE, String.valueOf(lotto.rateOfReturn())));
    }

}

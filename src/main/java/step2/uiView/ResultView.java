package step2.uiView;


import step2.enums.Message;
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
            checkMatchCount(matchCount, lotto.getPrizeStatics().getPrize(matchCount));
        });
    }

    //수익율을 출력한다.
    public void lottoRateReturn(Lotto lotto) {
        System.out.println(Message.RESULT_RATE_RETURN.message().replace(LOTTO_RATE, String.valueOf(lotto.rateOfReturn())));
    }

    private void checkMatchCount(int matchCount, int count) {
        switch (matchCount) {
            case 3:
                System.out.println(Message.RESULT_THREE_CORRECT.message().replace(LOTTO_COUNT, String.valueOf(count)));
                break;
            case 4:
                System.out.println(Message.RESULT_FOUR_CORRECT.message().replace(LOTTO_COUNT, String.valueOf(count)));
                break;
            case 5:
                System.out.println(Message.RESULT_FIVE_CORRECT.message().replace(LOTTO_COUNT, String.valueOf(count)));
                break;
            case 6:
                System.out.println(Message.RESULT_SIX_CORRECT.message().replace(LOTTO_COUNT, String.valueOf(count)));
                break;
        }
    }
}

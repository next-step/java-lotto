package lotto.view.web;

import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;

public class HelperSource {
    public static CharSequence render (String text) {
        return text;
    }
    
    public static CharSequence rank(LottoPrize lottoPrize, LottoResult lottoResult) {
        String text = "%d개 일치  (%d원) - %d개";
        if (LottoPrize.SECOND.equals(lottoPrize)) {
            text = "%d개 일치,  보너스 볼 일치(%d원) - %d개";
        }
        return String.format(text, lottoPrize.getMatchCount(), lottoPrize.getPrize(), lottoResult.getCountByLottoPrize(lottoPrize));
    }
}

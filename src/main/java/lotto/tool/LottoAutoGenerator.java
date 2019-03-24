package lotto.tool;

import lotto.domain.LottoBasicNumber;
import lotto.domain.LottoBall;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoGenerator {

    public static List<LottoBall> random() {
        LottoShuffler.shuffle(LottoBasicNumber.basicNumbers);
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 0; i < LottoTicket.LOTTO_SIZE; i++) {
            lottoBalls.add(LottoBasicNumber.basicNumbers.get(i));
        }
        return sort(lottoBalls);
    }

    public static List<LottoBall> sort(List<LottoBall> lottoBalls) {
        Collections.sort(lottoBalls);
        return lottoBalls;
    }
}

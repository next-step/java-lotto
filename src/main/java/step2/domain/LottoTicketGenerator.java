package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketGenerator {
    static final int BASIC_LOTTO_SIZE = 6;

    static LottoTicket issue() {
        return new LottoTicket(pickLottoBalls(LottoBalls.getLottoBalls()));
    }

    static LottoTicket issue(List<LottoNumber> lottoTicket) {
        return new LottoTicket(lottoTicket);
    }

    static List<LottoNumber> pickLottoBalls(List<Integer> lottoBalls) {
        shuffleLottoBalls(lottoBalls);
        return lottoBalls.stream()
                .limit(BASIC_LOTTO_SIZE)
                .sorted()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    static void shuffleLottoBalls(List<Integer> lottoBalls) {
        Collections.shuffle(lottoBalls);
    }

}

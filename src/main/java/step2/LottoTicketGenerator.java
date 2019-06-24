package step2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketGenerator {
    static final int BASIC_LOTTO_SIZE = 6;

    static LottoTicket issue() {
        return new LottoTicket(pickLottoBalls(generateLottoBalls()));
    }

    static List<Integer> pickLottoBalls(List<Integer> lottoBalls) {
        shuffleLottoBalls(lottoBalls);
        return lottoBalls.stream()
                .limit(BASIC_LOTTO_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }

    static void shuffleLottoBalls(List<Integer> lottoBalls) {
        Collections.shuffle(lottoBalls);
    }

    static List<Integer> generateLottoBalls() {
        return IntStream
                .rangeClosed(LottoNumber.MINIMUM_LOTTO_NUMBER, LottoNumber.MAXIMUM_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}

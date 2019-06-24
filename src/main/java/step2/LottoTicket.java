package step2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTicket {

    static final int NUMBER_OF_BASIC_LOTTO_NUMBER = 6;
    private final List<Integer> lottoTicket;

    private LottoTicket(List<Integer> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public static LottoTicket from() {
        return new LottoTicket(pickSixBalls(generateLottoBalls()));
    }

    static List<Integer> pickSixBalls(Stream<Integer> lottoBalls) {
        return lottoBalls
                .limit(NUMBER_OF_BASIC_LOTTO_NUMBER)
                .collect(Collectors.toList());
    }

    static Stream<Integer> generateLottoBalls() {
        return IntStream
                .rangeClosed(LottoNumber.MINIMUM_LOTTO_NUMBER, LottoNumber.MAXIMUM_LOTTO_NUMBER)
                .boxed();
    }

    public List<Integer> getLottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }
}

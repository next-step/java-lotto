package lotto.domain.generator;

import lotto.domain.LottoBall;
import lotto.domain.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoTicketGenerator implements LottoTicketGenerator {
    private final static int LOTTO_BALLS_MAX_NUM = 6;
    private static final List<Integer> LOTTO_BALLS =
        IntStream.rangeClosed(LottoBall.LOTTO_BALL_NUMBER_MIN, LottoBall.LOTTO_BALL_NUMBER_MAX)
            .boxed()
            .collect(Collectors.toList());

    private final LottoTicket lottoTicket;

    public AutoLottoTicketGenerator() {
        lottoTicket = createRandomNumber();
    }

    private LottoTicket createRandomNumber() {
        Collections.shuffle(LOTTO_BALLS);

        return LottoTicket.of(LOTTO_BALLS.subList(0, LOTTO_BALLS_MAX_NUM).stream()
            .mapToInt(Integer::intValue)
            .toArray());
    }


    public LottoTicket generate() {
        return lottoTicket;
    }
}

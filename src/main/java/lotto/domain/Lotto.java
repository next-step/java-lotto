package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static int LOTTO_LOWER_BOUND = 1;
    public static int LOTTO_UPPER_BOUND = 46;
    public static int LOTTO_FROM_INDEX = 0;
    public static int LOTTO_LENGTH = 6;
    public static List<Integer> LOTTO_NUMBERS = IntStream.range(LOTTO_LOWER_BOUND, LOTTO_UPPER_BOUND)
            .boxed()
            .collect(Collectors.toList());

    private final List<Integer> lottoTicket;

    Lotto(List<Integer> lottoTicket) {
        Collections.sort(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    public static Lotto initLotto() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new Lotto(LOTTO_NUMBERS.subList(LOTTO_FROM_INDEX, LOTTO_LENGTH));
    }

    public int getLottoSize() {
        return lottoTicket.size();
    }

    @Override
    public String toString() {
        return "" + lottoTicket;
    }
}

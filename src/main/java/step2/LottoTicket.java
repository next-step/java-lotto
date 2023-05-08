package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class LottoTicket {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    static final int LOTTO_MIN_INDEX = 0;
    static final int LOTTO_MAX_INDEX = 6;

    List<Integer> sixNumbers = new ArrayList<>();
}

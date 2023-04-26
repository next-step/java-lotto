package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class LottoTicket {
    List<Integer> sixNumbers = new ArrayList<>();
    int LOTTO_MIN_NUMBER = 1;
    int LOTTO_MAX_NUMBER = 45;
    int LOTTO_MIN_INDEX = 0;
    int LOTTO_MAX_INDEX = 6;
    List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
}

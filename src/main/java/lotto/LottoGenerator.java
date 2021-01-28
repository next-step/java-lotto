package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LottoGenerator {
    private static final int VALUE_LEFT_BOUND = 1;
    private static final int VALUE_RIHGT_BOUND = 46;

    private static final int COUNT_LEFT_BOUND = 0;
    private static final int COUNT_RIGHT_BOUND = 5;

    private static List<LottoNumber> candidateNumbers = new ArrayList<>();

    static {
        for (int i = VALUE_LEFT_BOUND; i < VALUE_RIHGT_BOUND; i++) {
            candidateNumbers.add(
                new LottoNumber(i)
            );
        }
    }

    public static LottoTicket generateLotto() {
        Collections.shuffle(candidateNumbers);

        List<LottoNumber> selectedNumbers = candidateNumbers.subList(
            COUNT_LEFT_BOUND, COUNT_RIGHT_BOUND
        );
        Collections.sort(selectedNumbers);

        return new LottoTicket(selectedNumbers);
    }
}

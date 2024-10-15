package lotto.domain.lotto.generate;

import lotto.domain.lotto.ticket.LottoNumber;
import lotto.domain.lotto.ticket.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerate implements Generate {

    private static final List<Integer> numbers = new ArrayList<>(List.of(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45
    ));

    public LottoTicket generate() {
        Collections.shuffle(numbers);
        return new LottoTicket(numbers.subList(0, 6).stream().map(LottoNumber::new).collect(Collectors.toList()));
    }
}

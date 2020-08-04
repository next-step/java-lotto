package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketGenerator {
    private static final int LOTTO_NUMBER_COUNTS = 6;
    private static final List<Integer> LOTTO_CANDIDATE_NUMBERS = IntStream
            .range(1, 45)
            .boxed()
            .collect(Collectors.toList());
    private static final int LOTTERY_PRICE = 1000;

    private LottoTicketGenerator() {}

    public static LottoTicket purchaseGoodLuck(int amount) {
        int count = amount / LOTTERY_PRICE;
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(generateNumbers());
        }
        return new LottoTicket(lottoNumbers);
    }

    private static LottoNumber generateNumbers() {
        Collections.shuffle(LOTTO_CANDIDATE_NUMBERS);
        return LOTTO_CANDIDATE_NUMBERS
                .stream()
                .limit(LOTTO_NUMBER_COUNTS)
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        LottoNumber::new));
    }
}

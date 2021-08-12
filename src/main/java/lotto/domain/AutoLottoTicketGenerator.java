package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoTicketGenerator implements LottoTicketGenerator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO_MAX_COUNT = 6;

    private static List<Integer> lottoNumberList = new ArrayList<>();

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumberList.add(i);
        }
    }

    @Override
    public LottoTicket execute() {
        Collections.shuffle(lottoNumberList);

        return LottoTicket.of(lottoNumberList.stream()
                .limit(NUMBER_OF_LOTTO_MAX_COUNT)
                .sorted()
                .collect(Collectors.toList()));
    }
}

package lotto.utils;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoTicketGenerator implements LottoTicketGenerator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_GENERATION_COUNT_RANGE_START = 0;
    private static final int LOTTO_GENERATION_COUNT_RANGE_END = 6;

    private static List<Integer> lottoNumberList = new ArrayList<>();

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumberList.add(i);
        }
    }

    @Override
    public LottoTicket execute() {
        Collections.shuffle(lottoNumberList);

        List<Integer> pickedLottoNumbers = lottoNumberList.subList(LOTTO_GENERATION_COUNT_RANGE_START, LOTTO_GENERATION_COUNT_RANGE_END);

        Collections.sort(pickedLottoNumbers);

        return LottoTicket.of(pickedLottoNumbers);
    }
}

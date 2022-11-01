package lotto.domain.lottogenerator;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public List<LottoTicket> create(final int countOfTickets) {
        return IntStream.range(0, countOfTickets)
                .mapToObj(i -> createLottoTicket())
                .collect(Collectors.toList());
    }

    private LottoTicket createLottoTicket() {
        List<Integer> numList = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);
        return new LottoTicket(numList.subList(0, LottoTicket.LOTTO_NUMBER_SIZE));
    }
}

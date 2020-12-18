package lotto.domain;

import lotto.domain.numbers.LottoNumber;
import lotto.domain.numbers.LottoTicket;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketFactory {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int SPLIT_START_INDEX = 0;
    private static final int SPLIT_END_INDEX = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicketFactory() {
        this.lottoNumbers = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoTicket makeAutoLottoTicket() {
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(splitAndSortNumbers());
    }

    private List<LottoNumber> splitAndSortNumbers() {
        return lottoNumbers.subList(SPLIT_START_INDEX, SPLIT_END_INDEX)
                .stream()
                .sorted(Comparator.comparing(LottoNumber::getValue))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}

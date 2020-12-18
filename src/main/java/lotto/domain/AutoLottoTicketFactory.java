package lotto.domain;

import lotto.domain.numbers.LottoNumber;
import lotto.domain.numbers.LottoTicket;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoTicketFactory {
    private static final int SPLIT_START_INDEX = 0;
    private static final int SPLIT_END_INDEX = 6;

    private final List<LottoNumber> lottoNumbers;

    public AutoLottoTicketFactory() {
        this.lottoNumbers = LottoNumberCache.getLottoNumbers();
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

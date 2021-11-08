package lotto.service.domain;

import lotto.service.model.LottoTicket;
import lotto.service.value.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketRandomGenerator implements LottoTicketGenerator {
    private static final Integer START_NUMBER = 1;
    private static final Integer END_NUMBER = 45;
    private static final Integer LOTTO_NUMBER_COUNT = 6;

    @Override
    public LottoTicket makeLottoTicket() {
        List<Integer> lottoNumbers = getLottoNumbers();

        return LottoTicket.from(choiceRandomNumbers(lottoNumbers));
    }

    private List<Integer> getLottoNumbers() {
        return IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private List<LottoNumber> choiceRandomNumbers(List<Integer> lottoNumbers) {
        Collections.shuffle(lottoNumbers);

        return lottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }
}
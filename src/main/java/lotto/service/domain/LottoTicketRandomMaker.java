package lotto.service.domain;

import lotto.service.value.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.rule.LottoRule.*;

public class LottoTicketRandomMaker implements LottoTicketMaker {
    @Override
    public LottoTicket createLottoTicket() {
        List<Integer> lottoNumbers = getLottoNumbers();

        return LottoTicket.from(choiceRandomNumbers(lottoNumbers));
    }

    private List<Integer> getLottoNumbers() {
        return IntStream.rangeClosed(MINIMUM_NUMBER, MAXIMUM_NUMBER)
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

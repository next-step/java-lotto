package lotto.service.domain.factory;

import lotto.service.domain.LottoTicket;
import lotto.service.value.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.rule.LottoRule.*;

public class LottoTicketFactory {
    public LottoTicket createLottoTicketByManual(List<Integer> lottoNumbers) {
        return LottoTicket.from(choiceNumbers(lottoNumbers));
    }

    public LottoTicket createLottoTicketByAuto() {
        List<Integer> lottoNumbers = getLottoNumbers();
        Collections.shuffle(lottoNumbers);
        return LottoTicket.from(choiceNumbers(lottoNumbers));
    }

    private List<Integer> getLottoNumbers() {
        return IntStream.rangeClosed(MINIMUM_NUMBER, MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private List<LottoNumber> choiceNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }
}

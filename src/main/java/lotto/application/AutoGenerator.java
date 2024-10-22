package lotto.application;

import lotto.domain.ticket.LottoNumber;
import lotto.domain.ticket.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoGenerator implements LottoGenerator {

    @Override
    public List<LottoNumber> getLottoNumbers() {
        List<Integer> baseLottoNumbers = getBaseLottoNumbers();
        Collections.shuffle(baseLottoNumbers);

        return baseLottoNumbers.stream()
                               .limit(LottoTicket.LOTTO_NUMBERS_SIZE)
                               .sorted()
                               .map(LottoNumber::new)
                               .collect(Collectors.toList());
    }

    private List<Integer> getBaseLottoNumbers() {
        List<Integer> baseLottoNumbers = new ArrayList<>();

        IntStream.rangeClosed(LottoNumber.LOTTO_NUMBER_MIN, LottoNumber.LOTTO_NUMBER_MAX)
                 .forEach(baseLottoNumbers::add);

        return baseLottoNumbers;
    }

}

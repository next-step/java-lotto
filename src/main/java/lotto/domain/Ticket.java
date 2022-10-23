package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
    private final List<LottoNumber> lottoNumbers;

    public Ticket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Ticket of(List<Integer> numberList) {
        return numberList.stream()
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ticket::new));
    }

    public static Ticket create() {
        return of(LottoNumberGenerator.generate());
    }


    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}

package lotto.domain;

import java.util.List;

public class Ticket {
    private final List<Integer> lottoNumbers;

    public Ticket() {
        this.lottoNumbers = LottoNumberGenerator.generate();
    }

    public Ticket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}

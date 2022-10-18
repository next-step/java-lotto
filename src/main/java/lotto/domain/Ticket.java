package lotto.domain;

import java.util.List;

public class Ticket {
    private final List<Integer> lottoNumbers;

    public Ticket() {
        this.lottoNumbers = LottoNumberGenerator.generate();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}

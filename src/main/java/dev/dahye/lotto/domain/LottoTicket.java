package dev.dahye.lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket create() {
        return new LottoTicket(Collections.emptyList());
    }
}

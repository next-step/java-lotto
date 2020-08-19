package lotto.domain;

import java.util.List;

public class LottoTicket {
    public static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
}

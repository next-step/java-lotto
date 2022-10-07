package lotto.domain;

import java.util.Optional;

public class LottoNo {
    private final Integer lottoNumber;

    public LottoNo(Integer lottoNumber) {
        this.lottoNumber = Optional.ofNullable(lottoNumber)
                .orElse(0);
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }
}

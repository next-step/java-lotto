package lotto.dto;

import lotto.domain.Lotto;

/**
 * @author han
 */
public class LottoDto {
    private final String lottoNumber;

    public LottoDto(String lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public Lotto toLotto() {
        return new Lotto(this.lottoNumber);
    }
}

package step2.dto;

import step2.domain.Lotto;

import java.util.List;

public class LottoDto {

    private List<Integer> lottoNubers;

    public LottoDto(Lotto lottoNumbers) {
        this.lottoNubers = lottoNumbers.toNumberList();
    }
}

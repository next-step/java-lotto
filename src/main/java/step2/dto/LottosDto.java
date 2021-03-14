package step2.dto;

import step2.domain.Lottos;

import java.util.List;

public class LottosDto {

    private final List<LottoDto> lottoDtoList;

    public LottosDto(Lottos lotto) {
        this.lottoDtoList = lotto.getLottoDtoList();
    }

    public List<LottoDto> getLottoDtoList() {
        return lottoDtoList;
    }

}

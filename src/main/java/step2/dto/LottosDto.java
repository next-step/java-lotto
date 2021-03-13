package step2.dto;

import step2.domain.Lottos;

import java.util.List;
import java.util.Objects;

public class LottosDto {

    private List<LottoDto> lottoDtoList;

    public LottosDto(Lottos lotto) {
        this.lottoDtoList = lotto.getLottoDtoList();
    }

    public List<LottoDto> getLottoDtoList() {
        return lottoDtoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottosDto lottosDto = (LottosDto) o;
        return Objects.equals(lottoDtoList, lottosDto.lottoDtoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoDtoList);
    }
}

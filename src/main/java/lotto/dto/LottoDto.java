package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class LottoDto {
    private final List<Integer> lottoDto;

    public LottoDto(List<Integer> lottoDto) {
        this.lottoDto = new ArrayList<>(lottoDto);
    }

    @Override
    public String toString() {
        return lottoDto.toString();
    }
}

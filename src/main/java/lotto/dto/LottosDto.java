package lotto.dto;


import java.util.List;

public class LottosDto {
    private final List<LottoNumbersDto> lottoNumbersDto;

    public LottosDto(List<LottoNumbersDto> lottoNumbersDto) {
        this.lottoNumbersDto = lottoNumbersDto;
    }

    public List<LottoNumbersDto> getLottoNumbersDto() {
        return lottoNumbersDto;
    }
}

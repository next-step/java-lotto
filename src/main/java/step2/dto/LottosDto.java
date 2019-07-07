package step2.dto;

import java.util.List;

public class LottosDto {
    private List<LottoDto> lottos;

    public LottosDto(List<LottoDto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoDto> getLottos() {
        return lottos;
    }

    public void setLottos(List<LottoDto> lottos) {
        this.lottos = lottos;
    }
}

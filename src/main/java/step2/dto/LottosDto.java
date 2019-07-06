package step2.dto;

import java.util.List;

public class LottosDTO {
    private List<LottoDTO> lottos;

    public LottosDTO(List<LottoDTO> lottos) {
        this.lottos = lottos;
    }

    public List<LottoDTO> getLottos() {
        return lottos;
    }

    public void setLottos(List<LottoDTO> lottos) {
        this.lottos = lottos;
    }
}

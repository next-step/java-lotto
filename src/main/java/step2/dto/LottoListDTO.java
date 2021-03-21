package step2.dto;

import java.util.ArrayList;
import java.util.List;

public class LottoListDTO {
    List<LottoDTO> lottoList;

    public LottoListDTO(List<LottoDTO> lottoList) {
        this.lottoList = lottoList;
    }

    public LottoListDTO(LottoDTO lotto) {
        this.lottoList = new ArrayList<>();
        this.lottoList.add(lotto);
    }

    public List<LottoDTO> getLottoList() {
        return lottoList;
    }
}

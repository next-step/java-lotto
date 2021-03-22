package step2.dto;

import step2.dto.LottoDTO.NormalLottoDTO;

import java.util.ArrayList;
import java.util.List;

public class LottoListDTO {
    List<NormalLottoDTO> lottoList;

    public LottoListDTO(List<NormalLottoDTO> lottoList) {
        this.lottoList = lottoList;
    }

    public LottoListDTO(NormalLottoDTO lotto) {
        this.lottoList = new ArrayList<>();
        this.lottoList.add(lotto);
    }

    public List<NormalLottoDTO> getLottoList() {
        return this.lottoList;
    }

    public int getLottoListCount() {
        return this.lottoList.size();
    }
}

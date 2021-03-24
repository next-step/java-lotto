package step2.dto;

import java.util.List;

public class LottoListDTO {
    private final List<String> lottoList;

    public LottoListDTO(List<String> lottoList) {
        this.lottoList = lottoList;
    }

    public List<String> getLottoList() {
        return this.lottoList;
    }

}

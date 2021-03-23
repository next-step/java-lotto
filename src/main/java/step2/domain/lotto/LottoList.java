package step2.domain.lotto;

import step2.dto.LottoListDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
    private final List<NormalLotto> lottoList;

    public LottoList(List<NormalLotto> lottoList) {
        this.lottoList = lottoList;
    }

    public LottoListDTO dto() {
        return new LottoListDTO(lottoList.stream()
                .map(NormalLotto::toString)
                .collect(Collectors.toList()));
    }
}

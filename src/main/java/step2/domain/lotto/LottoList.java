package step2.domain.lotto;

import step2.dto.LottoListDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
    private final List<NormalLotto> lottos;

    public LottoList(List<NormalLotto> lottoList) {
        this.lottos = lottoList;
    }

    public List<NormalLotto> getLottos() {
        return lottos;
    }

    public LottoListDTO dto() {
        return new LottoListDTO(lottos.stream()
                .map(NormalLotto::toString)
                .collect(Collectors.toList()));
    }
}

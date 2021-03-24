package step2.domain.lotto;

import step2.dto.LottoListDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoList {
    private final List<NormalLotto> lottos;

    public LottoList(ArrayList<String> rawLottoList){
        this(rawLottoList.stream()
                .map(NormalLotto::new)
                .collect(Collectors.toList()));
    }

    public LottoList(LottoList manualLottoList, LottoList autoLottoList) {
        this(Stream.concat(manualLottoList.getLottos().stream(), autoLottoList.getLottos().stream())
                .collect(Collectors.toList()));
    }

    public LottoList(List<NormalLotto> lottoList) {
        this.lottos = lottoList;
    }

    public List<NormalLotto> getLottos() {
        return lottos;
    }

    public int getLottoSize() {
        return lottos.size();
    }

    public LottoListDTO dto() {
        return new LottoListDTO(lottos.stream()
                .map(NormalLotto::toString)
                .collect(Collectors.toList()));
    }
}

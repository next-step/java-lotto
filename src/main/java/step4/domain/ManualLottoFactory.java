package step4.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoFactory {

    private final List<Lotto> lottos;

    public ManualLottoFactory(List<String> lottoStringList) {

        lottos = lottoStringList.stream()
                .map(LottoGenerator::separateLottoToList)
                .collect(Collectors.toList());
    }

    public void addList(List<Lotto> lottoList) {
        lottoList.addAll(lottos);
    }
}

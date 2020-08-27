package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public LottoResult getMatching(WinningLottoNumbers winningLottoNumbers) {
        Map<Integer, Long> map =
                lottoList
                .stream()
                .map(Lotto::getLottoNumbers)
                .map(winningLottoNumbers::matchCount)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new LottoResult(map);
    }


}

package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class LottoTicket {
    private List<LottoNumbers> lottoNumbersList;

    public LottoTicket(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }

    public Map<Integer, Long> getMatching(WinningLottoNumbers winningLottoNumbers) {
        return lottoNumbersList
                .stream()
                .map(LottoNumbers::getLottoNumbers)
                .map(winningLottoNumbers::getMatchingCount)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


}

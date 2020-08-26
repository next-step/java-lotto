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

    public LottoResult getMatching(WinningLottoNumbers winningLottoNumbers) {
        Map<Integer, Long> map =
                lottoNumbersList
                .stream()
                .map(LottoNumbers::getLottoNumbers)
                .map(winningLottoNumbers::getMatchingCount)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new LottoResult(map);
    }


}

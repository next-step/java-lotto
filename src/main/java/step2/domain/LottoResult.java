package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {
    private List<LottoNumber> lottoNumberList;
    private List<Integer> winningLottoNumbers;
    private Map<Integer, Long> lottoResult;

    public LottoResult(LottoTicket lottoTicket, WinningLotto winningLotto) {
        this.lottoNumberList = lottoTicket.getLottoNumberList();
        this.winningLottoNumbers = winningLotto.getWinningNumbers();
    }

    public Map<Integer, Long> getResultMap() {
        return this.lottoResult = lottoNumberList.stream()
                .map(LottoNumber::getLottoNumbers)
                .map(lottoNumbers -> getMatchingCount(lottoNumbers))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    private int getMatchingCount(List<Integer> lottoNumbers) {
        return (int)lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();

    }



}

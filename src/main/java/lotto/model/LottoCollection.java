package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoCollection {

    private final List<LottoNumbers> lottoNumbersList;

    public LottoCollection(int numberOfLottoTickets, RandomGenerator randomGenerator) {
        this.lottoNumbersList = Stream.generate(() -> new LottoNumbers(randomGenerator.generate()))
            .limit(numberOfLottoTickets)
            .collect(Collectors.toList());
    }

    public List<LottoNumbers> getLottoNumberList() {
        return this.lottoNumbersList;
    }

    public List<LottoRank> getLottoRanks(WinningNumbers winningNumbers) {
        return lottoNumbersList.stream()
            .map(lottoNumbers -> LottoRank.valueOf(lottoNumbers.matchCount(winningNumbers),
                lottoNumbers.matchBonusNumber(winningNumbers)))
            .collect(Collectors.toList());
    }

}

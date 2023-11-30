package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoCollection {

    private final List<LottoNumbers> lottoNumbers;

    public LottoCollection(int numberOfLottoTickets, RandomGenerator randomGenerator) {
        this.lottoNumbers = Stream.generate(() -> new LottoNumbers(randomGenerator.generate()))
            .limit(numberOfLottoTickets)
            .collect(Collectors.toList());
    }

    public List<LottoNumbers> getLottoNumberList() {
        return this.lottoNumbers;
    }

    public List<LottoRank> getLottoRanks(WinningNumbers winningNumbers) {
        return lottoNumbers.stream()
            .map(lottoNumbers -> LottoRank.rankByMatchCountAndBonusNumber(lottoNumbers,
                winningNumbers))
            .collect(Collectors.toList());
    }
}

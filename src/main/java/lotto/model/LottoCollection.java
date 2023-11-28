package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCollection {

    private final List<LottoNumbers> lottoNumbersList;

    public LottoCollection(int numberOfLottoTickets, RandomGenerator randomGenerator) {
        this.lottoNumbersList = new ArrayList<>();
        IntStream.range(0, numberOfLottoTickets)
            .mapToObj(e -> new LottoNumbers(randomGenerator.generate()))
            .forEach(this.lottoNumbersList::add);
    }

    public List<LottoNumbers> getLottoNumberList() {
        return this.lottoNumbersList;
    }

    public List<LottoRank> getLottoRanks(WinningNumbers winningNumbers) {
        return lottoNumbersList.stream()
            .map(lottoNumbers -> LottoRank.valueOf(
                lottoNumbers.getLottoNumbers()
                    .stream()
                    .filter(winningNumbers::contains)
                    .count()
                , lottoNumbers.getLottoNumbers()
                    .stream()
                    .filter(winningNumbers::matchBonusNumber)
                    .count()))
            .collect(Collectors.toList());
    }

}

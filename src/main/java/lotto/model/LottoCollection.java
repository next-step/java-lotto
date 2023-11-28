package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoCollection {

    private final ArrayList<LottoNumbers> lottoNumbersList;

    public LottoCollection(int numberOfLottoTickets, RandomGenerator randomGenerator) {
        this.lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < numberOfLottoTickets; i++) {
            this.lottoNumbersList.add(new LottoNumbers(randomGenerator.generate()));
        }
    }

    public List<LottoNumbers> getLottoNumberList() {
        return this.lottoNumbersList;
    }

    public List<LottoRank> getLottoRanks(LottoNumbers winningNumbers) {
        return lottoNumbersList.stream()
            .map(lottoNumbers -> LottoRank.getRank(
                lottoNumbers.getLottoNumbers()
                    .stream()
                    .filter(winningNumbers::contains)
                    .count())).collect(Collectors.toList()
            );
    }

}

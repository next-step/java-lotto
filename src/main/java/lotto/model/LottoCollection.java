package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<LottoRank> lottoRanks(LottoNumbers winningNumbers) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            lottoRanks.add(lottoRank(lottoNumbers
                .getLottoNumbers()
                .stream()
                .filter(winningNumbers.getLottoNumbers()::contains)
                .count()));
        }
        return lottoRanks;
    }

    private LottoRank lottoRank(long rank) {
        return Arrays.stream(LottoRank.values())
            .filter(lottoRank -> lottoRank.rank() == rank)
            .findAny()
            .orElse(LottoRank.BLANK);
    }

}

package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SbsHappyDreamLottoLive {
    private final WinnerNumber winnerNumbers;
    private final List<LottoRank> lottoRanks;
    private final LottoMachine lottoMachine;

    public SbsHappyDreamLottoLive(String winnerNumbers, LottoMachine lottoMachine) {
        this.winnerNumbers = new WinnerNumber(winnerNumbers);
        this.lottoMachine = lottoMachine;
        this.lottoRanks = createLottoRanks();
    }

    private List<LottoRank> createLottoRanks() {
        List<LottoRank> result = new ArrayList<>();

        Arrays.stream(Rank.values())
                .forEach(r -> result.add(addLottoRank(r)));

        return result;
    }

    private LottoRank addLottoRank(Rank rank) {
        return new LottoRank(rank, lottoMachine, winnerNumbers);
    }

    public List<LottoRank> getReadOnlyLottoRanks() {
        return Collections.unmodifiableList(lottoRanks);
    }
}

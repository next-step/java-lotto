package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SbsHappyDreamLottoLive {
    private final WinnerNumber winnerNumbers;
    private final List<LottoRank> lottoLottoRanks;

    public SbsHappyDreamLottoLive(String winnerNumbers, LottoMachine lottoMachine) {
        this.winnerNumbers = new WinnerNumber(winnerNumbers);
        this.lottoLottoRanks = createLottoRanks(lottoMachine);
    }

    private List<LottoRank> createLottoRanks(LottoMachine lottoMachine) {
        return Arrays.stream(LottoRank.values())
                .map(lottoRank -> lottoRank.rank(lottoMachine, winnerNumbers))
                .collect(Collectors.toList());
    }

    public List<LottoRank> readOnlyLottoRanks() {
        return Collections.unmodifiableList(lottoLottoRanks);
    }
}

package domain.lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinnginLottoLine extends LottoLine {


    public WinnginLottoLine(Set<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public LottoStatistics match(List<LottoLine> lottoLines, LottoNumber bonusBall) {
        LottoStatistics lottoStatistics = new LottoStatistics();

        lottoLines.forEach(lottoLine -> {
            Set<LottoNumber> winningLottoNumbers = getWinningLottoNumbers(bonusBall);

            winningLottoNumbers.retainAll(lottoLine.getLottoNumbers());
            int matchCount = winningLottoNumbers.size();
            boolean matchBonusBall = lottoLine.getLottoNumbers().contains(bonusBall);

            lottoStatistics.calculate(matchCount, matchBonusBall);
        });

        return lottoStatistics;
    }

    private Set<LottoNumber> getWinningLottoNumbers(LottoNumber bonusBall) {
        Set<LottoNumber> winningLottoNumbers = new HashSet<>(this.getLottoNumbers());
        winningLottoNumbers.add(bonusBall);

        return winningLottoNumbers;
    }
}

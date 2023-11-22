package domain.lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinnginLottoLine extends LottoLine {


    public WinnginLottoLine(Set<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public LottoStatistics match(List<LottoLine> lottoLines) {
        LottoStatistics lottoStatistics = new LottoStatistics();

        lottoLines.forEach(lottoLine -> {
            Set<LottoNumber> winningLottoNumbers = new HashSet<>(this.getLottoNumbers());
            winningLottoNumbers.retainAll(lottoLine.getLottoNumbers());
            int matchCount = winningLottoNumbers.size();
            lottoStatistics.calculate(matchCount);
        });

        return lottoStatistics;
    }
}

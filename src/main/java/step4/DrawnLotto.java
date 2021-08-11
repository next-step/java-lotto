package step4;

import step4.enums.DrawResult;

import java.util.List;

public class DrawnLotto {
    private final LottoEntry lottoEntry;
    private final LottoNumber bonusNumber;

    public DrawnLotto(List<Integer> numbers, int bonusNumber) {
        this.lottoEntry = new LottoEntry(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public DrawResult getDrawResult(LottoEntry lottoEntry) {
        int match = this.lottoEntry.countMatches(lottoEntry);
        boolean bonus = bonus(lottoEntry);

        return DrawResult.fromMatch(match, bonus).orElse(DrawResult.NONE_MATCH);
    }

    public Boolean bonus(LottoEntry lottoEntry) {
        return lottoEntry.contains(bonusNumber);
    }
}

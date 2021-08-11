package step4;

import step4.enums.DrawResult;

import java.util.List;

public class DrawnLotto {
    private final LottoEntry lottoEntry;
    private final int bonusNumber;

    public DrawnLotto(List<Integer> numbers, int bonusNumber) {
        this.lottoEntry = new LottoEntry(numbers);
        this.bonusNumber = bonusNumber;
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

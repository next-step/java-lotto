package step3;

import java.util.List;

public class DrawnLotto extends LottoEntry {
    private final int bonusNumber;

    public DrawnLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);

        this.bonusNumber = bonusNumber;
    }

    public Boolean bonus(LottoEntry lottoEntry) {
        return lottoEntry.contains(this.bonusNumber);
    }
}

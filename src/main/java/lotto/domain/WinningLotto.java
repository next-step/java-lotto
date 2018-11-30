package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final String DELIMETER = ", ";
    private List<LottoNo> winNumber;
    private LottoNo bonusNumber;

    public WinningLotto(String winningString, int bonusNumber) {
        String[] nums = null;

        nums = winningString.split(DELIMETER);

        this.winNumber = new ArrayList();
        this.bonusNumber = LottoNo.of(bonusNumber);

        for (String num : nums) {
            this.winNumber.add(LottoNo.of(num));
        }
    }

    public boolean isExistBonusBall(Lotto lotto) {
        return lotto.isContains(this.bonusNumber);
    }

    public int matchingCount(Lotto lotto) {
        int result = 0;
        for (LottoNo winNum : this.winNumber) {
            if (lotto.isContains(winNum)) {
                result++;
            }

        }
        return result;
    }
}

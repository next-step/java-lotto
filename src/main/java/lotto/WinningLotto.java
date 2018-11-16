package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final String DELIMETER = ", ";
    private List<LottoNo> winNumber;
    private LottoNo bonusNumber;

    public WinningLotto(String winningString, LottoNo bonusNumber) {
        String[] nums = null;

        nums = winningString.split(DELIMETER);

        this.winNumber = new ArrayList();
        this.bonusNumber = bonusNumber;

        for (String num : nums) {
            this.winNumber.add(new LottoNo(Integer.parseInt(num)));
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

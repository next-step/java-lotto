package lotto.lotto;

import lotto.system.Const;

import java.util.HashSet;
import java.util.Set;

public class LottoWinning {

    private final Set<LottoNumber> winningLotto;

    public LottoWinning(String winLotto) {
        this.winningLotto = new HashSet<>();
        addWinNumber(winLotto);
    }

    private void addWinNumber(String str) {
        String[] nums = str.split(Const.DELIMITER);

        if (isMany(nums)) {
            throw new IllegalArgumentException("로또 당첨 번호는" +  Const.LOTTO_CNT + "개 입니다.");
        }

        for (String num : nums) {
            winningLotto.add(LottoNumber.from(num));
        }
    }

    public Set<LottoNumber> getWinningLotto() {
        return winningLotto;
    }

    public boolean isMany(String[] nums){
        return nums.length > Const.LOTTO_CNT;
    }
}

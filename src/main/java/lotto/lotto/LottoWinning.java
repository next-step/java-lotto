package lotto.lotto;

import lotto.system.Const;

import java.util.HashSet;
import java.util.Set;

public class LottoWinning {

    private final Set<LottoNumber> winningLotto;
    private final int bonusNumber;

    public LottoWinning(String winLotto, int bonusNumber) {
        this.winningLotto = new HashSet<>();
        addWinNumber(winLotto);
        duplicateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void duplicateBonusNumber(int bonusNumber) {
        if(winningLotto.stream().anyMatch(winningNumber ->  bonusNumber == winningNumber.getNumber())) {
            throw new IllegalArgumentException("보너스볼은 당첨번호에 포함될 수 없습니다.");
        }
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

    public int getBonusNumber(){
        return bonusNumber;
    }

    public int matchCount(Lotto lotto) {
        return lotto.calculateMatchingCnt(this);
    }

}

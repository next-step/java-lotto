package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final String DELIMETER = ", ";
    private List<Integer> winNumber;
    private int bonusNumber;

    public WinningLotto(String winningString, int bonusNumber){
        String[] nums = winningString.split(DELIMETER);

        this.winNumber = new ArrayList();
        this.bonusNumber = bonusNumber;

        for (String num : nums) {
            this.winNumber.add(Integer.parseInt(num));
        }
    }

    public boolean isExistBonusBall(Lotto lotto){
        return lotto.isContains(this.bonusNumber);
    }

    public int matchingCount(Lotto lotto){
        int result=0;
        for(Integer winNum : this.winNumber){
            if(lotto.isContains(winNum)){
                result++;
            }

        }
        return result;
    }
}

package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final String DELIMETER = ", ";
    private List<Integer> winNumber;

    public WinningLotto(String winningString){
        String[] nums = winningString.split(DELIMETER);

        this.winNumber = new ArrayList();
        for (String num : nums) {
            this.winNumber.add(Integer.parseInt(num));
        }
    }

    public List<Integer> getNumber(){
        return this.winNumber;
    }

}

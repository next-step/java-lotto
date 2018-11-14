package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoCompare {
    private static final String DELIMETER = ", ";
    private List<Integer> winNumber;


    public LottoCompare(String winNumber) {
        String[] nums = winNumber.split(DELIMETER);

        this.winNumber = new ArrayList();
        for (String num : nums) {
            this.winNumber.add(Integer.parseInt(num));
        }
    }

    public int compareNumber(List<Integer> lotto) {
        int count = 0;
        for (int num : this.winNumber) {
            if (lotto.contains(num)) {
                count++;
            }
        }
        return count;
    }

    public LottoResult match(List<Lotto> lotteries){
        LottoResult result = new LottoResult();
        for(Lotto oneTicket : lotteries){
            result.addCountToResult(compareNumber(oneTicket.getNumber()));
        }
        return result;
    }

}

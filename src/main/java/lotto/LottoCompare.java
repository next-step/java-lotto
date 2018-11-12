package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoCompare {
    private List<Integer> winNumber;

    public LottoCompare(String winNumber){
        String[] nums = winNumber.split(", ");
        this.winNumber = new ArrayList();


        for(String num: nums) {
            this.winNumber.add(Integer.parseInt(num));
        }
    }

    public int CompareNumber(List<Integer> lotteries){
        int count=0;
        for(int num : this.winNumber){
            if(lotteries.contains(num)){
                count++;
            }
        }
        return count;
    }




}

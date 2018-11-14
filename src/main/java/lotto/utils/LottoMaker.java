package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;

public class LottoMaker {

    public static final int NUM_OF_CARDS = 45;
    public static final int NUM_OF_NUMBERS = 6;

    public static List<Integer> getOnetoFortyFive() {
        List<Integer> nums = new ArrayList<>();
        for( int i = 1 ; i <= NUM_OF_CARDS ; i ++ ){
            nums.add(i);
        }
        return nums;
    }

    public static List<Integer> getSixNumsAfterShuffle(List<Integer> nums) {
        Collections.shuffle(nums);
        return nums.subList(0,NUM_OF_NUMBERS);
    }
}

package lotto.model;

import java.util.List;

public class WinningStatistic {

    public static int getEqualCount(List<Integer> source, List<Integer> target) {
        int count = 0;

        for (Integer sourceElement : source){
            if(target.contains(sourceElement)){
                count++;
            }
        }

        return count;
    }
}

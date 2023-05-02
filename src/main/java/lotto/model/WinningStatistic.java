package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningStatistic {

    public static int getEqualCount(List<Integer> source, List<Integer> target) {

        List<Integer> tempSource = new ArrayList<>(source);
        List<Integer> tempTarget = new ArrayList<>(target);

        tempSource.removeAll(tempTarget);

        return source.size() - tempSource.size();
    }
}

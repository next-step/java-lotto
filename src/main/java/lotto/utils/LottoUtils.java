package lotto.utils;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoUtils {

    private LottoUtils() {}

    public static List<Lotto> mergeTwoLottoLists(List<Lotto> list1, List<Lotto> list2) {
        List<Lotto> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        return mergedList;
    }

}

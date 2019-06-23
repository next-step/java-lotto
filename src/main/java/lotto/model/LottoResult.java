package lotto.model;

import lotto.model.Prize;

import java.util.*;

public class LottoResult {

    public static Map<Prize, Integer> of(List<Prize> prizes) {
        Map<Prize, Integer> resultMap = new HashMap<>();
        for (Prize prize : prizes) {
            int count = resultMap.getOrDefault(prize, 0);
            resultMap.put(prize, ++count);
        }
        return resultMap;
    }

}

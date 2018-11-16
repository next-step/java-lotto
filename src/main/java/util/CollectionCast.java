package util;

import domain.LottoNo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionCast {
    public static Map<Integer, LottoNo> changeListToMap(List<LottoNo> numbers) {
        Map<Integer, LottoNo> lottoNos = new HashMap<>();
        for (int i = 0; i < numbers.size() ; i++) {
            lottoNos.put(i, numbers.get(i));
        }
        return lottoNos;
    }
}

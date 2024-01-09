package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllLottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final int LOTTO_NUMBERS_LENGTH = 6;

    private static final Map<Integer, LottoNumber> allLottoNumberMap;

    private static final List<LottoNumber> allLottoNumberList;

    static {
        allLottoNumberMap = initializeAllLottoNumberMap();
        allLottoNumberList = new ArrayList<>(allLottoNumberMap.values());
    }

    private static Map<Integer, LottoNumber> initializeAllLottoNumberMap() {
        Map<Integer, LottoNumber> allLottoNumber = new HashMap<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            allLottoNumber.put(i, LottoNumber.lottoNumberFactory(i));
        }
        return allLottoNumber;
    }

    public static Lotto randomLottoNumber() {
        Collections.shuffle(allLottoNumberList);
        return new Lotto(allLottoNumberList.stream().limit(LOTTO_NUMBERS_LENGTH).collect(Collectors.toSet()));
    }

    public static LottoNumber getLottoNumber(int lottoNumber) {
        return allLottoNumberMap.get(lottoNumber);
    }

}

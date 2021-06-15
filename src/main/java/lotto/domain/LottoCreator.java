package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCreator {
    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

    public static final int FIRST_NUMBERS = 1;
    public static final int LAST_NUMBERS = 45;

    static {
        for (int i = FIRST_NUMBERS; i < LAST_NUMBERS; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public void buyLotto(int num, List<Integer> lottoNumbers) {
    }


//    public List<Integer> chooseLottoNumbers() {
//        Collections.shuffle(lottoNumbers);
//        Lotto.lottoNumber(lottoNumbers);
//        return lottoNumberList;
//    }

//    public List<Integer> sortLottoNumbers() {
//        Collections.sort(chooseLottoNumbers());
//        return lottoNumberList;
//    }
}

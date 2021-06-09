package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCreator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private List<Integer> lottoNumbers;
    private static final int LOTTO_COUNT = 6;

    public void makeLottoNumbers() {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }

    public void shuffleLottoNumbers() {
        makeLottoNumbers();
        Collections.shuffle(lottoNumbers);
    }


    private void sortLottoNumbers() {
        Collections.sort(lottoNumbers);
    }

//    public List<Integer> chooseLottoNumbers() {
//        Collections.shuffle(lottoNumbers);
//        Lotto.lottoNumber(lottoNumbers);
//        return lottoNumberList;
//    }
//
//    public List<Integer> sortLottoNumbers() {
//        Collections.sort(chooseLottoNumbers());
//        return lottoNumberList;
//    }
}

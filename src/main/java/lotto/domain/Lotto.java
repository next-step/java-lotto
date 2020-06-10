package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static int LOTTO_MAX_NUMBER= 60;
    private static int LOTTO_MIN_NUMBER = 1;
    private static int NEED_LOTTO_COUNT= 6;

    private List<Integer> selectedLottoNumber = new ArrayList<>();

    public void makeLottoNumber() {

        List<Integer> lottoGameNumber = IntStream.rangeClosed(LOTTO_MIN_NUMBER,LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoGameNumber);
        this.selectedLottoNumber = lottoGameNumber.stream().limit(NEED_LOTTO_COUNT).collect(Collectors.toList());
    }

    public List getLottoNumber(){
        return this.selectedLottoNumber;
    }
}

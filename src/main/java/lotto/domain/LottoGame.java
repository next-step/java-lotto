package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    private final List<Integer> NUMBER_OF_LOTTO_VALUE = IntStream.rangeClosed(1, 45)
                                                                    .boxed()
                                                                    .collect(Collectors.toList());

    private List<Integer> lottoNumber;

    public LottoGame() {
        createLottoGame();
    }

    private void createLottoGame() {

        this.lottoNumber =  sortNumber(shuffleNumber(NUMBER_OF_LOTTO_VALUE).subList(0, 6));
    }

    private List<Integer> shuffleNumber(List<Integer> numberList) {
        Collections.shuffle(numberList);

        return numberList;
    }

    private List<Integer> sortNumber(List<Integer> numberList) {
        Collections.sort(numberList);

        return numberList;
    }

    public List<Integer> getLottoNumber() {
        return this.lottoNumber;
    }
}

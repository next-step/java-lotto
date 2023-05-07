package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoGame {

    private List<Integer> lottoNumber;

    public LottoGame(List<Integer> lottoNumberList) {
        createLottoGame(lottoNumberList);
    }

    private void createLottoGame(List<Integer> lottoNumberList) {
        this.lottoNumber =  sortNumber(shuffleNumber(lottoNumberList).subList(0, 6));
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

    public int matchLottoNumberCount(List<Integer> lottoResultNumbers) {
        return (int) lottoResultNumbers.stream()
                .filter(this.lottoNumber::contains)
                .count();
    }
}

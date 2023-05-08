package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_BASIC_MAX_SIZE = 6;

    private List<Integer> lottoNumber;

    public LottoGame(List<Integer> lottoNumberList) {
        createLottoGame(new ArrayList<>(lottoNumberList));
    }

    private void createLottoGame(List<Integer> lottoNumberList) {
        validateNumberList(lottoNumberList);

        this.lottoNumber =  sortNumber(shuffleNumber(lottoNumberList).subList(0, 6));
    }

    private void validateNumberList(List<Integer> numberList) {
        isListSizeOfSix(numberList);
        isListInSameNumber(numberList);
    }

    private void isListSizeOfSix(List<Integer> numberList) {
        if(numberList.size() < LOTTO_BASIC_MAX_SIZE) {
            throw new IllegalArgumentException("번호 리스트 크기가 올바르지 않습니다. 입력값 : " + numberList);
        }
    }

    private void isListInSameNumber(List<Integer> numberList) {
        if(numberList.size() != numberList.stream().distinct().count()) {
            throw new IllegalArgumentException("번호 리스트 중 중복된 값이 있습니다. 입력값 : " + numberList);
        }
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
        return Collections.unmodifiableList(this.lottoNumber);
    }

    public int matchLottoNumberCount(List<Integer> lottoResultNumbers) {
        return (int) lottoResultNumbers.stream()
                .filter(this.lottoNumber::contains)
                .count();
    }
}

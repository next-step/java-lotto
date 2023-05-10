package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int LIST_MAX_SIZE = 6;

    private List<Integer> lottoNumber;

    public LottoTicket(List<Integer> lottoNumberList) {
        validateListSize(lottoNumberList);
        validateDuplicate(lottoNumberList);
        this.lottoNumber = new ArrayList<>(lottoNumberList);
    }

    private void validateListSize(List<Integer> numberList) {
        if(numberList.size() < LIST_MAX_SIZE) {
            throw new IllegalArgumentException("번호 리스트 크기가 올바르지 않습니다. 입력값 : " + numberList);
        }
    }

    private void validateDuplicate(List<Integer> numberList) {
        if(numberList.size() != numberList.stream().distinct().count()) {
            throw new IllegalArgumentException("번호 리스트 중 중복된 값이 있습니다. 입력값 : " + numberList);
        }
    }

    public List<Integer> getLottoNumber() {
        return Collections.unmodifiableList(this.lottoNumber);
    }

    public int matchLottoNumberCount(List<Integer> lottoResultNumbers) {
        return (int) lottoResultNumbers.stream()
                .filter(this.lottoNumber::contains)
                .count();
    }

    public Boolean hasBonusBall(int bonusNum) {
        return this.lottoNumber.contains(bonusNum);
    }
}

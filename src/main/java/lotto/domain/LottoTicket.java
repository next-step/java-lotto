package lotto.domain;

import lotto.util.LottoConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateListSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    private void validateListSize(List<LottoNumber> numberList) {
        if(numberList.size() > LottoConstants.LOTTO_MAX_SIZE) {
            throw new IllegalArgumentException("번호 리스트 크기가 올바르지 않습니다. 입력값 : " + numberList);
        }
    }

    private void validateDuplicate(List<LottoNumber> numberList) {
        if(numberList.size() != numberList.stream().distinct().count()) {
            throw new IllegalArgumentException("번호 리스트 중 중복된 값이 있습니다. 입력값 : " + numberList);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(this.lottoNumbers);
    }

    public int matchLottoNumberCount(List<LottoNumber> lottoResultNumbers) {
        return (int) lottoResultNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    public Boolean hasBonusBall(LottoNumber bonusNum) {
        return this.lottoNumbers.contains(bonusNum);
    }
}

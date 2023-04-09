package lotto;

import exception.LottoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> numbers) {
        this.lottoNumbers = numbers;
        LottoException.validate(this);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public String printLottoNumber() {
        List<Integer> lottoNumberList = new ArrayList<>();
        lottoNumbers.forEach(i ->
                        lottoNumberList.add(i.getNumber())
                );
        Collections.sort(lottoNumberList);
        return lottoNumberList.toString();
    }

    public boolean hasDuplication() {
        return lottoNumbers.stream().distinct().count() != lottoNumbers.size();
    }

    public int getSize() {
        return lottoNumbers.size();
    }

    public boolean hasNumber(int number) {
        return lottoNumbers.contains(LottoNumber.of(number));
    }
}



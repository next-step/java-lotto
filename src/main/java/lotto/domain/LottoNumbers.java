package lotto.domain;

import lotto.domain.wrapper.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers() { }

    public LottoNumbers(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            this.lottoNumbers.add(LottoNumber.of(number));
        }
    }

    public boolean sizeIsNotSameWith(int lottoNumberCount) {
        return lottoNumbers.size() != lottoNumberCount;
    }

    public void add(Integer number) {
        lottoNumbers.add(LottoNumber.of(number));
    }

    public int get(int index) {
        return lottoNumbers.get(index).number();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < lottoNumbers.size(); ++i) {
            sb.append(lottoNumbers.get(i) + ", ");
        }
        sb.replace(sb.length()-2, sb.length()-1, "]");

        return sb.toString();
    }

    public String formattedString() {
        return lottoNumbers.toString();
    }
  
    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }
}

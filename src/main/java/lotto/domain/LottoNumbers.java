package lotto.domain;

import lotto.domain.wrapper.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers() { }

    public LottoNumbers(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            this.lottoNumbers.add(LottoNumber.of(number));
        }
    }

    public LottoNumbers(String[] lottoNumbers) {
        for (String number : lottoNumbers) {
            this.lottoNumbers.add(LottoNumber.of(Integer.parseInt(number)));
        }
    }

    private void sort() {
        Collections.sort(this.lottoNumbers);
    }

    public boolean sizeIsNotSameWith(int lottoNumberCount) {
        return lottoNumbers.size() != lottoNumberCount;
    }

    public void add(Integer number) {
        lottoNumbers.add(LottoNumber.of(number));
    }

    @Override
    public String toString() {
        sort();

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < lottoNumbers.size(); ++i) {
            sb.append(lottoNumbers.get(i) + ", ");
        }
        sb.replace(sb.length()-2, sb.length()-1, "]");

        return sb.toString();
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }
}

package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    List<Integer> lottoNumbers;

    public LottoNumbers() {
        this(new ArrayList<>());
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean sizeIsNotSameWith(int lottoNumberCount) {
        return lottoNumbers.size() != lottoNumberCount;
    }

    public void add(Integer number) {
        lottoNumbers.add(number);
    }

    public int get(int index) {
        return lottoNumbers.get(index);
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
}

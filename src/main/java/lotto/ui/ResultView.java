package lotto.ui;

import lotto.domain.LottoNumber;

import java.util.Comparator;
import java.util.List;

public class ResultView {
    public static void printLotto(List<LottoNumber> lottoNumbers) {
        lottoNumbers.sort(Comparator.naturalOrder());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (LottoNumber lottoNumber : lottoNumbers) {
            stringBuilder.append(lottoNumber.getNumber());
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }
}

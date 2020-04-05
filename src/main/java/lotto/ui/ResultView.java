package lotto.ui;

import lotto.domain.LottoNumber;

import java.math.BigDecimal;
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

    public static void printYield(BigDecimal yield) {
        System.out.println(String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)",
                yield.toPlainString()));
    }
}

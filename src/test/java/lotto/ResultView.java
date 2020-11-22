package lotto;

import java.util.List;

public class ResultView {

    public static void printLottoNumbers(List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getValue().toString());
        }
    }
}

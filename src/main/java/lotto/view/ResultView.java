package lotto.view;

import lotto.domain.LottoNumber;

import java.util.List;

public class ResultView {

    public void lottoNumberView(List<LottoNumber> lottos) {
        for (LottoNumber lottoNumber : lottos) {
            System.out.println(lottoNumber.getLotto());
        }
    }

}

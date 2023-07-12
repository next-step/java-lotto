package edu.nextstep.camp.lotto.domain;

import edu.nextstep.camp.lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class CustomLottoFactory implements LottoFactory {
    @Override
    public Lotto createLottoNumbers() {
        String[] lotto = InputView.input().split(",");

        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (String lottoNumStr : lotto) {
            lottoNumbers.add(new LottoNumber(lottoNumStr));
        }

        return new Lotto(lottoNumbers);
    }
}

package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.Lotto;
import domain.LottoNumber;

public class RandomLottoGenerator {

    public Lotto createRandomLotto() {

        LottoNumber lottoNumber = new LottoNumber();

        Collections.shuffle(lottoNumber.getLottoNumbers());
        List<Integer> pickedNumbers = lottoNumber.getLottoNumbers().subList(0, 6);
        Collections.sort(pickedNumbers);
        return Lotto.from(pickedNumbers);

    }
}

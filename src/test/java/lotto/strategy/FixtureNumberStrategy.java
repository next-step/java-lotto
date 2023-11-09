package lotto.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public class FixtureNumberStrategy implements NumberStrategy {

    int number = 0;

    @Override
    public List<Lotto> create(int count) {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(10),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(40),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        return List.of(new Lotto(lottoNumbers));
    }
}

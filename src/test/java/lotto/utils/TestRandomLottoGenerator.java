package lotto.utils;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Ticket;

import java.util.Arrays;
import java.util.List;

public class TestRandomLottoGenerator implements LottoGenerator {

    @Override
    public BasicLotto generate() {
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        );
        return new BasicLotto(new Ticket(numbers));
    }

    @Override
    public BasicLotto generate(Ticket ticket) {
        return new BasicLotto(new Ticket());
    }
}

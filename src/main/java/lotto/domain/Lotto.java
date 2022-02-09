package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.LottoNumber;

public class Lotto {

    private final int LOTTO_COUNT = 6;
    private final LottoNumber lottoNumber = new LottoNumber();
    private List<Integer> number;

    public Lotto() {

    }

    public Lotto(List<Integer> number) {
        this.number = number;
    }

    public Lotto getLottoTicket() {
        List<Integer> randoms;

        number = lottoNumber.getLottoNumbers();

        Collections.shuffle(number);

        randoms = number.stream().limit(LOTTO_COUNT)
            .collect(Collectors.toList());

        Collections.sort(randoms);

        return new Lotto(randoms);
    }

    public List<Integer> getLotto() {
        return number;
    }
}

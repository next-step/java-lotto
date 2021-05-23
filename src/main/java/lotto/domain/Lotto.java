package lotto.domain;

import lotto.domain.wrapper.LottoNumber;

import java.util.*;

import static lotto.domain.LottoGameOptions.*;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this(new LottoNumbers(numbers));
    }

    public Lotto(String lottoString) {
        this(new LottoNumbers(lottoString.split(", |,")));
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;

        if (this.lottoNumbers.sizeIsNotSameWith(LOTTO_NUMBER_COUNT)) {
            throw new IllegalArgumentException("로또를 구성하는 로또 번호들의 개수가 적합하지 않습니다.");
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public List<LottoNumber> numbers() {
        return lottoNumbers.lottoNumbers();
    }
}

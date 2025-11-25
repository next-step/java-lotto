package lotto;

import java.util.List;

public class Lotto {
    private List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int matchedCount(Lotto lotto) {
        int cnt = 0;
        for(int i = 0; i < lotto.numbers.size(); i++) {
            cnt += containsNumber(lotto.numbers.get(i));
        }
        return cnt;
    }
    private int containsNumber(LottoNumber number) {
        return this.numbers.contains(number) ? 1 : 0;
    }
    public List<LottoNumber> value() {
        return this.numbers;
    }
}

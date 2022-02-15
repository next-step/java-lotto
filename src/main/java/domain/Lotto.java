package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lotto;
    public static final int LOTTO_COUNT = 6;
    private static final String MESSAGE_LOTTO_NUMBER_COUNT_OVER = "(ERROR) 로또 숫자는 6개로 이뤄져야합니다.";
    private static final String MESSAGE_LOTTO_NUMBER_DUPLICATED = "(ERROR) 로또 숫자는 중복되면 안됩니다.";

    public Lotto() {
        this(LottoGenerator.create());
    }

    private Lotto(List<LottoNumber> lotto) {
        verifyCount(lotto);
        verifyDuplicate(lotto);
        verifyRange(lotto);
        Collections.sort(lotto);
        this.lotto = lotto;
    }

    public static Lotto create(List<LottoNumber> lotto) {
        return new Lotto(lotto);
    }

    public List<LottoNumber> getLotto() {
        return Collections.unmodifiableList(lotto);
    }

    public int countMatch(Lotto answer) {
        return (int) lotto
                .stream()
                .filter(answer.lotto::contains)
                .count();
    }

    public boolean checkBonus(LottoNumber bonus) {
        return lotto.contains(bonus);
    }


    // verify
    private void verifyCount(List<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(MESSAGE_LOTTO_NUMBER_COUNT_OVER);
        }
    }

    private void verifyDuplicate(List<LottoNumber> lotto) {
        if (lotto.stream().distinct().count() != LOTTO_COUNT) {
            throw new IllegalArgumentException(MESSAGE_LOTTO_NUMBER_DUPLICATED);
        }
    }

    private void verifyRange(List<LottoNumber> lotto) {
        lotto.forEach(lottoNumber -> lottoNumber.verify(lottoNumber));
    }
}

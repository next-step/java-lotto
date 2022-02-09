package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> lotto;
    private static final String MESSAGE_LOTTO_NUMBER_COUNT_OVER = "(ERROR) 로또 숫자는 6개로 이뤄져야합니다.";
    private static final String MESSAGE_LOTTO_NUMBER_DUPLICATED = "(ERROR) 로또 숫자는 중복되면 안됩니다.";
    private static final String MESSAGE_LOTTO_NUMBER_RANGE_OVER = "(ERROR) 로또 숫자의 범위를 벗어났습니다.";

    public Lotto() {
        this(new LottoAutoGenerator());
    }

    public Lotto(LottoGenerator lottoGenerator) {
        this(lottoGenerator.generateLottoNumber());
    }

    private Lotto(List<Integer> lotto) {
        verifyCount(lotto);
        verifyDuplicate(lotto);
        verifyRange(lotto);
        Collections.sort(lotto);
        this.lotto = lotto;
    }

    public static Lotto create(List<Integer> lotto) {
        return new Lotto(lotto);
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lotto);
    }

    public int countMatch(List<Integer> answerNumbers) {
        return (int) lotto.stream()
                .filter(answerNumbers::contains)
                .count();
    }

    public boolean checkBonus(int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    private void verifyCount(List<Integer> lotto) {
        if (lotto.size() != LottoGenerator.COUNT_LOTTO_NUMBER) {
            throw new IllegalArgumentException(MESSAGE_LOTTO_NUMBER_COUNT_OVER);
        }
    }

    private void verifyDuplicate(List<Integer> lotto) {
        if (lotto.stream().distinct().count() != LottoGenerator.COUNT_LOTTO_NUMBER) {
            throw new IllegalArgumentException(MESSAGE_LOTTO_NUMBER_DUPLICATED);
        }
    }

    private void verifyRange(List<Integer> lotto) {
        if (!lotto.stream().noneMatch(number -> number > LottoGenerator.END_LOTTO_NUMBER
                || number < LottoGenerator.START_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(MESSAGE_LOTTO_NUMBER_RANGE_OVER);
        }
    }

}

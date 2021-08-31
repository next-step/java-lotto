package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final String EXCEP_INVALID_NUM = "로또 번호로 유효하지 않습니다.";
    private final List<LottoNumber> lotto;

    public Lotto(List<Integer> lottoNums) {
        List<LottoNumber> lottoNumbers = toLottoNumberList(lottoNums);
        checkValidLotto(lottoNumbers);
        this.lotto = lottoNumbers;
    }

    public static List<LottoNumber> toLottoNumberList(List<Integer> lottoNums) {
        List<LottoNumber> lottoNumbers = new ArrayList<>(lottoNums.size());

        for (int i = 0; i < lottoNums.size(); i++) {
             lottoNumbers.add(LottoNumber.of(lottoNums.get(i)));
        }

        return lottoNumbers;
    }

    private void checkValidLotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LottoMachine.NUMS_PER_LOTTO) {
            throwExceptionInvalidLotto();
        }
        checkDuplicateNum(lottoNumbers);
    }

    void checkDuplicateNum(List<LottoNumber> lottoNums) {
        if (lottoNums.size() != lottoNums.stream().distinct().count()) {
            throwExceptionInvalidLotto();
        }
    }

    void throwExceptionInvalidLotto() {
        throw new IllegalArgumentException(EXCEP_INVALID_NUM);
    }

    public List<LottoNumber> getLottoNumberList() {
        return lotto;
    }

    int countMatchingNums(Lotto winningNums) {
        int count = 0;

        for (LottoNumber number : lotto) {
            count += winningNums.contains(number) ? 1 : 0;
        }

        return count;
    }

    boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public boolean isMatchingBonus(LottoNumber bonusNumber) {
        return lotto.stream().anyMatch(i -> i.equals(bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}

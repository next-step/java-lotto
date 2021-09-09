package lotto.domain;

import java.util.*;

public class Lotto {
    private static final String EXCEP_INVALID_NUM = "로또 번호로 유효하지 않습니다.";
    private final Set<LottoNumber> lotto;

    public Lotto(List<Integer> lottoNumbers) {
        this(toLottoNumberSet(lottoNumbers));
    }

    public Lotto(Set<LottoNumber> lottoNumberSet) {
        checkValidLotto(lottoNumberSet);
        this.lotto = lottoNumberSet;
    }

    public static Set<LottoNumber> toLottoNumberSet(List<Integer> lottoNums) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNums.size());

        for (int i = 0; i < lottoNums.size(); i++) {
            lottoNumberSet.add(LottoNumber.of(lottoNums.get(i)));
        }

        return lottoNumberSet;
    }

    private void checkValidLotto(Set<LottoNumber> lottoNumberSet) {
        if (lottoNumberSet.size() != LottoMachine.NUMS_PER_LOTTO) {
            throw new IllegalArgumentException(EXCEP_INVALID_NUM);
        }
    }

    public Set<LottoNumber> getLottoNumberList() {
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

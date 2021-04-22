package lotto.domain;

import java.util.*;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private Set<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new HashSet<>(lottoNumbers);

        if (this.lottoNumbers.size() < LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호 갯수는 6개여야 합니다.");
        }

        lottoNumbers.stream()
                .forEach(lottoNumber -> {
                    if (lottoNumber < 1 || lottoNumber > 45) {
                        throw new IllegalArgumentException("로또 번호는 1~45범위 내에 존재해야 합니다.");
                    }
                });
    }

    public List<Integer> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    public int match(Lotto winningLotto) {
        int count = 0;

        for (int lottoNumber : lottoNumbers) {
            boolean contains = winningLotto.contains(lottoNumber);
            count = checkLottoMatch(contains, count);
        }
        return count;
    }

    private int checkLottoMatch(boolean contains, int count) {
        if (contains) {
            count++;
        }
        return count;
    }


    private boolean contains(int lottoNumber) {

        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}

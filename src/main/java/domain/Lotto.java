package domain;

import java.util.*;

public class Lotto {
    static final int LOTTO_SIZE = 6;

    private Set<LottoNo> lotto;

    private Lotto(Set<LottoNo> lottoNo) {
        if(lottoNo.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
        this.lotto = lottoNo;
    }

    public Set<LottoNo> getLotto() {
        return lotto;
    }

    public int match(Lotto winningLotto) {
        int count = 0;

        for (LottoNo lottoNo : lotto) {
            count += winningLotto.matchCount(lottoNo);
        }
        return count;
    }

    int matchCount(LottoNo i) {
        if(lotto.contains(i)) {
            return 1;
        }
        return 0;
    }

    boolean isMatched(int bonusNo) {
        return lotto.contains(LottoNo.from(bonusNo));
    }

    public static Lotto from(List<Integer> lotto) {
        Set<LottoNo> set = new HashSet<>();
        for(Integer i : lotto) {
            set.add(LottoNo.from(i));
        }
        return new Lotto(set);
    }

    public static Lotto fromCommas(String string) {
        String str[] = string.split(",|, ");
        List<Integer> inputLotto = new ArrayList<>();
        for(String s : str) {
            inputLotto.add(Integer.parseInt(s));
        }
        return from(inputLotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + lotto +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}

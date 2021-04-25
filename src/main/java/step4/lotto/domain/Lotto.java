package step4.lotto.domain;

import java.util.*;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private Set<LottoNumber> lotto;

    public Lotto(List<Integer> lotto) {
        this(toMap(lotto));
    }

    private static Set<LottoNumber> toMap(List<Integer> lotto){
        Set<LottoNumber> lottoNumber = new HashSet<>();
        for(Integer number : lotto){
            lottoNumber.add(LottoNumber.of(number));
        }

        return lottoNumber;
    }

    public Lotto(Set<LottoNumber> lotto) {
        this.lotto = lotto;
        if(this.lotto.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또는 6개의 값이어야 합니다.");
        }
    }

    public int match(Lotto winning) {
        int count = 0;
        for(LottoNumber userNumber : lotto){
            if(winning.contains(userNumber)){
                count ++;
            }
        }
        return count;
    }

    public boolean contains(LottoNumber userNumber) {
        return lotto.contains(userNumber);
    }

    public Set<LottoNumber> getLotto() {
        return lotto;
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

    @Override
    public String toString() {
        return String.valueOf(lotto);
    }
}

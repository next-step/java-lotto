package step4.lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private Set<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = new HashSet<>(lotto);

        if(this.lotto.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또는 6개의 값이어야 합니다.");
        }
    }
    public int match(Lotto winning) {
        int count = 0;
        for(Integer userNumber : lotto){
            if(winning.contains(userNumber)){
                count ++;
            }
        }
        return count;
    }

    public boolean contains(Integer userNumber) {
        return lotto.contains(userNumber);
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

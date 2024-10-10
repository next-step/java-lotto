package lotto;

import java.util.Set;

public class Lotto {
    public static final String IS_NOT_LOTTO_SIZE = "번호가 6개가 아닙니다.";
    private final Set<Integer> lottoSet;

    public Lotto(Set<Integer> lottoSet) {
        this.lottoSet = validateLottoSetSize(lottoSet);
    }

    private Set<Integer> validateLottoSetSize(Set<Integer> lottoSet){
        if(lottoSet.size()!=6){
            throw new IllegalArgumentException(IS_NOT_LOTTO_SIZE);
        }
        return lottoSet;
    }
}

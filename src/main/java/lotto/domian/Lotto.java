package lotto.domian;

import com.sun.nio.sctp.IllegalReceiveException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        checkDuplicate(lotto);
        this.lotto = lotto;
    }

    private void checkDuplicate(List<LottoNumber> lotto) {
        Set<LottoNumber> setLottoNumbers = new HashSet<>(lotto);
        if (setLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않은 숫자 6개여야 합니다.");
        }
    }

}

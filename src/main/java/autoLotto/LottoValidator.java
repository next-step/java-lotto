package autoLotto;

import java.util.Set;

public class LottoValidator {

    public void validateInputLotto(Set<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("The number of Lotto numbers must be 6.");
        }
    }
}

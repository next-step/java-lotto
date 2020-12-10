package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.utils.ValidationChecker;

public class LottoAdmin {
    private Lotto winningLotto;

    private LottoAdmin() {
        this.winningLotto = new Lotto();
    }

    public LottoAdmin(List<Integer> nums) {
        this.winningLotto = new Lotto(nums);
    }

    public LottoAdmin(String lotto) {
        this.winningLotto = new Lotto(splitInputLotto(lotto));
    }

    private List<Integer> splitInputLotto(String lotto) {
        ValidationChecker.isEmptyOrNull(lotto);
         return Arrays.stream(lotto.split(", ")).filter(value -> ValidationChecker.exceptionCheck(value)).map(Integer::parseInt).collect(Collectors.toList());
    }

    public Rank calculateRank(Lotto lotto) {
        int result = 0;
        for(Integer num : lotto.getNums()) {
            result += winningLotto.contains(num) ? 1 : 0;
        }
        return Rank.of(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoAdmin that = (LottoAdmin) o;
        return Objects.equals(winningLotto, that.winningLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto);
    }
}

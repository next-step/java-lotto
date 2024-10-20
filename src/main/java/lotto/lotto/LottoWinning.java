package lotto.lotto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoWinning {

    private final Set<LottoNumber> winningLotto;

    public LottoWinning(String winLotto) {
        this.winningLotto = new HashSet<>();
        addWinNumber(winLotto);
    }

    private void addWinNumber(String str) {
        String[] nums = str.split(", ");

        if (nums.length > 6) {
            throw new IllegalArgumentException("로또 당첨 번호는 6개 입니다.");
        }

        for (String num : nums) {
            winningLotto.add(LottoNumber.from(num));
        }
    }

    public Set<Integer> getWinningLotto() {
        return winningLotto.stream().map(LottoNumber::getNumber).collect(Collectors.toSet());
    }
}

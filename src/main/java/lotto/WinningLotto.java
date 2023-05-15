package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final List<LottoNumber> winningNumber;
    private final LottoNumber bonusNumber;

    public WinningLotto(String winningNumbers, String bonusNumber) {
        this(split(winningNumbers), Integer.parseInt(bonusNumber));
    }

    public WinningLotto(String winningNumbers, int bonusNumber) {
        this(split(winningNumbers), bonusNumber);
    }

    public WinningLotto(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private static List<Integer> split(String winningNumbers) {
        String[] split = winningNumbers.replaceAll(" ","").split(",");

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public long matchRank(List<Lotto> lottos, Rank rank){
        return lottos.stream()
                .filter(lotto -> rank.equals(match(lotto)))
                .count();
    }

    Rank match(Lotto lotto) {
        return Rank.valueOf(getMatchCount(lotto), lotto.contain(bonusNumber));
    }

    private long getMatchCount(Lotto lotto) {
        return winningNumber.stream().filter(lotto::contain)
                .count();
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.contain(bonusNumber);
    }
}

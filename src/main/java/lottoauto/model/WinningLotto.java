package lottoauto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lottoauto.model.Constant.LottoMatch;

public class WinningLotto {

    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        winningNumberValidation(winningLotto);
        winningLotto.add(bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }


    public LottoResult compareWinningLottoNumber(Lottos lottos) {
        List<WinningReward> matchCount = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            matchCount.add(compare(lotto.getNumbers()));
        }

        return new LottoResult(
                matchCount.stream()
                        .filter(x -> x.getMatch() >= LottoMatch.MINIMUM_MATCH_COUNT)
                        .collect(Collectors.toList())
                , (lottos.getSize() * Constant.ONE_LOTTO_AMOUNT)
        );
    }

    private WinningReward compare(List<Integer> numbers) {

        boolean existBonus = numbers.contains(bonusNumber);
        List<Integer> matchNumbers = numbers.stream()
                .filter(n -> winningLotto.stream().anyMatch(Predicate.isEqual(n)))
                .collect(Collectors.toList());

        if (matchNumbers.size() == 6) {
            return calculateFirstOrSecond(existBonus);
        }

        return WinningReward.findRewardByMatches(matchNumbers.size());

    }

    private WinningReward calculateFirstOrSecond(boolean existBonus) {
        if (!existBonus) {
            return WinningReward.MATCH_6;
        }

        return WinningReward.MATCH_5_BONUS;
    }

    private void winningNumberValidation(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("당첨 숫자는 6개를 입력해야 합니다.");
        }
    }

}

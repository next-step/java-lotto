package domain;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static domain.LottoGames.MIN_WINNER_NUMBER;

public class WinnerNumber {

    private Lotto winnerNumber;
    private int bonusNumber;

    public WinnerNumber(String[] winnerNumber) {
        Set<Integer> winnerLotto = Arrays.stream(winnerNumber)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        this.winnerNumber = new Lotto(winnerLotto);
    }

    public void validateBonus(int bonus) {
        bonusNumber = bonus;
        List<Integer> list = winnerNumber.getLottoNumber();

        boolean hasComponent = list.contains(bonus);

        if (hasComponent) {
            throw new IllegalArgumentException("Bonus number Err!");
        }
    }

    public RankRecord checkAllLottosWithWinnerLotto(Lottos lottos) {
        RankRecord rankRecord = new RankRecord();

        lottos.getLottos().stream().forEach(e -> doRecord(e, rankRecord));

        return rankRecord;
    }


    private void doRecord(Lotto lotto, RankRecord rankRecord) {
        int count = countNumber(lotto);
        boolean matchBonus = false;

        if (count == 5 && findBonusNumber(lotto) == bonusNumber) {
            matchBonus = true;
        }

        if (count >= MIN_WINNER_NUMBER) {
            Rank ranking = Rank.valueOf(count, matchBonus);
            rankRecord.recordOfRankings(ranking);
        }
    }

    private int countNumber(Lotto lotto) {
        return getCountingNumber(lotto);
    }


    int getCountingNumber(Lotto lotto) {
        int count = (int) lotto.getLottoNumber()
                .stream()
                .filter(winnerNumber.getLottoNumber()::contains)
                .count();

        return count;
    }

    public int findBonusNumber(Lotto lotto) {
        Optional<Integer> bonus = lotto.getLottoNumber().stream()
                .filter(e -> !winnerNumber.getLottoNumber().contains(e))
                .findFirst();

        return (int) bonus.get();
    }
}
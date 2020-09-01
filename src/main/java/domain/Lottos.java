package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static domain.LottoGames.MIN_WINNER_NUMBER;

public class Lottos {
    private List<Lotto> lottos;
    private Lotto winnerNumber;
    private int bonusNumber;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getNumOfLottos() {
        return lottos.size();
    }

    public Lotto getOneLotto(int index) {
        return lottos.get(index);
    }

    public RankRecord recordAllLottos(Lotto winnerNumber, int bonus) {
        this.winnerNumber = winnerNumber;
        bonusNumber = bonus;

        RankRecord rankRecord = new RankRecord();

        for (int i = 0; i < getNumOfLottos(); i++) {
            doRecord(i, rankRecord);
        }
        return rankRecord;
    }

    private void doRecord(int i, RankRecord rankRecord) {
        int count = countNumber(getOneLotto(i));
        boolean matchBonus = false;

        if (count == 5 &&
                findBonus(getOneLotto(i)) == bonusNumber) {
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

    public int findBonus(Lotto lotto) {
        Optional<Integer> bonus = lotto.getLottoNumber().stream()
                .filter(e -> !winnerNumber.getLottoNumber().contains(e))
                .findFirst();

        return (int) bonus.get();
    }

    int getCountingNumber(Lotto lotto) {
        int count = (int) lotto.getLottoNumber()
                .stream()
                .filter(winnerNumber.getLottoNumber()::contains)
                .count();

        return count;
    }

    public void setWinnerNumber(Lotto winnerNumber) {
        this.winnerNumber = winnerNumber;
    }
}

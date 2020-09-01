package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static domain.LottoGames.MIN_WINNER_NUMBER;

public class Lottos {
    private List<Lotto> lottos;
    private WinnerNumber winnerNumber;

    //todo  WinnerNumber to Lotto class
//    private Lotto winnerNumber;

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

    public RankRecord calculateWinnerPrice(WinnerNumber winnerNumber) {
        this.winnerNumber = winnerNumber;
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
                findBonus(getOneLotto(i)) == winnerNumber.getBonusNumber()) {
            matchBonus = true;
        }

        if (count >= MIN_WINNER_NUMBER) {
            Rank ranking = Rank.valueOf(count, matchBonus);
            rankRecord.recordOfRankings(ranking);
        }
    }

    private int countNumber(Lotto lotto) {
        return winnerNumber.getCountingNumber(lotto);
    }

    public int findBonus(Lotto lotto) {
        Optional<Integer> bonus = lotto.getLottoNumber().stream()
                .filter(e -> !winnerNumber.getWinnerNumber().contains(e))
                .findFirst();

        return (int) bonus.get();
    }
}

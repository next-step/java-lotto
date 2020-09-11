package domain;


import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WinnerNumber {
    public static final int MIN_WINNER_NUMBER = 3;
    public static final int BONUS_COUNT = 5;

    private Lotto winnerNumber;
    private int bonusNumber;

    public WinnerNumber(String[] winnerNumber, int bonusNumber) {
        Set<LottoNo> winnerLotto = Arrays.stream(winnerNumber)
                .mapToInt(Integer::parseInt)
                .mapToObj(e -> new LottoNo(e))
                .collect(Collectors.toSet());

        validateBonus(winnerLotto, bonusNumber);

        this.bonusNumber = bonusNumber;
        this.winnerNumber = new Lotto(winnerLotto);
    }

    public void validateBonus(Set<LottoNo> lotto, int bonus) {
        boolean hasComponent = lotto.stream().anyMatch(e -> e.getNumber() == bonus);

        if (hasComponent) {
            throw new IllegalArgumentException("Bonus number Err!");
        }
    }

    public RankRecord checkAllLottosWithWinnerLotto(Lottos lottos) {
        RankRecord rankRecord = new RankRecord();

        lottos.getLottos().stream().forEach(e -> doRecord(e, rankRecord));

        return rankRecord;
    }


    public Lotto getWinnerNumber() {
        return winnerNumber;
    }

    private void doRecord(Lotto lotto, RankRecord rankRecord) {
        int count = lotto.match(winnerNumber);
        boolean matchBonus = false;

        if (count == BONUS_COUNT && lotto.contains(bonusNumber)) {
            matchBonus = true;
        }

        if (count >= MIN_WINNER_NUMBER) {
            Rank ranking = Rank.valueOf(count, matchBonus);
            rankRecord.recordOfRankings(ranking);
        }
    }
}
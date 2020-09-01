package domain;

import java.util.Arrays;
import java.util.Optional;
import static domain.Rank.RANK_THREE;
import static domain.Rank.RANK_TWO;
import static utility.UserInput.WON;

public class LottoGames {

    public static final int LOTTO_NUMBER = 6;
    public static final int MIN_WINNER_NUMBER = 3;

    private Lottos lottos;
    private WinnerNumber winnerNumber;
    private RankRecord rankRecord;

    public RankRecord getRankRecord() {
        return rankRecord;
    }

    public LottoGames(int price) {
        int tries = validatePrice(price);
        lottos = new Lottos();
        rankRecord = new RankRecord();

        makeLottoTicket(tries);
    }

    public Lottos getLottos() {
        return lottos;
    }

    private void makeLottoTicket(int tries) {
        NumberGenerator generator = new NumberGenerator();

        for (int i = 0; i < tries; i++) {
            lottos.addLotto(new Lotto(generator.generate()));
        }
    }

    private int validatePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price ERR!");
        }
        return price / WON;
    }

    public int calculateWinnerPrice(WinnerNumber winnerNumber) {
        int sum = 0;
        this.winnerNumber = winnerNumber;

        for (int i = 0; i < lottos.getNumOfLottos(); i++) {
            sum += sumAndRecord(i);
        }
        return sum;
    }

    private int sumAndRecord(int i) {
        int count = countNumber(lottos.getOneLotto(i));
        int winnerPrice = 0;
        boolean matchBonus = false;

        if (count == 5 &&
                findBonus(lottos.getOneLotto(i)) == winnerNumber.getBonusNumber()) {
            matchBonus = true;
        }

        if (count >= MIN_WINNER_NUMBER) {
            //get Price
            winnerPrice = sumOfWinnerPrice(count, matchBonus);

            //get Rank
            Rank ranking = Rank.valueOf(winnerPrice, matchBonus);
            //Record
            rankRecord.recordOfRankings(ranking);
        }
        return winnerPrice;
    }

    private int countNumber(Lotto lotto) {
        return winnerNumber.getCountingNumber(lotto);
    }

    private int sumOfWinnerPrice(int count, boolean matchBonus) {
        if (matchBonus) {
            return RANK_TWO.getWinnerPrice();
        }
        if (count == 5 && !matchBonus) {
            return RANK_THREE.getWinnerPrice();
        }

        Optional<Rank> winRank = Arrays.stream(Rank.values())
                .filter(rank -> rank.getCount() == count).findFirst();

        return winRank.get().getWinnerPrice();
    }

    public int findBonus(Lotto lotto) {
        Optional<Integer> bonus = lotto.getLottoNumber().stream()
                .filter(e -> !winnerNumber.getWinnerNumber().contains(e))
                .findFirst();

        return (int) bonus.get();
    }

    public void setWinnerNumber(WinnerNumber winnerNumber) {
        this.winnerNumber = winnerNumber;
    }
}

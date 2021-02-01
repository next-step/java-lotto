package lotto.domain;

public class LottoJudge {

    private static final int WINNER_BALL_COUNT = 6;
    private static final int BONUS_BALL_COUNT = 5;
    private int count = 0;

    public LottoJudge(GoldenTicket goldenTicket, LottoTicket lottoTicket) {
        addNormalLottoNumbersCount(goldenTicket, lottoTicket);
        addBonusLottoNumbersCount(goldenTicket, lottoTicket);
    }

    private void addNormalLottoNumbersCount(GoldenTicket goldenTicket, LottoTicket lottoTicket) {
        count += goldenTicket.getMatchedNumbersCount(lottoTicket);
        if (count == WINNER_BALL_COUNT) {
            count++;
        }
    }

    private void addBonusLottoNumbersCount(GoldenTicket goldenTicket, LottoTicket myLottoTicket) {
        if (count != BONUS_BALL_COUNT) {
            return;
        }
        if (goldenTicket.containsBonusBall(myLottoTicket)) {
            count++;
        }
    }

    public Rank determine() {
        return Rank.of(count);
    }
}

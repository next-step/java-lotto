package lotto.domain;

public class LottoResult {

    private static final int WINNER_BALL_COUNT = 6;
    private static final int BONUS_BALL_COUNT = 5;
    private int count = 0;

    public LottoResult(GoldenTicket goldenTicket, LottoTicket lottoTicket) {
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
        if (goldenTicket.containBonusBall(myLottoTicket)) {
            count++;
        }
    }

    public Rank getRank() {
        return Rank.of(count);
    }
}

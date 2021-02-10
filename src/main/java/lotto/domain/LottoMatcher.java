package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoMatcher {

    private static final int BONUS_MATCH_CONDITION_COUNT = 5;
    private final Map<Prize, Integer> prizeBoard = new EnumMap<>(Prize.class);

    public LottoMatcher() {
        Arrays.stream(Prize.values()).forEach(prize -> prizeBoard.put(prize, 0));
    }

    public void checkAllTickets(LottoTickets lottoTickets, WinningLotto winnerNumbers) {
        List<PlayersLotto> playersLottoTickets = lottoTickets.getLottoTickets();
        playersLottoTickets.forEach(lotto ->
            addPrizeStatus(getPrizeForEachLotto(lotto.getNumbers(), winnerNumbers)));
    }

    int getMatchedCount(List<LottoNumber> lottoNumber, WinningLotto winnerNumbers) {
        return (int) lottoNumber.stream()
            .filter(number -> winnerNumbers.getNumbers().contains(number))
            .count();
    }

    public Map<Prize, Integer> getPrizeBoard() {
        return prizeBoard;
    }

    public void addPrizeStatus(Prize prize) {
        prizeBoard.put(prize, prizeBoard.get(prize) + 1);
    }

    public Prize getPrizeForEachLotto(List<LottoNumber> lottoNumber, WinningLotto winnerNumbers) {
        int matchCnt = getMatchedCount(lottoNumber, winnerNumbers);
        int bonusBall = winnerNumbers.getBonusBall().getLottoNumber();
        Prize returnPrize = Arrays.stream(Prize.values())
            .filter(prize -> prize.getMatchedNumber() == matchCnt).findAny().get();
        if (matchCnt == BONUS_MATCH_CONDITION_COUNT
            && lottoNumber.stream().anyMatch(num -> num.getLottoNumber() == bonusBall)) {
            returnPrize = Prize.FIVE_WITH_BONUS;
        }
        return returnPrize;
    }
}

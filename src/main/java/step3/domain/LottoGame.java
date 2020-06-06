package step3.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LottoGame
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private static final String FIXED_DELIMITER = ",|:";

    private LottoTickets lottoTickets;

    private Lotto winningNumberLotto;

    // pay
    public int calculateGameCountByPayMoney(Money money) {

        if (money.getPayedMoney() % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
        return money.getPayedMoney() / LOTTO_PRICE;
    }


    public void issueLotto(int gameCount) {
        lottoTickets = Lotto.issueLotto(gameCount);
    }

    public void checkWiningNumber(String winingNumber, String bonusNumber) {

        String[] winningNumberArray = winingNumber.split(FIXED_DELIMITER);
        winningNumberLotto = Lotto.checkWiningNumber(winningNumberArray, bonusNumber);

    }

    public void matchingWinningNumbers() {
        lottoTickets.getLottoTickets().forEach(lotto -> {
            int matchedNumber = getWinningcount(lotto);
            addPrize(matchedNumber, checkBonusNumberMatching(lotto, matchedNumber));
        });

    }

    private int getWinningcount(Lotto lotto) {

        return (int) lotto.getNumbers().stream()
                .filter(lottoNumber ->
                        isPresentWinningNumber(lottoNumber))
                .count();
    }

    private boolean isPresentWinningNumber(Integer lottoNumber) {
        return winningNumberLotto.getNumbers()
                .stream()
                .filter(winningNumber -> winningNumber == lottoNumber)
                .findFirst()
                .isPresent();
    }

    private boolean checkBonusNumberMatching(Lotto lotto, int matchedNumber) {

        List<Integer> bounsGameChanceNumbers = new ArrayList<>();

        Arrays.stream(Prize.values())
                .forEach(prize -> {
                            if (prize.isBonusNumberMatching()) {
                                bounsGameChanceNumbers.add(prize.getMatchedNumber());
                            }
                        }
                );


        return bounsGameChanceNumbers.contains(matchedNumber)
                && !lotto.getNumbers().contains(winningNumberLotto.getBonusNumber())
                ? true : false;
    }


    private void addPrize(int matchedNumber, boolean bonusNumberMatching) {

        Prize prize = Prize.valueOf(matchedNumber, bonusNumberMatching);
        prize.addWinning();

    }


    public BigDecimal totalResult() {

        // winningResult
        BigDecimal sum = BigDecimal.valueOf(Arrays.stream(Prize.values())
                .mapToLong(prize -> prize.getPrizeTotal())
                .sum());

        return sum.divide(BigDecimal.valueOf(lottoTickets.getLottoTicketsSize() * LOTTO_PRICE), 3, BigDecimal.ROUND_HALF_EVEN);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

}

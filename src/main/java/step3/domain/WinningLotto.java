package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningLotto {

    private static Lotto winningNumberLotto;

    public WinningLotto(Lotto winningNumberLotto) {
        this.winningNumberLotto = winningNumberLotto;
    }

    // matchingWinningNumbers
    public void matchingWinningNumbers(LottoTickets lottoTickets) {

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
                            addBonusChanceNumber(bounsGameChanceNumbers, prize);
                        }
                );

        if (bounsGameChanceNumbers.contains(matchedNumber)
                && lotto.getNumbers().contains(winningNumberLotto.getBonusNumber())
                && !winningNumberLotto.getNumbers().contains(winningNumberLotto.getBonusNumber())) {

            return true;
        }

        return false;

    }

    private void addBonusChanceNumber(List<Integer> bounsGameChanceNumbers, Prize prize) {
        if (prize.isBonusNumberMatching()) {
            bounsGameChanceNumbers.add(prize.getMatchedNumber());
        }
    }

    private void addPrize(int matchedNumber, boolean bonusNumberMatching) {

        Prize prize = Prize.valueOf(matchedNumber, bonusNumberMatching);
        prize.addWinning();

    }

}

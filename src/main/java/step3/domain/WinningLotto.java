package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    public static Lotto winningNumberLotto;

    public WinningLotto(String winningNumber, String bonusNumber) {

        String[] winningNumberArray = winningNumber.split(LottoGame.FIXED_DELIMITER);

        if (winningNumberArray.length != Lotto.LOTTO_DRAW_LIMIT) {
            throw new IllegalArgumentException("Not matched with draw limits. ");
        }

        Number.checkNotNumber(winningNumberArray);
        Number.checkNumber(winningNumberArray);

        Number.checkNotNumber(bonusNumber);
        Number.checkNumber(bonusNumber);

        int bonusNumberInt = Integer.valueOf(bonusNumber);

        if (bonusNumberInt > Lotto.LOTTO_DRAW_BASE_NUMBER && bonusNumberInt > Lotto.LOTTO_MAX_LIMIT) {
            throw new IllegalArgumentException("Not matched range of bonus ball.");
        }

        winningNumberLotto = new Lotto(Arrays.stream(winningNumberArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList()), bonusNumberInt);
    }


    private boolean isPresentWinningNumber(Integer lottoNumber) {
        return winningNumberLotto.getNumbers()
                .stream()
                .filter(winningNumber -> winningNumber == lottoNumber)
                .findFirst()
                .isPresent();
    }

    private int getWinningcount(Lotto lotto) {

        return (int) lotto.getNumbers().stream()
                .filter(lottoNumber ->
                        isPresentWinningNumber(lottoNumber))
                .count();
    }


    public void matchingWinningNumbers(LottoTickets lottoTickets) {

        lottoTickets.getLottoTickets().forEach(lotto -> {
            int matchedNumber = getWinningcount(lotto);
            addPrize(matchedNumber, checkBonusNumberMatching(lotto, matchedNumber));
        });

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
                && !winningNumberLotto.getNumbers().contains(winningNumberLotto.getBonusNumber())
        ){

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

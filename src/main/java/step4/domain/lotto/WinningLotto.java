package step4.domain.lotto;

import step4.domain.prize.Prize;
import step4.domain.prize.PrizeCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningLotto {

    private Lotto lottoNumbers;
    private int bonusNumber;

    private WinningLotto(Lotto lottoNumbers, int bonusNumber) {
        if (bonusNumber <= LottoNumber.LOTTO_DRAW_BASE_NUMBER && bonusNumber > LottoNumber.LOTTO_MAX_LIMIT) {
            throw new IllegalArgumentException("Not matched range of bonus ball.");
        }
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(String winningLotto, String bonusNumber) {
        return new WinningLotto(new Lotto(winningLotto), Integer.parseInt(bonusNumber));
    }

    // matching
    public void matchingWinningNumbers(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().forEach(lotto -> {
            int matchedNumber = getWinningcount(lotto);
            addPrize(matchedNumber, checkBonusNumberMatching(lotto, matchedNumber));
        });
        // to print result.
        PrizeCount prizeCount = PrizeCount.getInstance();
        prizeCount.showPrizeCounts();
    }

    private int getWinningcount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(lottoNumber ->
                        isPresentWinningNumber(lottoNumber))
                .count();
    }

    private boolean isPresentWinningNumber(Integer lottoNumber) {
        return lottoNumbers.getNumbers().stream()
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
                && lotto.getNumbers().contains(bonusNumber)
                && !lottoNumbers.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private void addBonusChanceNumber(List<Integer> bonusGameChanceNumbers, Prize prize) {
        if (prize.isBonusNumberMatching()) {
            bonusGameChanceNumbers.add(prize.getMatchedNumber());
        }
    }

    private void addPrize(int matchedNumber, boolean bonusNumberMatching) {
        Prize prize = Prize.valueOf(matchedNumber, bonusNumberMatching);
        PrizeCount prizeCount = PrizeCount.getInstance();
        prizeCount.prizeAdd(prize);
    }
}

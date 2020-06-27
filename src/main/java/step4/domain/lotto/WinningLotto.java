package step4.domain.lotto;

import step4.domain.LottoGame;
import step4.domain.prize.Prize;
import step4.domain.prize.PrizeCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningLotto {

    private Lotto winningLottoNumbers;
    private LottoNumber bonusNumber;

    private WinningLotto(Lotto lottoNumbers, LottoNumber bonusNumber) {
        if (bonusNumber.getLottoNumber() <= LottoNumber.LOTTO_DRAW_BASE_NUMBER && bonusNumber.getLottoNumber() > LottoNumber.LOTTO_MAX_LIMIT) {
            throw new IllegalArgumentException("Not matched range of bonus ball.");
        }
        this.winningLottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(String winningLotto, String bonusNumber) {
        return new WinningLotto(new Lotto(winningLotto), LottoNumber.of(Integer.valueOf(bonusNumber)));
    }

    // matching
    public void matchingWinningNumbers(LottoGame lottoGame, PrizeCount prizeCount) {
        lottoGame.getLottoTickets().forEach(lotto -> {
            long matchedNumber = getWinningCount(lotto);
            prizeCount.prizeAdd(Prize.valueOf(matchedNumber, checkBonusNumberMatching(lotto, matchedNumber)));
        });
    }

    private long getWinningCount(Lotto lotto) {
        return winningLottoNumbers.getNumbers().stream()
                .filter(lottoNumber ->
                        lotto.contains(lottoNumber))
                .count();
    }

    private boolean checkBonusNumberMatching(Lotto lotto, long matchedNumber) {
        List<Long> bounsGameChanceNumbers = new ArrayList<>();
        Arrays.stream(Prize.values())
                .forEach(prize -> {
                            addBonusChanceNumber(bounsGameChanceNumbers, prize);
                        }
                );
        if (bounsGameChanceNumbers.contains(matchedNumber)
                && lotto.contains(bonusNumber)
                && !winningLottoNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private void addBonusChanceNumber(List<Long> bonusGameChanceNumbers, Prize prize) {
        if (prize.isBonusNumberMatching()) {
            bonusGameChanceNumbers.add(prize.getMatchedNumber());
        }
    }

}

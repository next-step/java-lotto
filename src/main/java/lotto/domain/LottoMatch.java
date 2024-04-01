package lotto.domain;

public class LottoMatch {
    public static Rank match(Lotto givenLotto, WinningLotto winningLotto) {
        int matchCount = givenLotto.match(winningLotto.getWinNumbers());

        return Rank.valueOf(matchCount, matchBonus(givenLotto, winningLotto.getBonusNumber()));
    }

    private static boolean matchBonus(Lotto givenLotto, LottoNumber bonusNumber) {
        return givenLotto.isContainsBonus(bonusNumber);
    }

}

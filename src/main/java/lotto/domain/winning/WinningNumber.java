package lotto.domain.winning;

import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumber;
import lotto.domain.game.LottoNumberSet;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created By mand2 on 2020-11-19.
 */
public class WinningNumber {

    private final LottoNumberSet winningNumber;
    private final LottoNumber bonusBall;

    public static final String MESSAGE_BONUS_BALL_DUPLICATED = "보너스 볼은 당첨번호와 겹칠 수 없습니다.";

    private WinningNumber(LottoNumberSet winningNumber, String bonusBall) {
        this.winningNumber = winningNumber;
        this.bonusBall = LottoNumber.from(bonusBall);

        checkBonusBallDuplicated(winningNumber, this.bonusBall);
    }

    public static WinningNumber of(String inputWinningNumber, String bonusBall) {
        String[] inputs = inputWinningNumber.split(", ");
        LottoNumberSet lottoNumberSet = LottoNumberSet.of(Stream.of(inputs)
                .map(LottoNumber::from).collect(toList()));

        return new WinningNumber(lottoNumberSet, bonusBall);
    }

    public Set<LottoNumber> value() {
        return this.winningNumber.value();
    }

    public WinningRank match(Lotto lotto) {
        long matchCount = matchCount(lotto);
        boolean matchBonus = matchBonus(lotto);
        return WinningRank.getWinningRank((int) matchCount, matchBonus);
    }

    private long matchCount(Lotto lotto) {
        return lotto.number().stream()
                .filter(num -> this.winningNumber.contains(num))
                .count();
    }

    private boolean matchBonus(Lotto lotto) {
        return lotto.number().stream()
                .anyMatch(num -> this.bonusBall.equals(num));
    }


    private static void checkBonusBallDuplicated(LottoNumberSet winningNumber, LottoNumber bonusBall) {
        if (winningNumber.contains(bonusBall)) {
            throw new RuntimeException(MESSAGE_BONUS_BALL_DUPLICATED);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumber that = (WinningNumber) o;
        return Objects.equals(winningNumber, that.winningNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumber);
    }
}

package lotto.domain.winning;

import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumber;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created By mand2 on 2020-11-19.
 */
public class WinningNumber {

    private final LottoNumber winningNumber;
    private final BonusBall bonusBall;

    public static final String MESSAGE_BONUS_BALL_DUPLICATED = "보너스 볼은 당첨번호와 겹칠 수 없습니다.";

    private WinningNumber(LottoNumber winningNumber, String bonusBall) {
        this.winningNumber = winningNumber;
        this.bonusBall = BonusBall.from(bonusBall);

        checkBonusBallDuplicated(winningNumber, this.bonusBall);
    }

    public static WinningNumber of(String inputWinningNumber, String bonusBall) {
        String[] inputs = inputWinningNumber.split(", ");
        LottoNumber lottoNumber = LottoNumber.of(Stream.of(inputs)
                .map(Integer::valueOf).collect(toList()));

        return new WinningNumber(lottoNumber, bonusBall);
    }

    public List<Integer> value() {
        return Collections.unmodifiableList(this.winningNumber.value());
    }

    public long matchCount(Lotto lotto) {
        return lotto.number().stream()
                .filter(num -> this.winningNumber.contains(num))
                .count();
    }

    private static void checkBonusBallDuplicated(LottoNumber winningNumber, BonusBall bonusBall) {
        if (winningNumber.contains(bonusBall.value())) {
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

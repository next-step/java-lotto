package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class WinningInfosTest {

    @Test
    void test() {
        BigDecimal result = new BigDecimal(0);
        WinningInfo of = WinningInfo.of(LottoWinningType.FORTH_WINNING);
        of.increaseHitNumber();
        BigDecimal multiply = of.getWinningType().getLottoMoney().multiply(of.getWinningNumber());
        System.out.println(multiply);
        BigDecimal add = result.add(multiply);
        System.out.println(add);

        BigDecimal money = new BigDecimal(14000);
        System.out.println(add.divide(money, 2, RoundingMode.DOWN).doubleValue());
    }
}
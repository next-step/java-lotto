package lottery.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LotteryNumberTest {
    int defaultValue = 3;
    int underValue = LotteryNumber.MIN - 1;
    int overValue = LotteryNumber.MAX + 1;
    LotteryNumber defaultLotteryNumber;

    @BeforeEach
    void setUp() {
        defaultLotteryNumber = new LotteryNumber(defaultValue);
    }

    @Test
    @DisplayName("범위 내에 있지 않은 값이 들어오면 IllegalArgumentException을 던진다")
    void wrongValue() {
        assertThrows(IllegalArgumentException.class, () -> new LotteryNumber(underValue));
        assertThrows(IllegalArgumentException.class, () -> new LotteryNumber(overValue));
    }

    @Test
    @DisplayName("value를 호출하면 입력한 value를 호출한다")
    void value() {
        assertEquals(defaultValue, defaultLotteryNumber.value());
    }

    @Test
    @DisplayName("compareTo 테스트")
    void compareTo() {
        assertEquals(1, defaultLotteryNumber.compareTo(new LotteryNumber(defaultValue - 1)));
    }

    @Test
    @DisplayName("equals 테스트")
    void testEquals() {
        assertEquals(new LotteryNumber(defaultValue), defaultLotteryNumber);
    }

    @Test
    void testToString() {
        assertEquals(String.format("LottoNumber(%d)", defaultValue), defaultLotteryNumber.toString());
    }
}

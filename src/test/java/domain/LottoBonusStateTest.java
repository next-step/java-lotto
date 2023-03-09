package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBonusStateTest {
    @DisplayName("LottoBonusState Enum test")
    @Test
    void lottoBounusStateTest() {
        // System.out.println(LottoBonusState.values());

        LottoBonusState[] states = LottoBonusState.values();

        for (LottoBonusState state : states) {
            System.out.println(state);
        }

        // LottoBonusState bool = new LottoBonusState(true);

        System.out.println(LottoBonusState.YES);
        System.out.println(LottoBonusState.YES.equals(true));
        System.out.println(LottoBonusState.YES.getValue());
    }

}

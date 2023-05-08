package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class WinRuleTest {
    @Test
    @DisplayName("당첨 규칙")
    void winRuleTest() {
        //given //when
        WinRule winRule = new WinRule();

        //then
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(3, 5_000);
        expected.put(4, 50_000);
        expected.put(5, 1_500_000);
        expected.put(6, 2_000_000_000);

        Assertions.assertEquals(expected, winRule.getWinRule());

    }
}

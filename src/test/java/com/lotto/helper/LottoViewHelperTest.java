package com.lotto.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoViewHelperTest {

    @DisplayName("금액 입력 후 개수 테스트")
    @ParameterizedTest
    @MethodSource("provideMoney")
    void getCountOfLottoTest(final Integer money, final Integer expected) {
        Integer result = LottoViewHelper.getCountOfLotto(money);
        assertEquals(result, expected);
    }

    private static Stream<Arguments> provideMoney() {
        return Stream.of(
                Arguments.of(14000, 14),
                Arguments.of(7500, 7),
                Arguments.of(1234, 1)
        );
    }
}

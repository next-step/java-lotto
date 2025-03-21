package step1.calc.utils;

import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    void isEmpty_문자열이_null일_때_true를_반환한다() {
        boolean result = StringUtils.isEmpty(null);

        assert result;
    }

    @Test
    void isEmpty_문자열이_빈문자열일_때_true를_반환한다() {

        boolean result = StringUtils.isEmpty("");

        assert result;
    }

}

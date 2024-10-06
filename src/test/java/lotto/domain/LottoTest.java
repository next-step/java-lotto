package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또_생성_무작위() {
        Lotto lotto = Lotto.create();

        assertThat(lotto.stream().allMatch(number -> number > 0 && number < 46))
                .isTrue();
        assertThat(lotto.stream().collect(Collectors.toList()))
                .isSorted();
    }

    @Test
    void 로또_생성_문자열() {
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");

        assertThat(lotto.stream().allMatch(number -> number > 0 && number < 46))
                .isTrue();
    }

    @Test
    void 로또_생성_문자열_null() {
        Assertions.assertThatNullPointerException().isThrownBy(() -> Lotto.of(null));
    }

    @Test
    void 로또_생성_문자열_빈문자() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(""));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 로또_생성_문자열_6개_아님(String text) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(text));
    }
}

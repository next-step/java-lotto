package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또_생성_무작위() {
        Lotto lotto = Lotto.create();
        LottoNumber[] sequence = IntStream.range(1, 7)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList())
                .toArray(new LottoNumber[] {});

        assertThat(lotto.stream().allMatch(number -> number.number() > 0 && number.number() < 46))
                .isTrue();
        assertThat(lotto.stream().map(LottoNumber::number).collect(Collectors.toList()))
                .isSorted();
        assertThat(lotto.stream().collect(Collectors.toList())).doesNotContainSequence(sequence);
    }

    @Test
    void 로또_생성_문자열() {
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");

        assertThat(lotto.stream().allMatch(number -> number.number() > 0 && number.number() < 46))
                .isTrue();
    }

    @Test
    void 로또_생성_중복숫자() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of("1, 1, 3, 4, 5, 6"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 47", "0, 1, 2, 3, 4, 5", "1, 3, 2, -3, 4, 5"})
    void 로또_생성_문자열_1_45_아님(String text) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(text));
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

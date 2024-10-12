package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.model.Lotto.*;
import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void 로또를_저장한다() {
        assertThatNoException().isThrownBy(() -> {
            Lotto lotto = Lotto.of(6, 9, 17, 28, 39, 45);
        });
    }

    @Test
    void 로또번호는_중복되면_오류() {
        assertThatThrownBy(() -> {
            Lotto duplicatedLotto = Lotto.of(6, 6, 9, 17, 28, 39);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED);
    }

    @ParameterizedTest(name = "로또번호는_1_45_사이의_정수가_아니면_오류({0})")
    @MethodSource(value = "falseLottoFixture")
    void 로또번호는_1_45_사이의_정수가_아니면_오류(int[] lottoNumbers) {
        assertThatThrownBy(() -> {
            Lotto falseLotto = Lotto.of(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ALLOWED_BETWEEN_6_TO_45_INTEGER);
    }

    @Test
    void 로또번호목록은_반드시_6개가_저장되어야_한다() {
        assertThatThrownBy(() -> {
            Lotto lottoNumbersSizeIsNotSix = Lotto.of(6, 17, 28, 39);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6);
    }

    public static Stream<Arguments> falseLottoFixture() {
        return Stream.of(
                Arguments.of(new int[]{0, 6, 17, 28, 39, 45}),
                Arguments.of(new int[]{6, 17, 28, 39, 45, 46})
        );
    }
}
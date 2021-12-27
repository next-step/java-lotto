package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void init() {
        lotto = new Lotto(Arrays.asList(new Ball(2), new Ball(5),
                                                    new Ball(6), new Ball(24),
                                                    new Ball(33), new Ball(42)));
    }

    @Test
    void 로또번호_생성_6개_입력() {
        assertThat(new Lotto("2, 5, 6, 24, 33, 42")).isEqualTo(lotto);
    }

    @Test
    void 로또번호_생성_6개_입력_순서상관없이() {
        assertThat(new Lotto("5, 2, 6, 24, 42, 33")).isEqualTo(lotto);
    }

    @Test
    void 로또번호_생성_6개_입력_다른번호일경우() {
        assertThat(new Lotto("3, 20, 23, 25, 33, 44")).isNotEqualTo(lotto);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2, 5, 6, 20, 23", "1, 4, 7, 24, 33, 42, 9", "1, 2, 3"})
    void 로또번호_생성_개수_비정상_입력_예외발생(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(input);
        }).withMessageMatching(Lotto.VALID_LOTTO_COUNT_MSG);
    }

    // 2, 5, 6, 24, 33, 42
    @ParameterizedTest
    @ValueSource(strings = {"2, 5, 6, 20, 23, 41", "1, 4, 7, 24, 33, 42"})
    void 로또번호_일치_개수확인(String input) {
        assertThat(new Lotto(input).getMatchCount(lotto)).isEqualTo(3);
    }

    @Test
    void 로또번호_일치_개수확인_전부() {
        assertThat(new Lotto("2, 5, 6, 24, 33, 42").getMatchCount(lotto)).isEqualTo(6);
        assertThat(new Lotto("1, 4, 7, 23, 32, 41").getMatchCount(lotto)).isEqualTo(0);
    }

    @Test
    void 로또번호_일치_개수확인_전부_순서바꿔서() {
        assertThat(new Lotto("24, 33, 42, 2, 5, 6").getMatchCount(lotto)).isEqualTo(6);
    }

}
package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

/**
 * @author han
 */
public class LottoTest {

    @Test
    @DisplayName("로또 자동 생성")
    void create() {
        Lotto byAuto = new Lotto(new LottoNumberFactory().getNonDuplicated());
        assertThat(byAuto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("문자를 통한 로또 생성")
    void createBy() {
        Lotto byString = new Lotto("1,2,3,4,5,6");
        assertThat(byString.getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("동일한 값 입력을 통해, 로또 숫자 갯수가 부족할 경우 에러를 던진다")
    void throwErrorIfDuplicated() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto("1,2,3,4,5,5"));
    }
}

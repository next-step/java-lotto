package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    private static final int LOTTO_SIZE = 6;

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("로또 번호가 제대로 생성되는 확인하는 테스트(빈값)")
    void 로또_번호가_제대로_생성되는_확인하는_테스트_빈값(String input) {

        assertThatThrownBy(() -> {
            Lotto.from(input);
        }).isInstanceOf(RuntimeException.class)
            .hasMessageContaining("빈 값이 입력되었습니다. 값을 입력하세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd,fone,asd,122446d"})
    @DisplayName("로또 번호가 제대로 생성되는 확인하는 테스트(잘못된문자열)")
    void 로또_번호가_제대로_생성되는_확인하는_테스트_잘못된문자열(String input) {

        assertThatThrownBy(() -> {
            Lotto.from(input);
        }).isInstanceOf(RuntimeException.class)
            .hasMessageContaining("잘못된 문자열이 입력되었습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    @DisplayName("로또 번호가 제대로 생성되는 확인하는 테스트")
    void 로또_번호가_제대로_생성되는_확인하는_테스트(String input) {

        Lotto result = Lotto.from(input);

        assertThat(result.getLotto().length).isEqualTo(LOTTO_SIZE);
    }
}
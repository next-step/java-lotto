package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.utils.LottoParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 생성 시 1-45 범위에 속하지 않는 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1, 2, 3, 4, 5, 46"})
    public void createLottoFailed_outOfRange(String lottoNumbers) {
        assertThatThrownBy(() -> {
            new Lotto(LottoParser.parse(lottoNumbers));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }

    @DisplayName("로또 생성 시 중복된 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 1"})
    public void createLottoFailed_duplicated(String lottoNumbers) {
        assertThatThrownBy(() -> {
            new Lotto(LottoParser.parse(lottoNumbers));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("로또 생성 시 숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4,3,t,1", "5, t, 3"})
    public void createLottoFailed_notNumeric(String lottoNumbers) {
        assertThatThrownBy(() -> {
            new Lotto(LottoParser.parse(lottoNumbers));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }
}

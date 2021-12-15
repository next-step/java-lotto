package lotto.domain;

import lotto.strategy.CreationManualLottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto("1,2,3,4,5,6");
    }

    @Test
    void 문자_로또_비교() {
        assertThat(lotto).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"1,2,3", "1,2,3,4,5,6,7"})
    void 로또_번호_개수_체크(String param) {
        assertThatThrownBy(() -> {
            new Lotto(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"-1,0,1,2,3,4", "1,2,3,4,45,46"})
    void 숫자_1이상_45이하의_입력시_IllegalArgumentException(String param) {
        assertThatThrownBy(() -> {
            new Lotto(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"ONE,2,3,4,5,6", "하나,2,3,4,5,6"})
    void 문자_오입력시_IllegalArgumentException(String param) {
        assertThatThrownBy(() -> {
            new Lotto(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_꽝_맞힌_횟수() {
        PrizeLotto prizeLotto = new PrizeLotto("1,2,34,35,45,36", "7");
        assertThat(lotto.matchCountLottoNumbers(prizeLotto)).isEqualTo(2);
    }

    @Test
    void 로또_상금_맞힌_횟수() {
        PrizeLotto prizeLotto = new PrizeLotto("1,2,3,4,45,36", "7");
        assertThat(lotto.matchCountLottoNumbers(prizeLotto)).isEqualTo(4);
    }

    @Test
    void 로또_보너스번호_일치() {
        assertThat(lotto.contain(LottoNumber.from(6))).isTrue();
    }

    @Test
    void 정적_팩토리_메서드_자동_로또_생성() {
        Lotto compareLotto = lotto.from((String) -> new Lotto("1,2,3,4,5,6"));
        assertThat(compareLotto).isEqualTo(lotto);
    }

    @Test
    void 수동_로또_생성() {
        Lotto compareLotto = lotto.of(new CreationManualLottoNumber(), "1,2,3,4,5,6");
        assertThat(compareLotto).isEqualTo(lotto);
    }
}

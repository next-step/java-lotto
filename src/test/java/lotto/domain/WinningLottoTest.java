package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("당첨 로또 (WinningLotto) 테스트")
public class WinningLottoTest {

    private LottoTicket winningTicket;

    private WinningLotto winningLotto;


    @BeforeEach
    void setUp() {
        winningTicket = LottoTicket.of(Arrays.asList(
                LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6)));
        winningLotto = WinningLotto.of(winningTicket, LottoNumber.valueOf(7));
    }

    @DisplayName("당첨 로또는 당첨 로또 티켓 하나와 보너스번호 하나로 구성된다.")
    @Test
    void test() {
        // then
        assertThat(winningLotto).isNotNull();
    }

    @DisplayName("보너스 번호는 로또 티켓의 번호와 중복될 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void createNoneDuplicated(int value) {
        // when
        LottoNumber duplicated = LottoNumber.valueOf(value);

        // then
        assertThrows(IllegalArgumentException.class, () -> WinningLotto.of(winningTicket, duplicated));
    }

    @DisplayName("특정 로또 번호가 포함되는 지 확인할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "6,true", "7,false"})
    void contains(int value, boolean expected) {
        // given
        LottoNumber lottoNumber = LottoNumber.valueOf(value);

        // when
        boolean contains = winningLotto.contains(lottoNumber);

        // then
        assertThat(contains).isEqualTo(expected);
    }

    @DisplayName("보너스 번호가 맞는 지 확인할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"6,false", "7,true", "8,false"})
    void isBonus(int value, boolean expected) {
        // given
        LottoNumber bonus = LottoNumber.valueOf(value);

        // when
        boolean isBonus = winningLotto.isBonus(bonus);

        // then
        assertThat(isBonus).isEqualTo(expected);
    }
}

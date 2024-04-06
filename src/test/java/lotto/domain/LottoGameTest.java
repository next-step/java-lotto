package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoGameTest {
    @ParameterizedTest(name = "{0}원 구입, {1}개 출력")
    @CsvSource(value = {"3000 : 3", "2000 : 2"}, delimiter = ':')
    @DisplayName("자동 로또 발행 테스트")
    void create_auto_lotto_test(int money, int output) {
        List<Lotto> lottos = new LottoGame(money).createAutoLotto(new RandomNumberStrategy());
        assertThat(lottos.size()).isEqualTo(output);
    }

    @Test
    @DisplayName("수동 로또 발행 테스트")
    void create_manual_lotto_test() {
        List<String> manualLottos = Arrays.asList(
                "1,2,3,4,5,6",
                "1,2,3,4,5,6",
                "1,2,3,4,5,6");
        List<Lotto> lottos = new LottoGame(3000).createManualLotto(manualLottos);
        assertThat(lottos.size()).isEqualTo(manualLottos.size());
    }

    @ParameterizedTest(name = "구매 가격 : {0} 예외")
    @CsvSource(value = {"2500", "1234"})
    @DisplayName("단위에 맞지 않은 구입 예외 테스트")
    void validate_lotto_test(int input) {
        assertThatThrownBy(() -> {
            new LottoGame(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

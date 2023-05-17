package study.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoBundleTest {


    @ParameterizedTest
    @CsvSource(value = {
            "14005, 14",
            "3580, 3"
    })
    void 금액별_로또개수_테스트(int money, int trial) {
        LottoBundle lottoBundle = LottoBundle.createByMoney(money, new ArrayList<>());
        assertThat(lottoBundle.getLottos().size()).isEqualTo(trial);
    }

    @Test
    void 금액보다_큰_수동구매는_익셉션() {
        assertThatThrownBy(() -> {

            LottoBundle.createByMoney(1000, List.of(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(1, 2, 3, 4, 5, 6))
            ));
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("1000원")
                .hasMessageContaining("2장");
    }
}
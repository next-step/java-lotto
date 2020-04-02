package study.lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.Lotto;
import study.lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomAndRandomLottoIssuerTest {
    @DisplayName("수동으로 입력받은 로또를 리턴하고, 나머지는 랜덤한 로또를 리턴한다")
    @Test
    void correct() {
        Lotto first = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43));
        Lotto second = new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38));
        Lottos lottos = new Lottos(new ArrayList<>(Arrays.asList(
                first,
                second
        )));

        CustomAndRandomLottoIssuer customAndRandomLottoIssuer =
                new CustomAndRandomLottoIssuer(lottos);

        Lotto expectFirst = customAndRandomLottoIssuer.issue();
        assertThat(first).isEqualTo(expectFirst);
        Lotto expectSecond = customAndRandomLottoIssuer.issue();
        assertThat(second).isEqualTo(expectSecond);
        Lotto something = customAndRandomLottoIssuer.issue();
        assertThat(something).isNotIn(first, second);
    }

    @DisplayName("아무것도 입력받지 않을 수 있다.")
    @Test
    void empty() {
        CustomAndRandomLottoIssuer customAndRandomLottoIssuer =
                new CustomAndRandomLottoIssuer(null);
        Lotto something = customAndRandomLottoIssuer.issue();
        assertThat(something).isNotNull();
    }
}

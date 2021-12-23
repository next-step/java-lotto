package lotto.domain;

import lotto.exception.LottoApplicationException;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void init() {
        lottoGenerator = () -> {
            LottoNumbers lottoNumbers = new LottoNumbers(
                    Sets.newHashSet(
                            Arrays.asList(
                                    new LottoNumber(1),
                                    new LottoNumber(2),
                                    new LottoNumber(3),
                                    new LottoNumber(4),
                                    new LottoNumber(5),
                                    new LottoNumber(6)
                            )
                    )
            );

            return new Lotto(lottoNumbers);
        };
    }

    @Test
    @DisplayName("buy 테스트: money가 1000으로 나누어떨어지지 않으면 LottoApplicationException 발생")
    void buy1() {
        Money money = new Money(1500);
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.buy(money, lottoGenerator))
                .isInstanceOf(LottoApplicationException.class);
    }

    @Test
    @DisplayName("buy 테스트: money가 1000보다 작으면 LottoApplicationException 발생")
    void buy2() {
        Money money = new Money(500);
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.buy(money, lottoGenerator))
                .isInstanceOf(LottoApplicationException.class);
    }

    @Test
    @DisplayName("buy 테스트: money를 1000으로 나눈 수의 Lotto를 포함한 Lottos를 리턴")
    void buy3() {
        Money money = new Money(5000);
        LottoMachine lottoMachine = new LottoMachine();

        Lottos lottos = lottoMachine.buy(money, lottoGenerator);

        assertThat(lottos.collect()).hasSize(5);
    }


}

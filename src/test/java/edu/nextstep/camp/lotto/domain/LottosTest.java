package edu.nextstep.camp.lotto.domain;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottosTest {
    @Test
    public void create() {
        final Lotto testLotto = Lotto.of(
                List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
        );
        assertThat(Lottos.of(List.of(testLotto)))
                .isEqualTo(Lottos.of(List.of(
                        Lotto.of(
                                List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
                        )
                )));
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @NullAndEmptySource
    public void createFailed(List<Lotto> lottos) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lottos.of(lottos))
                .withMessageContaining("invalid input");
    }

    @Test
    public void amount() {
        final Lottos testLottos = Lottos.of(List.of(
                        Lotto.of(
                                List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
                        )
                ));
        assertThat(testLottos.amount()).isEqualTo(1);

    }
}

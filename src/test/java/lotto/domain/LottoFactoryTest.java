package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoFactoryTest {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    @Test
    void 로또_생성_숫자_범위_테스트() {
        Lotto lotto = LottoFactory.createLottoAutomatically();
        for (Integer number : lotto.getLottoNumbers()) {
            assertThat(number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER).isTrue();
        }
    }

    @Test
    void 로또_생성_불변_테스트() {
        Lotto lotto = LottoFactory.createLottoAutomatically();
        assertAll(
                () -> assertThatThrownBy(() -> lotto.getLottoNumbers().add(2))
                        .isInstanceOf(UnsupportedOperationException.class),
                () -> assertThatThrownBy(() -> lotto.getLottoNumbers().set(0, 3))
                        .isInstanceOf(UnsupportedOperationException.class)
        );
    }
}
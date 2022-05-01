package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoFactoryTest {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    @DisplayName("생성된 로또의 숫자 범위는 1과 45 사이이다.")
    @Test
    void 로또_자동_생성_숫자_범위_테스트() {
        Lotto lotto = LottoFactory.createLottoAutomatically();
        System.out.println(lotto.toString());
        for (LottoNumber number : lotto.getLottoNumbers()) {
            assertThat(number.getLottoNumber() >= MIN_LOTTO_NUMBER && number.getLottoNumber() <= MAX_LOTTO_NUMBER).isTrue();
        }
    }

    @DisplayName("생성된 로또는 값을 추가하거나 변화시킬 수 없다.")
    @Test
    void 로또_생성_불변_테스트() {
        Lotto lotto = LottoFactory.createLottoAutomatically();
        assertThatThrownBy(() -> lotto.getLottoNumbers().add(new LottoNumber(2)))
                        .isInstanceOf(UnsupportedOperationException.class);
    }
}
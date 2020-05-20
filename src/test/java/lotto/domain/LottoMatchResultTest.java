package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMatchResultTest {

    @DisplayName("당첨 로또 번호나 구입 로또번호가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateIfWinLottoNumbersOrLottoNumbersIsNull() {
        assertThatThrownBy(() -> LottoMatchResult.newInstance(null, null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoMatchResult.newInstance(LottoNumbersFactory.createLottoNumbers(), null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoMatchResult.newInstance(null, Arrays.asList(LottoNumbersFactory.createLottoNumbers())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 로또번호 장수가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateIfLottoNumbersSizeIs0() {
        assertThatThrownBy(() -> LottoMatchResult.newInstance(LottoNumbersFactory.createLottoNumbers(), new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호나 구입 로또번호가 존재하면 생성할 수 있다.")
    @Test
    void canCreateLottoMatchResult() {
        LottoMatchResult lottoMatchResult = LottoMatchResult.newInstance(LottoNumbersFactory.createLottoNumbers()
                , Arrays.asList(LottoNumbersFactory.createLottoNumbers()));
        assertThat(lottoMatchResult).isNotNull();
    }

}

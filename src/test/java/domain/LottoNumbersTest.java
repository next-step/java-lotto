package domain;

import data.Messages;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {

    LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void 갯수_에러() {
        assertThatThrownBy(() -> new LottoNumbers(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.NUMBER_OF_NUMBERS_ERROR);
    }

    @Test
    void 같은_객체_여부_확인(){
        assertThat(lottoNumbers.getLottoNumbers().get(0) == new LottoNumbers(List.of(1,2,3,4,5,6)).getLottoNumbers().get(0)).isTrue();
    }

    @Test
    void auto_숫자_갯수_확인(){
        assertThat(new LottoNumbers().getLottoNumbers()).hasSize(6);
    }

    @Test
    void getLottoNumber() {
        assertThat(lottoNumbers.getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void getHitCount() {
        assertThat(lottoNumbers.getHitCount(List.of(1, 2, 3, 4, 8, 7))).isEqualTo(4);
    }

    @Test
    void hasBonusNumber() {
        assertThat(lottoNumbers.hasBonusNumber(6)).isTrue();
    }

    @Test
    void hasNoBonusNumber() {
        assertThat(lottoNumbers.hasBonusNumber(7)).isFalse();
    }
}
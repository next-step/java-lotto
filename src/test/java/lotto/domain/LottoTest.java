package lotto.domain;

import lotto.exception.LottoApplicationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("생성자 테스트: LottoNumbers의 size가 6보다 작으면 LottoApplicationException 발생")
    void create() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        ));

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(LottoApplicationException.class);
    }

    @Test
    @DisplayName("생성자 테스트: LottoNumbers의 size가 6보다 크면 LottoApplicationException 발생")
    void create2() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7)
        ));

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(LottoApplicationException.class);
    }

}

package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void generateLottoTest() {
        assertThat(
                new Lotto().getLottoNumbers()
        );
    }

    @Test
    @DisplayName("로또번호 생성시 이미 있는 번호 테스트")
    void isNumberExistTest() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)
        );
        Lotto lotto = new Lotto(lottoNumbers);

        assertAll(
                () -> assertThat(lotto.isExistNumber(new LottoNumber(1))).isTrue(),
                () -> assertThat(lotto.isExistNumber(new LottoNumber(5))).isTrue(),
                () -> assertThat(lotto.isExistNumber(new LottoNumber(8))).isFalse(),
                () -> assertThat(lotto.isExistNumber(new LottoNumber(10))).isFalse()
        );
    }
}

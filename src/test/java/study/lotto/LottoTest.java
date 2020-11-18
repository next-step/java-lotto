package study.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;
import study.lotto.core.LottoStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    public void init() {
        this.lottoNumbers = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
    }

    @Test
    void test_create_success() {
        // Given & When
        Lotto lotto = new Lotto(lottoNumbers);

        // Then
        assertThat(lotto.contains(new LottoNumber(1))).isTrue();
        assertThat(lotto.contains(new LottoNumber(2))).isTrue();
        assertThat(lotto.contains(new LottoNumber(3))).isTrue();
        assertThat(lotto.contains(new LottoNumber(4))).isTrue();
        assertThat(lotto.contains(new LottoNumber(5))).isTrue();
        assertThat(lotto.contains(new LottoNumber(6))).isTrue();
    }

    @Test
    void test_create_fail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // Given
                    List<LottoNumber> lottoNumbers = new ArrayList<>();
                    lottoNumbers.add(new LottoNumber(1));

                    // When
                    Lotto lotto = new Lotto(lottoNumbers);
                }).withMessageMatching("로또 번호는 6개를 입력해주세요.");
    }

}
package study.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    private Set<LottoNumber> lottoNumbers;

    @BeforeEach
    public void init() {
        this.lottoNumbers = new HashSet<>(Arrays.asList(LottoNumber.of(1)
                , LottoNumber.of(2)
                , LottoNumber.of(3)
                , LottoNumber.of(4)
                , LottoNumber.of(5)
                , LottoNumber.of(6)));
    }

    @Test
    void test_create_success() {
        // Given & When
        Lotto lotto = new Lotto(lottoNumbers);

        // Then
        assertThat(lotto.contains(LottoNumber.of(1))).isTrue();
        assertThat(lotto.contains(LottoNumber.of(2))).isTrue();
        assertThat(lotto.contains(LottoNumber.of(3))).isTrue();
        assertThat(lotto.contains(LottoNumber.of(4))).isTrue();
        assertThat(lotto.contains(LottoNumber.of(5))).isTrue();
        assertThat(lotto.contains(LottoNumber.of(6))).isTrue();
    }

    @Test
    void test_create_fail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // Given
                    Set<LottoNumber> lottoNumbers = new HashSet<>();
                    lottoNumbers.add(LottoNumber.of(1));

                    // When
                    Lotto lotto = new Lotto(lottoNumbers);
                }).withMessageMatching("로또 번호는 6개를 입력해주세요.");
    }

}
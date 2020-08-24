package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {
    private Lotto lotto;
    private final Set<LottoNumber> lottoNumbers = new TreeSet<>();

    @BeforeEach
    void setUp() {
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(9));
        lottoNumbers.add(new LottoNumber(11));
        lottoNumbers.add(new LottoNumber(24));
        lottoNumbers.add(new LottoNumber(33));
        lottoNumbers.add(new LottoNumber(41));
        lotto = Lotto.of(lottoNumbers);
    }

    @DisplayName("로또 번호의 갯수 예외처리 테스트")
    @Test
    void notValidRangeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @DisplayName("로또 숫자 포함여부 테스트")
    @Test
    void increaseCountTest() {
        assertThat(lotto.hasNumber(LottoNumber.of(3))).isTrue();
        assertThat(lotto.hasNumber(LottoNumber.of(4))).isFalse();
    }

    @DisplayName("로또 숫자 매칭 테스트")
    @Test
    void matchNumberTest() {
        Lotto target = Lotto.of(Arrays.asList(3, 9, 11, 24, 33, 41));
        assertThat(lotto.matchNumber(target)).isEqualTo(6);
    }
}
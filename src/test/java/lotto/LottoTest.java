package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    private List<LottoNumber> userLottoNumbers;
    private List<LottoNumber> invalidCountLottoNumbers;

    @BeforeEach
    void setUp() {
        userLottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));

        invalidCountLottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(5)
        );
    }

    @Test
    void create() {
        assertThat(new Lotto(userLottoNumbers)).isEqualTo(new Lotto(userLottoNumbers));
    }

    @Test
    @DisplayName("로또 1개의 집합은 중복 없이 6개의 숫자로 이루어져 있어야 합니다.")
    void invalidLottoSet() {
        assertThatThrownBy(() -> new Lotto(invalidCountLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
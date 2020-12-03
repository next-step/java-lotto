package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void init() {
        lottoNumbers.add(LottoNumber.of(1));
        lottoNumbers.add(LottoNumber.of(2));
        lottoNumbers.add(LottoNumber.of(3));
        lottoNumbers.add(LottoNumber.of(4));
        lottoNumbers.add(LottoNumber.of(5));
    }

    @Test
    void invalid_사이즈_체크() {
        assertThatThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalid_번호중복체크() {
        lottoNumbers.add(LottoNumber.of(5));
        assertThatThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

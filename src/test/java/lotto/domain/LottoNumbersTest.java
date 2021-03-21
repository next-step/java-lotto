package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers();
    }

    @Test
    void 로또_기본번호_생성() {
        assertThat(lottoNumbers.size())
                .isEqualTo(45);
    }

    @Test
    void 로또_6개_번호_생성() {
        assertThat(lottoNumbers.lottoNumbers()
                .size())
                .isEqualTo(LottoNumbers.LOTTO_NUMBER_COUNT);
    }

    @Test
    void 로또_기본번호_섞기() {
        assertThat(new LottoNumbers().lottoNumbers()
                .toString()
                .equals(lottoNumbers.numbers().toString()))
                .isEqualTo(false);
    }
}

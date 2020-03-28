package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {

    @BeforeEach
    void setUp() {

    }

    @DisplayName("로또 복권은 6개의 숫자를 가진다.")
    @Test
    void create() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6)
        );
        Lottery expect = new Lottery(lottoNumbers);

        Lottery actual = new Lottery(lottoNumbers);

        assertThat(actual).isEqualTo(expect);
    }
}
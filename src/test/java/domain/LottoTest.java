package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void create() {
        //given
        LottoNumbers lottoNumbers = TestObjectSupport.createLottoNumbers();

        //when
        Lotto result = new Lotto(lottoNumbers);

        //then
        assertThat(result).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    void countMatch() {
        //given
        LottoNumbers lottoNumbers = TestObjectSupport.createLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);

        //when
        int result = lotto.countMatch(lottoNumbers);

        //then
        assertThat(result).isEqualTo(LottoNumbers.LOTTO_NUMBER_COUNT);
    }

    @Test
    void isMatch() {
        //given
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(7);
        Lotto lotto = TestObjectSupport.createLotto();

        //when
        boolean result1 = lotto.isMatch(lottoNumber1);
        boolean result2 = lotto.isMatch(lottoNumber2);

        //then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }
}

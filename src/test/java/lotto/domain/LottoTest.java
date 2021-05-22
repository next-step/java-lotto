package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @DisplayName("서로다른 로또번호 6개 주입시 size()가 6개로 리턴하는지")
    @Test
    void different_lotto_numbers() {
        //given
        int expected = 6;

        //when
        Lotto lottoNumbers = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));

        //then
        assertThat(lottoNumbers.size()).isEqualTo(expected);
    }

    @DisplayName("중복된 로또번호 6개 주입시 Exception 발생하는지")
    @Test
    void equals_lotto_numbers_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(2),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        )));
    }

    @DisplayName("로또번호 6개 미만으로 주입시 Exception 발생하는지")
    @Test
    void lotto_number_less_than_6_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5)
        )));
    }

    @DisplayName("로또번호 갯수가 일치하는지")
    @Test
    void match_count(){
        //given
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));
        Lotto toCompareLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(7), new LottoNumber(8)
        ));
        int expected = 4;

        //when
        int matchCount = lotto.matchCount(toCompareLotto);

        //then
        assertThat(matchCount).isEqualTo(expected);
    }
}

package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PrizeLottoTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = Arrays.asList(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        );
    }

    @Test
    void 보너스_매치_여부() {
        PrizeLotto prizeLotto = new PrizeLotto("1,2,3,4,5,6", "7");
        assertThat(prizeLotto.matchBonusNumber(new Lotto("1,2,3,4,5,7"))).isTrue();
    }

    @Test
    void 번호_매치_여부() {
        PrizeLotto prizeLotto = new PrizeLotto("1,2,3,4,5,6", "7");
        assertThat(prizeLotto.matchNumber(LottoNumber.from("6"))).isTrue();
    }

    @Test
    void 로또_비교() {
        PrizeLotto prizeLotto = new PrizeLotto("1,2,3,4,5,6", "7");
        assertThat(prizeLotto.getLotto()).isEqualTo(lottoNumbers);
    }

    @Test
    void 보너스_번호와_동일한_로또_존재_IllegalArgumentException() {
        assertThatThrownBy(() ->{
            new PrizeLotto("1,2,3,4,5,6", "6");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
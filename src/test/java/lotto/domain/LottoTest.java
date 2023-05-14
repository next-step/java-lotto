package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    private Lotto lotto = new Lotto("1,2,3,7,8,9");

    @Test
    void 지난주당첨번호_String_to_Lotto() {
        String inputLottoNumber = "2, 1, 3, 4, 5, 6";
        assertThat(new Lotto(inputLottoNumber).getLottoToString())
                .isEqualTo("1,2,3,4,5,6");
    }

    @Test
    void 지난주당첨번호_Lotto_일치개수조회() {
        Lotto winLotto = new Lotto("1,2,3,4,5,6");
        assertThat(lotto.getNumberOfMatch(winLotto)).isEqualTo(3);
    }

    @Test
    void 지난주보너스번호_Lotto_일치여부() {
        assertThat(lotto.isMatchNumber(new Number(7))).isTrue();
        assertThat(lotto.isMatchNumber(new Number(10))).isFalse();
    }
}
package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    void 지난주당첨번호_String_to_Lotto() {
        String inputLottoNumber = "1, 2, 3, 4, 5, 6";
        assertThat(new Lotto(inputLottoNumber).getLottoToString())
                .isEqualTo("1,2,3,4,5,6");
    }

    @Test
    void 지난주당첨번호_Lotto_일치개수조회() {
        Lotto winLotto = new Lotto("1,2,3,4,5,6");
        Lotto lotto = new Lotto("1,2,3,7,8,9");

        assertThat(lotto.getNumberOfMatch(winLotto)).isEqualTo(3);
    }
}
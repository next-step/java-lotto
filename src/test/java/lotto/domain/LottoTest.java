package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    private Lotto lotto = Lotto.createManualLotto("1,2,3,7,8,9");

    @Test
    void 지난주당첨번호_String_to_Lotto() {
        String inputLottoNumber = "2, 1, 3, 4, 5, 6";
        assertThat(Lotto.createManualLotto(inputLottoNumber).getLottoToString())
                .isEqualTo("1,2,3,4,5,6");
    }

    @Test
    void 지난주당첨번호_Lotto_일치개수조회() {
        Lotto winLotto = Lotto.createManualLotto("1,2,3,4,5,6");
        assertThat(lotto.getNumberOfMatch(winLotto)).isEqualTo(3);
    }

    @Test
    void 지난주보너스번호_Lotto_일치여부() {
        assertThat(lotto.isMatchNumber(Number.from(7))).isTrue();
        assertThat(lotto.isMatchNumber(Number.from(10))).isFalse();
    }

    @Test
    void test() {
        Lotto autoLotto1 = Lotto.createAutoLotto();
        Lotto autoLotto2 = Lotto.createAutoLotto();

        System.out.println(autoLotto1.getLottoToString());
        System.out.println(autoLotto2.getLottoToString());
    }
}
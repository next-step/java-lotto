package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setup() {
        lotto = new Lotto();
    }

    @Test
    void createLotto() {
        Lotto lotto = this.lotto.createLotto();
        assertThat(lotto.numberOfLottoCount()).isEqualTo( 6);
    }

    @Test
    void toStringLotto() {
        Lotto lotto = new Lotto().selectedNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> lottoNumber = lotto.showLottoNumber();
        assertAll(
            ()-> assertThat(lottoNumber.get(0)).isEqualTo(1),
            ()-> assertThat(lottoNumber.get(1)).isEqualTo(2),
            ()-> assertThat(lottoNumber.get(2)).isEqualTo(3),
            ()-> assertThat(lottoNumber.get(3)).isEqualTo(4),
            ()-> assertThat(lottoNumber.get(4)).isEqualTo(5),
            ()-> assertThat(lottoNumber.get(5)).isEqualTo(6)
        );


    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void checkLastWinningNumber(String lastWinnerNumber){
        lotto.selectedNumber(Arrays.asList(1,2,3,8,9,10));
        int matchNumber = lotto.checkLastWinningNumber(lastWinnerNumber);
        assertThat(matchNumber).isEqualTo(3);
    }

    @Test
    void checkBonusNumber_True( ) {
        BonusNumber bonusNumber = new BonusNumber(10);
        lotto.selectedNumber(Arrays.asList(1,2,3,4,5,10));
        boolean bonusNumberIsExist = lotto.checkBonusNumber(bonusNumber);
        assertThat(bonusNumberIsExist).isEqualTo(true);
    }

    @Test
    void checkBonusNumber_False( ) {
        BonusNumber bonusNumber = new BonusNumber(22);
        lotto.selectedNumber(Arrays.asList(1,2,3,4,5,10));
        boolean bonusNumberIsExist = lotto.checkBonusNumber(bonusNumber);
        assertThat(bonusNumberIsExist).isEqualTo(false);
    }
}
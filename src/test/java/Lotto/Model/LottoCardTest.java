package Lotto.Model;

import Lotto.Exception.InvalidBonusForLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoCardTest {
    @Test
    @DisplayName("등수가 제대로 나오는지 확인")
    void getMatchCount() {
        LottoCard lottoCard = new LottoCard(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoCard.matchPrize(new LottoCard(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 10, 6))), 5);

        assertThat(lottoCard.getPrize()).isEqualTo(Prize.SECOND);
    }

    @RepeatedTest(1000)
    @DisplayName("모든 숫자가 1~45인지 확인")
    void getLottoList() {
        LottoCard lottoCard = new LottoCard();
        lottoCard.getLotto().forEach(number -> assertThat(number).isBetween(1,45));
    }

    @Test
    @DisplayName("숫자가 1~45사이가 아닐때 오류발생")
    void isNotBetween() {
        assertThatThrownBy(() -> {
            LottoCard lottoCard = new LottoCard(new ArrayList<>(Arrays.asList(0, 2, 3, 4, 5, 6)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 갯수가 6개가 아닐때 오류발생")
    void isNotSix() {
        assertThatThrownBy(() -> {
            LottoCard lottoCard = new LottoCard(new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스볼이 범위밖일때 오류 발생")
    void bonusIsNotBetween() {
        LottoCard lottoCard = new LottoCard(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThatThrownBy(() -> {
            lottoCard.matchPrize(new LottoCard(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 10, 6))), 0);
        }).isInstanceOf(InvalidBonusForLottoException.class);
    }

}
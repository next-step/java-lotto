package Lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoCardTest {

    @Test
    @DisplayName("당첨로또와 맞는 개수가 제대로 나오는지 확인")
    void getMatchCount() {
        LottoCard lottoCard = new LottoCard(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(lottoCard.getMatchCount(new LottoCard(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))))).isEqualTo(6);
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
}
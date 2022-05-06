package Lotto.Model;

import Lotto.Exception.InvalidMoneyForLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoGameTest {

    @Test
    @DisplayName("생성 확인")
    void getLottoList() {
        LottoGame lottoGame = new LottoGame(10000);
        assertThat(lottoGame.getLottoList().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("수익률이 맞는지 확인")
    void getWinningRate() {
        List<LottoCard> lottoCardList = new ArrayList<>();
        LottoCard lottoCard = new LottoCard(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoCardList.add(lottoCard);

        LottoGame lottoGame = new LottoGame(lottoCardList);
        lottoGame.calculate(new LottoCard(new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9))),0);

        assertThat(lottoGame.getWinningRate()).isEqualTo(5);
    }

    @Test
    @DisplayName("1000원 단위가 아닐때 오류 발생")
    void isNotPerThousand() {
        assertThatThrownBy(() -> {
            LottoGame lottoGame = new LottoGame(10001);
        }).isInstanceOf(InvalidMoneyForLottoException.class);
    }
}
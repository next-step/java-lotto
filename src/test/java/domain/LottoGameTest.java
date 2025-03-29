package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGameTest {

    @Test
    @DisplayName("객체 정상 생성 확인")
    void getLottos() {
        assertThat(new LottoGame()).isNotEqualTo(null);
    }

    @Test
    @DisplayName("Buy 메소드 검증")
    void buy() {
        LottoGame lottoGame = new LottoGame();
        assertThat(lottoGame).isEqualTo(lottoGame.buy(5));
        assertThat(lottoGame.getLottos().getLottos().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("Summary Key 확인")
    void getSummary() {
        List<PrizeEnum> prizeEnums = new ArrayList<>(new LottoGame()
                .buy(100)
                .getSummary(List.of(1, 2, 3, 4, 5, 6), 7)
                .keySet());
        if(prizeEnums.size() != 0){
            assertThat(prizeEnums).containsAnyOf(PrizeEnum.values());
        }
    }
}
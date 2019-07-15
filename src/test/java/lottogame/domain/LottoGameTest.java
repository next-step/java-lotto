package lottogame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoGameTest {
    private final static int TIME_OF_GAME = 3;
    private final static int FIRST_ELEMENT_INDEX = 0;
    private final static int SECOND_ELEMENT_INDEX = 1;

    private LottoGame lottoGame;
    private int priceEx1 = 2000;
    private int priceEx2 = 5000;
    private LottoPrice lottoPrice;
    private List<LottoNumber> lottoManual;
    LottoNumber dummy;

    @BeforeEach
    void setup() {
        lottoPrice = new LottoPrice(priceEx2);
        lottoManual = new ArrayList<>();
    }

    @Test
    void  수동로또_갯수_확인() {
        for (int i = 0; i < TIME_OF_GAME; ++i) {
            dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
            lottoManual.add(dummy);
        }

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lottoGame = new LottoGame(priceEx1, lottoManual);
                }).withMessage("수동로또 구매 수량이 구매가격을 초과하였습니다.");
    }

    @Test
    void 자동로또_갯수_확인() {
        dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoManual.add(dummy);
        LottoGame lottoGame = new LottoGame(priceEx2, lottoManual);
        assertThat(lottoGame.getLotto().size() - lottoManual.size()).isEqualTo(4);
    }

    @Test
    void 수동로또_정상_생성여부_확인() {
        dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoManual.add(dummy);
        dummy = new LottoNumber(Arrays.asList(23, 45, 30, 10, 9, 15));
        lottoManual.add(dummy);

        LottoGame lottoGame = new LottoGame(priceEx2, lottoManual);
        assertThat(lottoGame.getLotto().get(FIRST_ELEMENT_INDEX).getElement().equals(lottoManual.get(FIRST_ELEMENT_INDEX).getElement())).isTrue();
        assertThat(lottoGame.getLotto().get(SECOND_ELEMENT_INDEX).getElement().equals(lottoManual.get(SECOND_ELEMENT_INDEX).getElement())).isTrue();
    }
}

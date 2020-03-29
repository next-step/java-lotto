package lotto;

import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.WinningType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoShopTest {
    private static final int PRICE_PER_PIECE = 1000;

    private LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        lottoShop = new LottoShop();
    }

    @DisplayName("구입 금액에 맞게 로또 생성")
    @ParameterizedTest
    @ValueSource(ints = {10000})
    void createLotto(int price) {
        LottoBundle lottos = lottoShop.buyAuto(price);

        assertThat(lottos.size()).isEqualTo(Math.floorDiv(price, PRICE_PER_PIECE));
    }

    @DisplayName("로또 당첨 조회")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void lottery(String winningNumber) {
        LottoResult lottoResult = lottoShop.checkWinning(Fixture.lottoBundle(), winningNumber);
        List<WinningType> actual = lottoResult.getWinningTypes();

        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual).isNotEmpty(),
                () -> assertThat(actual.get(0)).isEqualTo(WinningType.SIX_MATCH)
        );
    }
}
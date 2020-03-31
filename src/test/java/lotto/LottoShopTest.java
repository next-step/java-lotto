package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.WinningType;
import lotto.dto.LottoRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoShopTest {
    private static final int BONUS_NUMBER = 10;
    private static final int PRICE_PER_PIECE = 1000;

    private LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        lottoShop = new LottoShop();
    }

    @DisplayName("구입 금액에 맞게 로또 생성")
    @ParameterizedTest
    @ValueSource(ints = {10000})
    void buyAuto(int price) {
        LottoBundle lottos = lottoShop.buyAuto(Math.floorDiv(price, PRICE_PER_PIECE));

        assertThat(lottos.size()).isEqualTo(Math.floorDiv(price, PRICE_PER_PIECE));
    }

    @DisplayName("로또 당첨 조회")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void lottery(String winningNumber) {
        Lotto lotto = Lotto.manual(winningNumber);
        lottoShop = new LottoShop(new LottoBundle(Arrays.asList(lotto)));

        LottoResult lottoResult = lottoShop.checkWinning(new LottoRequestDto(winningNumber, BONUS_NUMBER));
        List<WinningType> actual = lottoResult.getWinningTypes();

        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual).isNotEmpty(),
                () -> assertThat(actual.get(0)).isEqualTo(WinningType.SIX_MATCH)
        );
    }

    @DisplayName("로또 수동 구입 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "7,28,30,1,11,12", "14,13,1,8,6,44"})
    void buyManual(String lottoString) {
        List<String> lottoStrings = Arrays.asList(lottoString);
        LottoBundle lottos = lottoShop.buyManual(lottoStrings);

        assertAll(
                () -> assertThat(lottos.size()).isEqualTo(lottoStrings.size()),
                () -> assertThat(lottos.getLottos()).containsExactly(Lotto.manual(lottoString))
        );
    }

    @DisplayName("로또 구입 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10000:1:1,2,3,4,5,6"}, delimiter = ':')
    void buyLotto(int amount, int manualCount, String lottoString) {
        List<String> lottoStrings = Arrays.asList(lottoString);
        lottoShop.buyLotto(new LottoRequestDto(amount, manualCount, lottoStrings));
        LottoBundle lottoBundle = lottoShop.getLottoBundle();
        assertAll(
                () -> assertThat(lottoBundle.size()).isEqualTo(amount / PRICE_PER_PIECE),
                () -> assertThat(lottoBundle.getLottos()).contains(Lotto.manual(lottoString))
        );
    }
}
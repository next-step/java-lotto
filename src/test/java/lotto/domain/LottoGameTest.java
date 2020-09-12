package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameTest {
    private LottoGame lottoGame;
    private int manualCount;

    @BeforeEach
    void setUp() {
        int amount = 4500;
        manualCount = 3;
        lottoGame = LottoGame.of(amount, manualCount);
    }

    @DisplayName("로또 구입 금액 유효성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {900})
    void invalidPurchaseAmount(int amount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoGame.of(amount, manualCount))
                .withMessage("로또 구입 금액이 부족합니다.");
    }

    @DisplayName("로또 개수 테스트")
    @Test
    void getLottoManualCountByPurchaseAmount() {
        int countOfLottos = manualCount + 1;
        assertThat(lottoGame.getCount()).isEqualTo(countOfLottos);
    }

    @DisplayName("로또 생성 테스트")
    @Test
    void makeLottos() {
        List<String> manualLottos = Stream.of(
                "8, 21, 23, 41, 42, 43",
                "3, 5, 11, 16, 32, 38",
                "7, 11, 16, 35, 36, 44")
                .collect(Collectors.toList());

        Lottos lottos = lottoGame.makeLottos(manualLottos);
        assertThat(lottos.size()).isEqualTo(4);
    }
}

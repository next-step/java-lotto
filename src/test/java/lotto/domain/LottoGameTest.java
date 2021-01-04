package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameTest {
    @Test
    void create() {
        LottoGame lottoGame = new LottoGame();
    }

    @ParameterizedTest
    @DisplayName("로또는 1000원 구매 단위 아닐 경우 예외")
    @ValueSource(strings = {"1500", "500", "100", "0", "21235", "2222"})
    void validPurchasinfUnit(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoCount(input);
        })
                .withMessageContaining("로또 구매 단위는 1000원입니다.");
    }

    @ParameterizedTest
    @DisplayName("로또 구매 금액 숫자 아닌 경우 예외 발생")
    @ValueSource(strings = {"1234원", "$12345", "1만원"})
    void validNumber(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoCount(input);
        })
                .withMessageContaining("금액은 숫자만 입력해주세요.");
    }

    @ParameterizedTest
    @DisplayName("구매 금액 입력값 없을 경우 예외 발생")
    @NullAndEmptySource
    void validNullOrEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoCount(input);
        })
                .withMessageContaining("금액을 다시 입력해주세요");
    }

    @Test
    void start() {
        LottoGame lottoGame = new LottoGame();
        lottoGame.start(new LottoCount("5000"));
        LottoResult lottoResult = lottoGame.getLottoResult();
        System.out.println(lottoResult.getLottosView());
    }

    @Test
    void match() {
        LottoGame lottoGame = new LottoGame();
        lottoGame.start(new LottoCount("15000"));
        LottoResult lottoResult = lottoGame.getLottoResult();
        System.out.println(lottoResult.getLottosView());
        List<MatchResult> matchResults = lottoGame.match(new WinningLotto("1,2,3,4,5,6", "7"));

        System.out.println(lottoResult.getStatisticsView(matchResults));
    }
}

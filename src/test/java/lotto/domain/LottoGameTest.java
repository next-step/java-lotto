package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        PurchaseAmount purchaseAmount = PurchaseAmount.newInstance(5000);

        List<String> numbers = Arrays.asList(
                "1, 2, 3, 13, 14, 15",
                "1, 2, 3, 4, 14, 15",
                "1, 2, 3, 4, 5, 15",
                "1, 2, 3, 4, 5, 7",
                "1, 2, 3, 4, 5, 6"
        );
        ManualNumbers manualNumbers = ManualNumbers.newInstance(numbers);

        this.lottoGame = new LottoGame(purchaseAmount, manualNumbers);
    }

    @DisplayName("구입금액이 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLottoGameIfPurchaseAmountIsNull() {
        assertThatThrownBy(() -> new LottoGame(null, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 번호가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLottoGameIfManualNumbersIsNull() {
        assertThatThrownBy(() -> new LottoGame(PurchaseAmount.newInstance(1000), null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 번호 수가 구매 개수보다 많으면 생성할 수 없다.")
    @Test
    void canNotCreateLottoGameIfManualNumbersCountGreaterThanPurchaseCount() {
        assertThatThrownBy(() -> {
            List<String> manual = Arrays.asList("1, 2, 3, 13, 14, 15",
                    "1, 2, 3, 4, 14, 15");
            ManualNumbers manualNumbers = ManualNumbers.newInstance(manual);

            new LottoGame(PurchaseAmount.newInstance(1000), manualNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LottoGame을 생성할 수 있다.")
    @Test
    void canCreateLottoGame() {
        assertThat(this.lottoGame).isInstanceOf(LottoGame.class);
    }

    @DisplayName("로또 번호를 생성할 수 있다.")
    @Test
    void canCreateLottoNumbers() {
        LottoNumbers lottoNumbers = this.lottoGame.createLottoNumbers();

        assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class);
        assertThat(lottoNumbers.getCountByCreationType(CreationType.MANUAL)).isEqualTo(5);
    }

    @DisplayName("로또 당첨 결과를 얻을 수 있다.")
    @Test
    void canCreateLottoMatchResult() {
        LottoNumber winLottoNumber = LottoNumber.newInstance(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.newInstance(7, winLottoNumber);
        LottoMatchResult lottoMatchResult = this.lottoGame.calculateMatchCount(winLottoNumber, bonusNumber);

        assertThat(lottoMatchResult).isInstanceOf(LottoMatchResult.class);
    }
}

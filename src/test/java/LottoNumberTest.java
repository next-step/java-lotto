import lotto.domain.LottoAvailableNumber;
import lotto.domain.LottoMatchInfo;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.strategy.ManualLottoNumberGenerateStrategy;
import lotto.domain.strategy.RandomLottoNumberGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 테스트")
public class LottoNumberTest {
    private static final LottoAvailableNumber BONUS_NUMBER_45 = new LottoAvailableNumber(45);
    private static final List<LottoNumber> NO_MANUAL_LOTTO_NUMBERS = new ArrayList<>();
    private static final RandomLottoNumberGenerateStrategy RANDOM_LOTTO_NUMBER_GENERATE_STRATEGY = new RandomLottoNumberGenerateStrategy();
    private static final List<LottoAvailableNumber> NUMBERS_1_TO_6 = IntStream.rangeClosed(1, 6)
            .mapToObj(LottoAvailableNumber::new)
            .collect(Collectors.toList());
    private static final List<LottoAvailableNumber> NUMBERS_7_TO_12 = IntStream.rangeClosed(7, 12)
            .mapToObj(LottoAvailableNumber::new)
            .collect(Collectors.toList());


    @Test
    @DisplayName("6개의 번호를 가진 랜덤 로또를 생성할 수 있다.")
    void generateSixLottoNumbers_test() {
        LottoNumber lottoNumber = new LottoNumber(RANDOM_LOTTO_NUMBER_GENERATE_STRATEGY);

        Assertions.assertThat(lottoNumber.getLottoNumbers()).hasSize(6);
    }

    @RepeatedTest(10)
    @DisplayName("매번 다른 번호를 가진 로또를 생성할 수 있다.")
    void generateRandomLottoNumbers_test() {
        LottoNumber lottoNumber1 = new LottoNumber(RANDOM_LOTTO_NUMBER_GENERATE_STRATEGY);
        LottoNumber lottoNumber2 = new LottoNumber(RANDOM_LOTTO_NUMBER_GENERATE_STRATEGY);

        Assertions.assertThat(lottoNumber1).isNotEqualTo(lottoNumber2);
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 정해진 사이값의 숫자가 아니라면 예외를 던진다.")
    @ValueSource(ints = {-1, 46})
    void validateLottoNumber_test(int lottoNumber) {
        assertThatThrownBy(() -> new LottoAvailableNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("당첨 번호의 입력값이 null이거나 빈 공백인 경우 예외를 던진다.")
    void validateWinningNumbersNullAndEmpty_test(String input) {
        assertThatThrownBy(() -> InputView.validateInputLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1% 2% 3% 4% 5% 6", "a, b, c, d, e, f"})
    @DisplayName("당첨번호의 입력값이 공백의 유무와 상관없이 콤마(,)와 숫자의 조합이 아니라면 예외를 던진다.")
    void validateNumberCommaExpression_test(String input) {
        assertThatThrownBy(() -> InputView.validateInputLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호의 입력값의 숫자가 6개가 아니라면 예외를 던진다.")
    void validateSixWinningNumber_test() {
        String input = "1, 2, 3, 4, 5, 6, 7";
        assertThatThrownBy(() -> InputView.validateInputLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에서 숫자만 분리할 수 있다.")
    void extractWinningNumbers_test() {
        String input = "1, 2, 3, 4, 5, 6";

        List<LottoAvailableNumber> extractNumbers = InputView.extractNumbers(input);

        Assertions.assertThat(extractNumbers)
                .containsExactlyInAnyOrderElementsOf(NUMBERS_1_TO_6);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 500})
    @DisplayName("금액이 부족하면 예외를 던진다.")
    void validatePurchaseAmount_test(int purchaseAmount) {
        assertThatThrownBy(() -> new LottoTicket(3, NO_MANUAL_LOTTO_NUMBERS, purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("당첨 번호와 일치하는 숫자에 따라 순위를 매길 수 있다.")
    void setRank_test(int matchCount) {
        Rank rank = Rank.valueOf(matchCount, false);

        Assertions.assertThat(matchCount).isEqualTo(rank.getCountOfMatch());
    }

    @Test
    @DisplayName("당첨 번호가 0~6개 안의 숫자에서 확인되는 지 확인할 수 있다.")
    void checkMatchingNumbers_test() {
        LottoNumber lottoNumber = new LottoNumber(RANDOM_LOTTO_NUMBER_GENERATE_STRATEGY);

        LottoMatchInfo matchInfo = LottoMatchInfo.countMatchingNumbers(lottoNumber, NUMBERS_1_TO_6, BONUS_NUMBER_45);

        Assertions.assertThat(matchInfo.getMatchCount()).isBetween(0, 6);
    }

    @Test
    @DisplayName("보너스 번호가 없을 때 수익률 계산이 동작하는지 확인할 수 있다.")
    void calculateReturnRate_test() {
        int purchaseAmount = 10_000;
        LottoTicket lottoTicket = new LottoTicket(10, NO_MANUAL_LOTTO_NUMBERS, purchaseAmount);

        LottoResult lottoResult = lottoTicket.calculateResult(NUMBERS_1_TO_6, BONUS_NUMBER_45);
        double returnRate = OutputView.calculateReturnRate(purchaseAmount, lottoResult);

        Assertions.assertThat(returnRate).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호에 포함되어 있을 때 예외를 던진다.")
    void validateBonusNumber_test() {
        int bonusNumber = 6;

        assertThatThrownBy(() -> InputView.validateBonusNumber(NUMBERS_1_TO_6, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 있을 때 수익률 계산이 동작하는지 확인할 수 있다.")
    void calculateWithBonusNumberReturnRate_test() {
        int purchaseAmount = 10_000;
        LottoTicket lottoTicket = new LottoTicket(10, NO_MANUAL_LOTTO_NUMBERS, purchaseAmount);
        LottoAvailableNumber bonusNumber = new LottoAvailableNumber(7);

        LottoResult lottoResult = lottoTicket.calculateResult(NUMBERS_1_TO_6, bonusNumber);
        double returnRate = OutputView.calculateReturnRate(purchaseAmount, lottoResult);

        Assertions.assertThat(returnRate).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 숫자와 보너스 번호 일치 여부를 확인할 수 있다.")
    void checkMatchingNumbersAndBonus_test() {
        LottoNumber lottoNumber = new LottoNumber(RANDOM_LOTTO_NUMBER_GENERATE_STRATEGY);
        LottoAvailableNumber bonusNumber = new LottoAvailableNumber(7);

        LottoMatchInfo lottoMatchInfo = LottoMatchInfo.countMatchingNumbers(lottoNumber, NUMBERS_1_TO_6, bonusNumber);

        Assertions.assertThat(lottoMatchInfo.getMatchCount()).isBetween(0, 6);
        Assertions.assertThat(lottoMatchInfo.isBonusMatch()).isIn(true, false);
    }

    @Test
    @DisplayName("로또를 수동으로 구매할 수 있다.")
    void purchaseManualLottoTicket_test() {
        int purchaseAmount = 2_000;
        List<LottoNumber> manualLottoNumbers = new ArrayList<>(Arrays.asList(
                new LottoNumber(new ManualLottoNumberGenerateStrategy(NUMBERS_1_TO_6)),
                new LottoNumber(new ManualLottoNumberGenerateStrategy(NUMBERS_7_TO_12))
        ));

        LottoTicket manualLottoTicket = new LottoTicket(0, manualLottoNumbers, purchaseAmount);

        Assertions.assertThat(manualLottoTicket.getTotalTicketCount())
                .isEqualTo(2);
    }

    @Test
    @DisplayName("수동으로 생성된 로또 번호가 올바른지 확인할 수 있다.")
    void checkManualLottoNumber_test() {
        List<LottoAvailableNumber> manualNumbers = new ArrayList<>();
        LottoNumber manualLottoNumber = new LottoNumber(new ManualLottoNumberGenerateStrategy(manualNumbers));

        Assertions.assertThat(manualLottoNumber.getLottoNumbers())
                .containsExactlyInAnyOrderElementsOf(manualNumbers);
    }

    @Test
    @DisplayName("수동과 자동 로또를 함께 구매할 수 있다.")
    void purchaseManualAndAutoLottoTickets_test() {
        int purchaseAmount = 3_000;
        List<LottoNumber> manualLottoNumbers = new ArrayList<>(Arrays.asList(
                new LottoNumber(new ManualLottoNumberGenerateStrategy(NUMBERS_1_TO_6)),
                new LottoNumber(new ManualLottoNumberGenerateStrategy(NUMBERS_7_TO_12))
        ));

        int autoTicketCount = 1;
        LottoTicket mixedLottoTicket = new LottoTicket(autoTicketCount, manualLottoNumbers, purchaseAmount);

        Assertions.assertThat(mixedLottoTicket.getTotalTicketCount())
                .isEqualTo(autoTicketCount + manualLottoNumbers.size());
    }

}

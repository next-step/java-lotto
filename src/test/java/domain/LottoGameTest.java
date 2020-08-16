package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {
    private LottoGame lottoGame;
    private LottoMoney lottoMoney;
    private LottoNumbers lottoWinningNumbers;

    @BeforeEach
    void setUp() {
        List<LottoNumbers> numbersList = new ArrayList<>();
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(8, 21, 23, 41, 42, 43))));
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(3, 5, 11, 16, 32, 38))));
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(7, 11, 16, 35, 36, 44))));
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(1, 8, 11, 31, 41, 42))));
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(13, 14, 16, 38, 42, 45))));
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(7, 11, 30, 40, 42, 43))));
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(2, 13, 22, 32, 38, 45))));
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(23, 25, 33, 36, 39, 41))));
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(1, 3, 5, 14, 22, 45))));
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(5, 9, 38, 41, 43, 44))));
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(2, 8, 9, 18, 19, 21))));
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(13, 14, 18, 21, 23, 35))));
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(17, 21, 29, 37, 42, 45))));
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(3, 8, 27, 30, 35, 44))));

        int money = 14000;
        lottoMoney = new LottoMoney(money);

        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoWinningNumbers = new LottoNumbers(makeNumbers(winningNumbers));

        lottoGame = new LottoGame(numbersList);
    }

    private Set<Number> makeNumbers(List<Integer> integers) {
        return new ArrayList<>(integers)
                .stream()
                .map(Number::new)
                .collect(Collectors.toSet());
    }

    @Test
    @DisplayName("구입 금액에 따라 LottoNumbers를 여러 개 생성한다.")
    void makeLottoNumberListTest() {
        assertThat(lottoGame.getLottoNumbersList().size()).isEqualTo(14);
    }

    @ParameterizedTest
    @CsvSource(value = {"6=0", "5=0", "4=0", "3=1"}, delimiter = '=')
    @DisplayName("당첨 번호에 따라 당첨 정보를 반환한다.")
    void lottoGamesTest(int countOfMatch, int expected) {
        Number bonusNumber = new Number(7);
        WinningInfos lottoWinningInfos = lottoGame.getWinningInfos(lottoWinningNumbers, bonusNumber);

        Rank expectedWinningType = Rank.valueOf(countOfMatch, false);
        lottoWinningInfos.getWinningInfos().stream()
                .filter(e -> e.getRank().equals(expectedWinningType))
                .forEach(e -> assertThat(e.getWinningNumber()).isEqualTo(expected));
    }

    @Test
    @DisplayName("당첨 정보에 따라 수익률을 반환한다.")
    void getBenefitRateTest() {
        Number notMatchBonusNumber = new Number(7);
        double benefitRate = lottoGame.getBenefitRate(lottoMoney, lottoGame.getWinningInfos(lottoWinningNumbers, notMatchBonusNumber));
        assertThat(benefitRate).isEqualTo(0.35);
    }

    @ParameterizedTest
    @ValueSource(ints = {10,11})
    @DisplayName("보너스 번호 테스트")
    void bonusNumberTest(int bonusNumberInput) {
        List<LottoNumbers> numbersList = new ArrayList<>();
        numbersList.add(new LottoNumbers(makeNumbers(Arrays.asList(1,2,3,4,5,10))));

        LottoGame lottoGame = new LottoGame(numbersList);

        Number bonusNumber = new Number(bonusNumberInput);

        WinningInfos winningInfos = lottoGame.getWinningInfos(lottoWinningNumbers, bonusNumber);

        BigDecimal expectedMoney = Rank.SECOND.getWinningMoney();
        if (bonusNumberInput == 11) {
            expectedMoney = Rank.THIRD.getWinningMoney();
        }

        assertThat(winningInfos.getTotalWinningMoney()).isEqualTo(expectedMoney);
    }
}
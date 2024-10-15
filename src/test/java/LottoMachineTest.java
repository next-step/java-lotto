import model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static model.Prize.PRIZE5_PLUS;

public class LottoMachineTest {
    @Test
    @DisplayName("lotto machine instantiation")
    void createLottoMachineTest() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int totalPrice = 2000;
        LottoNumberGenerate lottoNumberGenerate = new MockLottoNumberGeneratorImpl();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(lottoNumberGenerate);
        List<List<Integer>> lottoNumbers = lottoNumberGenerator.run(totalPrice / LottoMachine.PRICE_OF_A_LOTTO);

        //when
        LottoMachine lottoMachine = new LottoMachine(
                winningNumbers,
                totalPrice,
                lottoNumbers
        );

        //then
        Assertions.assertThat(lottoMachine.getLottos()).hasSize(2);
        Assertions.assertThat(lottoMachine.getLottos().stream().map(it -> it.getNumbers()).collect(Collectors.toList()))
                .hasSameElementsAs(lottoNumbers);
        Assertions.assertThat(lottoMachine.getWinningNumbers()).hasSameElementsAs(winningNumbers);
        Assertions.assertThat(lottoMachine.getTotalPrice()).isEqualTo(totalPrice);
        Assertions.assertThat(lottoMachine.getNumberOfLotto()).isEqualTo(2);
    }

    @Test
    @DisplayName("당첨통계")
    void createLottoMachineStatisticsTest() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int totalPrice = 2000;
        LottoNumberGenerate lottoNumberGenerate = new MockLottoNumberGeneratorImpl();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(lottoNumberGenerate);
        List<List<Integer>> lottoNumbers = lottoNumberGenerator.run(totalPrice / LottoMachine.PRICE_OF_A_LOTTO);

        //when
        LottoMachine lottoMachine = new LottoMachine(
                winningNumbers,
                totalPrice,
                lottoNumbers
        );

        //then
        Assertions.assertThat(lottoMachine.getLottos()).hasSize(2);
        Assertions.assertThat(lottoMachine.getLottos().stream().map(it -> it.getNumbers()).collect(Collectors.toList()))
                .hasSameElementsAs(lottoNumbers);
        Assertions.assertThat(lottoMachine.getWinningNumbers()).hasSameElementsAs(winningNumbers);
        Assertions.assertThat(lottoMachine.getTotalPrice()).isEqualTo(totalPrice);
        Assertions.assertThat(lottoMachine.getNumberOfLotto()).isEqualTo(2);

        LottoStatistics statistics = lottoMachine.getStatistics();
        Assertions.assertThat(statistics.getCountByPrize(Prize.PRIZE3)).isEqualTo(1);
        Assertions.assertThat(statistics.getCountByPrize(Prize.PRIZE4)).isEqualTo(0);
        Assertions.assertThat(statistics.getCountByPrize(Prize.PRIZE5)).isEqualTo(0);
        Assertions.assertThat(statistics.getCountByPrize(Prize.PRIZE5)).isEqualTo(0);
        Assertions.assertThat(statistics.getCountByPrize(Prize.PRIZE5_PLUS)).isEqualTo(0);
        Assertions.assertThat(statistics.getCountByPrize(Prize.PRIZE6)).isEqualTo(0);
        Assertions.assertThat(statistics.getNetIncome()).isEqualTo(2.5);
    }

    @Test
    @DisplayName("당첨통계 - 보너스 번호")
    void createLottoMachineStatisticsTest_WithBonusNumber() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int totalPrice = 1000;
        final Integer bonusNumber = 7;
        LottoNumberGenerate lottoNumberGenerate = new MockLottoNumberGeneratorImplFroBonusNumber();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(lottoNumberGenerate);
        List<List<Integer>> lottoNumbers = lottoNumberGenerator.run(totalPrice / LottoMachine.PRICE_OF_A_LOTTO);

        //when
        LottoMachine lottoMachine = new LottoMachine(
                winningNumbers,
                totalPrice,
                lottoNumbers,
                bonusNumber
        );

        //then
        Assertions.assertThat(lottoMachine.getLottos()).hasSize(1);
        Assertions.assertThat(lottoMachine.getLottos().stream().map(it -> it.getNumbers()).collect(Collectors.toList()))
                .hasSameElementsAs(lottoNumbers);
        Assertions.assertThat(lottoMachine.getWinningNumbers()).hasSameElementsAs(winningNumbers);
        Assertions.assertThat(lottoMachine.getTotalPrice()).isEqualTo(totalPrice);
        Assertions.assertThat(lottoMachine.getNumberOfLotto()).isEqualTo(1);

        LottoStatistics statistics = lottoMachine.getStatistics();
        Assertions.assertThat(statistics.getCountByPrize(Prize.PRIZE3)).isEqualTo(0);
        Assertions.assertThat(statistics.getCountByPrize(Prize.PRIZE4)).isEqualTo(0);
        Assertions.assertThat(statistics.getCountByPrize(Prize.PRIZE5)).isEqualTo(0);
        Assertions.assertThat(statistics.getCountByPrize(PRIZE5_PLUS)).isEqualTo(1);
        Assertions.assertThat(statistics.getCountByPrize(Prize.PRIZE6)).isEqualTo(0);
        Assertions.assertThat(statistics.getNetIncome()).isEqualTo((double) PRIZE5_PLUS.getPrice() / totalPrice);
    }
}

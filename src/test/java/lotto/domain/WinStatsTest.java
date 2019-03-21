package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class WinStatsTest {


  @Test
  public void test_totalWinMoney() {

    // Given
    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;
    int fourthMatchNumber = 36;
    int fifthMatchNumber = 40;
    int sixthMatchNumber = 19;

    List<Lotto> lottoList = Arrays.asList(
        LottoVendingMachineTest.generateLotto(
            5,
            firstMatchNumber,
            secondMatchNumber,
            42,
            thirdMatchNumber,
            31),
        LottoVendingMachineTest.generateLotto(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            1,
            14),
        LottoVendingMachineTest.generateLotto(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            fifthMatchNumber,
            45),
        LottoVendingMachineTest.generateLotto(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            fifthMatchNumber,
            sixthMatchNumber)
    );
    List<Number> winNumbers = new TestNumberGenerator(
        fifthMatchNumber,
        firstMatchNumber,
        secondMatchNumber,
        fourthMatchNumber,
        thirdMatchNumber,
        sixthMatchNumber).generate();

    // When
    WinStats winStats = new WinStats(lottoList, winNumbers);
    winStats.total();
    Money winMoney = winStats.getTotalWinMoney();

    // Then
    assertThat(winMoney).isEqualTo(new Money(5000 + 50000 + 1500000 + 2000000000));
  }

  @Test
  public void test_yield() {

    // Given
    Money purchaseMoney = new Money(14000);

    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;
    int fourthMatchNumber = 36;
    int fifthMatchNumber = 40;
    int sixthMatchNumber = 19;

    List<Lotto> lottoList = Arrays.asList(
        LottoVendingMachineTest.generateLotto(
            5,
            firstMatchNumber,
            secondMatchNumber,
            42,
            thirdMatchNumber,
            31),
        LottoVendingMachineTest.generateLotto(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            1,
            14),
        LottoVendingMachineTest.generateLotto(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            fifthMatchNumber,
            45),
        LottoVendingMachineTest.generateLotto(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            fifthMatchNumber,
            sixthMatchNumber)
    );
    List<Number> winNumbers = new TestNumberGenerator(
        fifthMatchNumber,
        firstMatchNumber,
        secondMatchNumber,
        fourthMatchNumber,
        thirdMatchNumber,
        sixthMatchNumber).generate();

    WinStats winStats = new WinStats(lottoList, winNumbers);
    winStats.total();

    // When
    String yield = winStats.yield(purchaseMoney);

    // Then
    assertThat(yield).isEqualTo("142968.20");
  }
}
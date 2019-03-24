package lotto.domain;

import static lotto.domain.LottoTest.intArrayToLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import org.junit.Test;

public class WinStatsTest {

  @Test
  public void test_totalReward() {

    // Given
    Money buyMoney = new Money(4000);

    Lotto lotto1 = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    Lotto lotto2 = new Lotto(intArrayToLottoNumbers(4, 30, 14, 32, 28, 19));
    Lotto lotto3 = new Lotto(intArrayToLottoNumbers(4, 15, 14, 32, 25, 19));
    Lotto lotto4 = new Lotto(intArrayToLottoNumbers(4, 42, 1, 15, 21, 19));
    MyLottos myLottos = new MyLottos(new Money(4000), Arrays.asList(lotto1, lotto2, lotto3, lotto4));

    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(19, 14, 28, 42, 32, 4);
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winLottoNumbers, additionNumber);

    WinStats winStats = new WinStats(buyMoney, myLottos.winResults(winNumbers));

    // When
    Money totalReward = winStats.totalReward();

    // Then
    assertThat(totalReward).isNotNull();
    assertThat(totalReward).isEqualTo(new Money(5_000 + 50_000 + 1_500_000 + 2_000_000_000));
  }

  @Test
  public void test_totalReward_sizMatch_one() {

    // Given
    Money buyMoney = new Money(1000);

    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    MyLottos myLottos = new MyLottos(buyMoney, Collections.singletonList(lotto));

    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(19, 14, 28, 42, 32, 4);
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winLottoNumbers, additionNumber);

    WinStats winStats = new WinStats(buyMoney, myLottos.winResults(winNumbers));

    // When
    Money totalReward = winStats.totalReward();

    // Then
    assertThat(totalReward).isNotNull();
    assertThat(totalReward).isEqualTo(new Money(2_000_000_000));
  }

  @Test
  public void test_totalReward_zero() {

    // Given
    Money buyMoney = new Money(1000);

    Lotto lotto = new Lotto(intArrayToLottoNumbers(2, 41, 13, 31, 26, 18));
    MyLottos myLottos = new MyLottos(buyMoney, Collections.singletonList(lotto));

    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(19, 14, 28, 42, 32, 4);
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winLottoNumbers, additionNumber);

    WinStats winStats = new WinStats(buyMoney, myLottos.winResults(winNumbers));

    // When
    Money totalReward = winStats.totalReward();

    // Then
    assertThat(totalReward).isNotNull();
    assertThat(totalReward).isEqualTo(new Money(0));
  }
}
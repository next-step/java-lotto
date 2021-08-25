package step2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.Lotto.Lotto;
import step2.model.Lotto.LottoNo;
import step2.model.Lotto.LottoNos;

public class LottoTest {

  @Test
  public void Lotto_1개_구매() {
    List<LottoNo> lottoNoList = new ArrayList<>();
    int[] lottoNums = {1, 2, 3, 4, 5, 6};

    for (int i = 0; i < lottoNums.length; i++) {
      lottoNoList.add(new LottoNo(lottoNums[i]));
    }

    LottoNos lottoNos = new LottoNos(lottoNoList);
    Lotto lotto = new Lotto(lottoNos);

    assertThat(lotto.getLottoNos()).isEqualToComparingFieldByField(lottoNos);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,5,6", "10,20,30,40,45"})
  public void Lotto_N개_구매(String lottoNumStr) {
    String[] lottoNumStrs = lottoNumStr.split(",");
    int[] lottoNums = Arrays.stream(lottoNumStrs).mapToInt(Integer::parseInt).toArray();

    List<LottoNo> lottoNoList = new ArrayList<>();
    for (int i = 0; i < lottoNums.length; i++) {
      lottoNoList.add(new LottoNo(lottoNums[i]));
    }

    LottoNos lottoNos = new LottoNos(lottoNoList);
    Lotto lotto = new Lotto(lottoNos);

    assertThat(lotto.getLottoNos()).isEqualToComparingFieldByField(lottoNos);
  }
}

package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoListTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:2,3,4,5,6,7:2"}, delimiter = ':')
    @DisplayName("로또 리스트를 하나로 합칠 수 있다")
    void generatedBallsAreInAscendingOrder(String lottoString1, String lottoString2, int expected) {
        NormalLotto lotto1 = new NormalLotto(lottoString1);
        NormalLotto lotto2 = new NormalLotto(lottoString2);

        List<NormalLotto> normalLottoList1 = new ArrayList<>();
        normalLottoList1.add(lotto1);
        List<NormalLotto> normalLottoList2 = new ArrayList<>();
        normalLottoList2.add(lotto2);

        LottoList lottoList1 = new LottoList(normalLottoList1);
        LottoList lottoList2 = new LottoList(normalLottoList2);

        LottoList mergedLottoList = new LottoList(lottoList1, lottoList2);
        assertThat(mergedLottoList.getLottos().size()).isEqualTo(expected);
    }

}

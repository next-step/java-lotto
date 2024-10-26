package refactoringlotto;

import org.junit.jupiter.api.Test;
import refactoringlotto.domain.AllRoundLottoNumbers;
import refactoringlotto.domain.LottoNumbers;
import refactoringlotto.random.LottoGenerator;
import refactoringlotto.testrandom.DefaultLottoList;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AllRoundLottoNumbersTest {

    @Test
    public void 로또번호_생성_테스트() {
        int tryCount = 1;
        LottoGenerator lottoGenerator = new DefaultLottoList();
        AllRoundLottoNumbers testAllRoundLottoNumbers = new AllRoundLottoNumbers(List.of(new LottoNumbers(lottoGenerator.executeStrategy())));
        AllRoundLottoNumbers allRoundLottoNumbers = AllRoundLottoNumbers.initAllRoundLottoNumbers(lottoGenerator, tryCount);
        assertThat(allRoundLottoNumbers).isEqualTo(testAllRoundLottoNumbers);
    }


}
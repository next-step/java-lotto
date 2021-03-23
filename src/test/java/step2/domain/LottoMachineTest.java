package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.lotto.LottoMachine;
import step2.dto.LottoListDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoMachineTest {

    private LottoMachine lottoGenerator;

    @BeforeEach
    void setUp() {
        this.lottoGenerator = new LottoMachine();
    }


//    @ParameterizedTest
//    @CsvSource(value = {
//            "6:6",
//            "5:5",
//            "14:14"}, delimiter = ':')
//    @DisplayName("원하는 수의 로또를 살 수 있다")
//    void lottoMachineIssuesValidCountOfLotto(int wanted, int expected) {
//        LottoListDTO lottoList = lottoGenerator.lottoList(wanted);
//        assertThat(lottoList.getLottoListCount()).isEqualTo(expected);
//    }

//    @ParameterizedTest
//    @CsvSource(value = {
//            "1,2,3,4,5,6,1:10",
//            "1,2,3,4,5:10",
//            "1,2,3,4:10",
//            "1,2,3,3,4,5:10",
//            "1,2,3,4,5,46:10",
//            "1,2,3,4,5,6:6"}, delimiter = ':')
//    @DisplayName("가짜 로또를 구별할 수 있다")
//    void lottoCanDetermineFakeLotto(String input, int bonusnumber) {
//        assertThrows(IllegalArgumentException.class, () -> lottoGenerator.lotto(input, bonusnumber));
//    }
}

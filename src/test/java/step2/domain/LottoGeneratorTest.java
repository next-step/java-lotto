package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.dto.LottoListDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        this.lottoGenerator = new LottoGenerator();
    }


    @ParameterizedTest
    @CsvSource(value = {
            "6:6",
            "5:5",
            "14:14"}, delimiter = ':')
    @DisplayName("원하는 수의 로또를 살 수 있다")
    void lottoMachineIssuesValidCountOfLotto(int wanted, int expected) {
        LottoListDTO lottoList = lottoGenerator.generateLottoList(wanted);
        assertThat(lottoList.getLottoListCount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,6,1",
            "1,2,3,4,5",
            "1,2,3,4",
            "1,2,3,3,4,5",
            "1,2,3,4,5,46"})
    @DisplayName("가짜 로또를 구별할 수 있다")
    void lottoCanDetermineFakeLotto(String input) {
        assertThrows(IllegalArgumentException.class, () -> lottoGenerator.generateLotto(input));
    }
}

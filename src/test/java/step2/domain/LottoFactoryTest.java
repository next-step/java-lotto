package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.dto.LottoDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    private LottoGenerator lottoMachine;

    @BeforeEach
    void setUp() {
        this.lottoMachine = new LottoGenerator();
    }


    @ParameterizedTest
    @CsvSource(value = {
            "6:6",
            "5:5",
            "14:14"}, delimiter = ':')
    @DisplayName("원하는 수의 로또를 살 수 있다")
    void lottoMachineIssuesValidCountOfLotto(int wanted, int expected) {
        List<LottoDTO> lottoList = lottoMachine.issueLottoList(wanted);
        assertThat(lottoList.size()).isEqualTo(expected);
    }
}

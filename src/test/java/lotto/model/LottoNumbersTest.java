package lotto.model;

import common.model.Number;
import common.view.OutputView;
import lotto.generator.LottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    LottoNumbers lottoNumbers;
    LottoNumbers winnerNumbers;

    @BeforeEach
    void setUp() {
        List<LottoNumber> temps = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            temps.add(new LottoNumber(7 * i + 3));
        }
        lottoNumbers = new LottoNumbers(temps);
        temps = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            temps.add(new LottoNumber(7 * i + 3));
        }
        winnerNumbers = new LottoNumbers(temps);

        OutputView.print(lottoNumbers);
        OutputView.print(winnerNumbers);

    }

    @RepeatedTest(20)
    @DisplayName("로또 번호 자동생성")
    void autoCreate() {
        LottoNumbers lottoNumbers = new LottoNumbers(new LottoNumberGenerator());
        assertThat(lottoNumbers.getLottoNumbers()).hasSize(6);
        OutputView.print(lottoNumbers);
    }

    @Test
    @DisplayName("당첨번호 여부 확인 테스트")
    void contains() {
        assertThat(lottoNumbers.contains(new LottoNumber(10))).isTrue();
    }

    @Test
    @DisplayName("당첨시 matchCount 증가 테스트")
    void matchCount() {
        lottoNumbers.match(new LottoNumber(10));
        assertThat(lottoNumbers.getMatchCount()).isEqualTo(new Number(1));
    }

    @Test
    @DisplayName("로또 당첨 확인 테스트")
    void matchAllCount() {
        winnerNumbers.match(lottoNumbers);
        assertThat(lottoNumbers.getMatchCount()).isEqualTo(new Number(5));

    }
}
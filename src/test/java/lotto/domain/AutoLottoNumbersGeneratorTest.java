package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoNumbersGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new AutoLottoGenerator();
    }

    @Test
    @DisplayName("로또 티켓을 생성한다.")
    void generate_lottoNumbers_test() {
        List<LottoNumber> lottoNumbers = lottoGenerator.generateLotto();
        assertThat(lottoNumbers.size()).isEqualTo(6);

    }

    @Test
    @DisplayName("로또번호가 정렬됐는지 확인한다.")
    void lotto_number_sorting_test() {
        List<LottoNumber> lottoNumbers = lottoGenerator.generateLotto();

        assertThat(checkSort(lottoNumbers)).isEqualTo(true);
    }

    private boolean checkSort(List<LottoNumber> lottoNumbers) {
        List<LottoNumber> sortedLottoTicket = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLottoTicket);

        if (lottoNumbers.equals(sortedLottoTicket)) {
            return true;
        }

        return false;
    }
}

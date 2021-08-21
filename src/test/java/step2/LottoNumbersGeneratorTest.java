package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersGeneratorTest {

    @Test
    @DisplayName("로또 티켓을 생성한다.")
    void generate_lottoNumbers_test() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();

        Ticket lottoTicket = lottoNumbersGenerator.generateLottoTicket();

        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);

    }

    @Test
    @DisplayName("로또번호가 정렬됐는지 확인한다.")
    void lotto_number_sorting_test() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();

        List<Integer> lottoNumbers = lottoNumbersGenerator.generateLottoTicket().getLottoNumbers();

        assertThat(checkSort(lottoNumbers)).isEqualTo(true);
    }

    private boolean checkSort(List<Integer> lottoTicket) {
        List<Integer> sortedLottoTicket = new ArrayList<>(lottoTicket);
        Collections.sort(sortedLottoTicket);

        if(lottoTicket.equals(sortedLottoTicket)) {
            return true;
        }

        return false;
    }
}

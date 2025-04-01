package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void lotto() {
        List<Integer> lottoNumbers = LottoTicket.generateLottoNumbers();
        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers).allMatch(number -> number >= 1 && number <= 45);
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @Test
    void lottoSorted() {
        List<Integer> lottoNumbers = LottoTicket.generateLottoNumbers();
        assertThat(lottoNumbers).isSorted();
    }
}

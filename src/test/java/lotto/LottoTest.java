package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void generate() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers.stream().min(Integer::compareTo).get()).isGreaterThanOrEqualTo(1);
        assertThat(lottoNumbers.stream().max(Integer::compareTo).get()).isLessThanOrEqualTo(45);
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

}

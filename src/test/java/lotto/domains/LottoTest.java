package lotto.domains;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또번호_생성하기() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumbers = lotto.lottoNumbers();

        System.out.println(lottoNumbers);
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}

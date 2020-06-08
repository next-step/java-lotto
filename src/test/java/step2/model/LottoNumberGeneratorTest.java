package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @DisplayName("로또 번호 6개를 가진 리스트 반환")
    @Test
    void generate() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generate();
        lottoNumbers.forEach(System.out::println);
        assertThat(lottoNumbers).hasSize(6);
    }
}

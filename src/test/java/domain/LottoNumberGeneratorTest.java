package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {
    @Test
    @DisplayName("로또 번호 생성 시 중복된 번호가 없어야한다.")
    void 로또번호_생성() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        List<Integer> distinctLottoNumbers = lottoNumbers.stream()
                .distinct()
                .collect(Collectors.toList());

        assertThat(distinctLottoNumbers).isEqualTo(lottoNumbers);
    }
}
package lotto.common;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class AutoNumberGeneratorTest {

    private AutoNumberGenerator autoNumberGenerator;

    @BeforeEach
    void setAutoNumberGenerator() {
        autoNumberGenerator= new AutoNumberGenerator();
    }

    @RepeatedTest(50)
    @DisplayName("랜덤 로또 번호 생성 테스트")
    void generateNumber() {
        List<LottoNumber> lottoNumbers = autoNumberGenerator.generateNumber();
        Set<LottoNumber> numberSet = lottoNumbers.stream().collect(Collectors.toSet());
        assertThat(numberSet.size()).isEqualTo(6);
    }
}
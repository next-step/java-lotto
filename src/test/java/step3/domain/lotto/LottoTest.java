package step3.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private Set<LottoNumber> lottoNumbers;

    @BeforeEach
    void beforeEach() {
        lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toSet());

    }

    @DisplayName("Lotto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Set<LottoNumber> inputValue = lottoNumbers;

        // when
        Lotto lotto = Lotto.of(inputValue);

        // then
        assertThat(lotto).isNotNull();
    }

}
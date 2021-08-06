package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 생성 테스트")
public class LottoGeneratorTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new).collect(Collectors.toList());
    }

    @Test
    @DisplayName("로또 번호 생성")
    void generateLottoTest() {
        // given
        LottoGenerator lottoGenerator = () -> new LottoTicket(lottoNumbers);

        // when
        LottoTicket actual = lottoGenerator.generate();

        // then
        List<LottoNumber> expectedNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new).collect(Collectors.toList());

        assertThat(actual).isEqualTo(new LottoTicket(expectedNumbers));
    }
}

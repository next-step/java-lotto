package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 생성 테스트")
public class LottoGeneratorTest {

    private int[] lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = new int[]{1, 2, 3, 4, 5, 6};
    }

    @Test
    @DisplayName("로또 번호 생성")
    void generateLottoTest() {
        // given
        LottoGenerator lottoGenerator = () -> new LottoTicket(lottoNumbers);

        // when
        LottoTicket actual = lottoGenerator.generate();

        // then
        assertThat(actual).isEqualTo(new LottoTicket(lottoNumbers));
    }
}

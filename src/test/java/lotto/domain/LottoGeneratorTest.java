package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 생성 테스트")
public class LottoGeneratorTest {

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
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

package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    LottoNumbers myLottoNumbers, winningLottoNumbers;

    @BeforeEach
    void setUp() {
        myLottoNumbers = new LottoNumbers(
                Stream.of(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
                ).collect(Collectors.toSet()));

        winningLottoNumbers = new LottoNumbers(
                Stream.of(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)
                ).collect(Collectors.toSet()));
    }

    @Test
    void LottoNumbers_생성() {
        assertThat(myLottoNumbers.value()).contains(new LottoNumber(1), new LottoNumber(6));
    }

    @Test
    void LottoNumbers_생성_사이즈_예외() {
        assertThatThrownBy(() -> new LottoNumbers(
                Stream.of(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5)
                ).collect(Collectors.toSet())))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또 번호의 개수는 6개여야 합니다.");
    }

    @Test
    void 로또_번호와_당첨_번호_일치_개수_계산() {
        assertThat(myLottoNumbers.countNumberOfMatch(winningLottoNumbers))
                .isEqualTo(3);
    }
}

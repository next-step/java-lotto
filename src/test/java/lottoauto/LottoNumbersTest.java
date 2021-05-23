package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @DisplayName("자동로또번호발생 중복검사 테스트")
    @Test
    void 자동로또번호발생_중복검사() {
        List<LottoNumber> lottoNumberList = Stream.<LottoNumber>builder()
                .add(new LottoNumber(1))
                .add(new LottoNumber(1))
                .add(new LottoNumber(1))
                .add(new LottoNumber(1))
                .add(new LottoNumber(1))
                .add(new LottoNumber(1))
                .build()
                .collect(Collectors.toList());

        assertThatThrownBy(()->new LottoNumbers(lottoNumberList)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("중복은 존재할 수 없습니다.");
    }

    @DisplayName("hitCount 테스트")
    @Test
    void checkHitCount() {
        List<LottoNumber> winningNumberList = Stream.<LottoNumber>builder()
                .add(new LottoNumber(1))
                .add(new LottoNumber(2))
                .add(new LottoNumber(3))
                .add(new LottoNumber(4))
                .add(new LottoNumber(5))
                .add(new LottoNumber(6))
                .build()
                .collect(Collectors.toList());
        LottoNumbers winningNumbers = new LottoNumbers(winningNumberList);

        List<LottoNumber> lottoNumberList = Stream.<LottoNumber>builder()
                .add(new LottoNumber(1))
                .add(new LottoNumber(2))
                .add(new LottoNumber(3))
                .add(new LottoNumber(4))
                .add(new LottoNumber(5))
                .add(new LottoNumber(7))
                .build()
                .collect(Collectors.toList());
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);

        winningNumbers.checkHitCount(lottoNumbers);
        //LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,7)));

        //winningNumber.checkWinning(lottoTicket);
        //assertThat(lottoTicket.hitCount()).isEqualTo(new HitCount(5));
    }
}

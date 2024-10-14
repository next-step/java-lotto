package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @Test
    public void 유효한_당첨번호_생성() {
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(Collectors.toList());
        WinningNumber winningNumber = new WinningNumber(lottoNumbers);

        assertThat(winningNumber).isNotNull();
    }

    @Test
    public void 당첨번호에_null_입력시_IllegalArgumentException발생() {
        assertThatThrownBy(() -> new WinningNumber(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호는 null 또는 빈 값이 될 수 없습니다.");
    }

    @Test
    public void 당첨번호에_빈값_입력시_IllegalArugmentException발생() {
        assertThatThrownBy(() -> new WinningNumber(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호는 null 또는 빈 값이 될 수 없습니다.");
    }

    @Test
    public void 일치하는_번호_개수_테스트() {
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        WinningNumber winningNumber = new WinningNumber(lottoNumbers);
        Lotto lotto = new Lotto(Arrays.asList(1, 3, 5, 7, 9, 11).stream().map(LottoNumber::new).collect(Collectors.toList()));
        int matchCount = winningNumber.matchNumberCount(lotto);

        assertThat(matchCount).isEqualTo(3);
    }
}

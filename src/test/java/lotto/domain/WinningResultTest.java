package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    @DisplayName("총 상금을 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:2000000000", "1, 2, 3, 4, 5, 7:1500000", "1, 2, 3, 4, 7, 8:50000", "1, 2, 3, 7, 8, 9:5000"
            , "1, 2, 7, 8, 9, 10:0", "1, 7, 8, 9, 10, 11:0", "7, 8, 9, 10, 11, 12:0"}, delimiter = ':')
    void total_price(final String autoLotto, final BigDecimal price) {

        final WinningLottoNumber winningLottoNumber = new WinningLottoNumber("1, 2, 3, 4, 5, 6");
        final List<LottoNumber> lottoNumbers = List.of(new LottoNumber(autoLotto));
        final WinningResult winningResult = WinningResult.init();
        winningResult.match(winningLottoNumber, lottoNumbers);

        assertThat(winningResult.sum()).isEqualTo(price);
    }

    @DisplayName("같은 등수가 2개인 우승 상금을 구한다.")
    @Test
    void tie_price() {

        final WinningLottoNumber winningLottoNumber = new WinningLottoNumber("1, 2, 3, 4, 5, 6");
        final List<LottoNumber> lottoNumbers = List.of(new LottoNumber("1, 2, 3, 4, 7, 8")
                , new LottoNumber("3, 4, 5, 6, 7, 8"));
        final WinningResult winningResult = WinningResult.init();
        winningResult.match(winningLottoNumber, lottoNumbers);

        assertThat(winningResult.sum()).isEqualTo(new BigDecimal(100000));
    }
}

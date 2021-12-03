package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value = {
            "NOTHING,7/8/9/10/11/12",
            "THREE_SAME,4/5/6/7/8/9",
            "SIX_SAME,1/2/3/4/5/6"
    })
    void of(LottoRank lottoRank, String numbers) {
        List<LottoNumber> integers = Arrays.stream(numbers.split("/"))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        LottoTicket lottoTicket = LottoTicket.customLottoTicket(1, 2, 3, 4, 5, 6);
        LottoTicket targetLottoTicket = LottoTicket.customLottoTicket(integers);

        assertThat(LottoRank.of(lottoTicket, targetLottoTicket))
                .isEqualTo(lottoRank);
    }
}

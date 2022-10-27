package step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = LottoResult.of(Stream.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)).collect(Collectors.toSet()), LottoNumber.from(45));
    }

    @DisplayName("drawLottoResult Test")
    @Test
    void drawLottoResult_return_prize_and_prize_matchCount() {
        List<LottoNumbers> allLottoNumbers = Arrays.asList(
                LottoNumbers.from(Stream.of(
                                LottoNumber.from(1),
                                LottoNumber.from(2),
                                LottoNumber.from(3),
                                LottoNumber.from(9),
                                LottoNumber.from(10),
                                LottoNumber.from(11))
                        .collect(Collectors.toSet())),
                LottoNumbers.from(Stream.of(
                        LottoNumber.from(4),
                        LottoNumber.from(5),
                        LottoNumber.from(6),
                        LottoNumber.from(12),
                        LottoNumber.from(13),
                        LottoNumber.from(14)).collect(Collectors.toSet())),
                LottoNumbers.from(Stream.of(
                        LottoNumber.from(1),
                        LottoNumber.from(2),
                        LottoNumber.from(3),
                        LottoNumber.from(4),
                        LottoNumber.from(15),
                        LottoNumber.from(16)).collect(Collectors.toSet())),
                LottoNumbers.from(Stream.of(
                        LottoNumber.from(1),
                        LottoNumber.from(2),
                        LottoNumber.from(3),
                        LottoNumber.from(4),
                        LottoNumber.from(5),
                        LottoNumber.from(17)).collect(Collectors.toSet())));

        lottoResult.drawLottoResult(allLottoNumbers);

        Assertions.assertAll(
                () -> assertThat(lottoResult.getLottoResult().get(Prize.FIFTH)).isEqualTo(2),
                () -> assertThat(lottoResult.getLottoResult().get(Prize.FOURTH)).isEqualTo(1),
                () -> assertThat(lottoResult.getLottoResult().get(Prize.THIRD)).isEqualTo(1)
        );
    }
}

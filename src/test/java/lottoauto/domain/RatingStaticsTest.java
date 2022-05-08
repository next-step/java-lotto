package lottoauto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RatingStaticsTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        List<String> numberInputs = List.of(
                "8, 21, 23, 41, 42, 43",
                "3, 5, 11, 16, 32, 38",
                "7, 11, 16, 35, 36, 44",
                "1, 8, 11, 31, 41, 42",
                "13, 14, 16, 38, 42, 45",
                "7, 11, 30, 40, 42, 43",
                "2, 13, 22, 32, 38, 45",
                "23, 25, 33, 36, 39, 41",
                "1, 3, 5, 14, 22, 45",
                "5, 9, 38, 41, 43, 44",
                "2, 8, 9, 18, 19, 21",
                "13, 14, 18, 21, 23, 35",
                "17, 21, 29, 37, 42, 45",
                "3, 8, 27, 30, 35, 44"
        );
        List<Lotto> lottoList = numberInputs.stream().map(Lotto::from).collect(Collectors.toList());
        lottos = Lottos.from(lottoList);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:0.35"}, delimiter = ':')
    void 수익률_확인(String winnigLottoNumbers, String result) {
        WinningLotto winningLotto = WinningLotto.from(Lotto.from(winnigLottoNumbers));
        System.out.println(winningLotto);
        System.out.println(lottos.totalPrice());
        assertThat(lottos.findRatingStatics(winningLotto).rateOfReturn(lottos.totalPrice())).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 3, 5, 14, 22, 42:45:2142.85"}, delimiter = ':')
    void 수익률_확인_보너스_번호_추가(String winnigLottoNumbers, String bonusNumber, String result) {
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(winnigLottoNumbers), LottoNumber.from(bonusNumber));
        System.out.println(winningLotto);
        RatingStatics ratingStatics = lottos.findRatingStatics(winningLotto);
        System.out.println(ratingStatics);
        assertThat(ratingStatics.rateOfReturn(lottos.totalPrice())).isEqualTo(result);
    }
}
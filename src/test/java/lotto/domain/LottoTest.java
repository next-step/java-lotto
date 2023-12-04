package lotto.domain;

import lotto.fixture.LottoNumberArgumentsProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;

import static java.util.stream.Collectors.joining;


class LottoTest {

    @ParameterizedTest(name = "로또: {0}, 결과: {1}")
    @ArgumentsSource(LottoNumberArgumentsProvider.class)
    void numberList_makeLotto(Lotto lotto, Prize prize) {
        List<Integer> winLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoWinGenerator generator = new LottoWinGenerator(winLottoNumbers);
        Assertions.assertThat(generator.winPrize(lotto)).isEqualTo(prize);
    }

    @Test
    @DisplayName("로또 번호는 [1, 2, 3 ... ] 문자로 변환되어야 한다.")
    void numberList_convertStr() {
        List<Integer> lottoNumberList = List.of(1, 2, 3, 4, 5, 6);
        String lottoNumberFormat = "[%s]";
        String collect = String.format(lottoNumberFormat, lottoNumberList.stream().map(String::valueOf).collect(joining(", ")));
        Assertions.assertThat(collect).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}

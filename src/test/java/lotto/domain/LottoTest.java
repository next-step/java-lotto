package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @ParameterizedTest
    @MethodSource("invalidLottoNumbers")
    void invalid한_lottoNumbers는_throw한다(List<LottoNumber> lottoNumbers) {
        IllegalArgumentException e = catchThrowableOfType(() -> new Lotto(lottoNumbers),
            IllegalArgumentException.class);

        assertThat(e).isNotNull();
    }

    static Stream<List<LottoNumber>> invalidLottoNumbers() {
        return Stream.of(
            Arrays.asList(1, 2, 3, 4, 5),
            Arrays.asList(1, 2, 3, 4, 5, 6, 7),
            Arrays.asList(1, 2, 3, 4, 5, 4, 4),
            Arrays.asList(1, 2, 3, 4, 5, 1, 1)
        ).map(lottoNumbers -> lottoNumbers
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }
}


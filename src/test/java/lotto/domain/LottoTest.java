package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTest {
    List<LottoNumber> lottoNumbers;
    List<LottoNumber> otherLottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)));
        otherLottoNumbers = new ArrayList<>(Arrays.asList(new LottoNumber(2), new LottoNumber(3), new LottoNumber(4)));
    }

    static Stream<Arguments> comparingSource() {
        return Stream.of(
                arguments(new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3))),
                new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3))), 3),

                arguments(new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3))),
                        new ArrayList<>(Arrays.asList(new LottoNumber(2), new LottoNumber(3), new LottoNumber(4))), 2)
        );
    }

    @ParameterizedTest
    @DisplayName("lotto 비교 테스트")
    @MethodSource("comparingSource")
    void compareLotto(List<LottoNumber> lottoNumbers, List<LottoNumber> otherLottoNumbers, int expected) {
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto otherLotto = new Lotto(otherLottoNumbers);

        int actualCount = lotto.compareLotto(otherLotto);

        assertThat(actualCount).isEqualTo(expected);
    }
}
package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.service.LottoFactory;

public class LottoFactoryTest {
    LottoFactory lottoFactory;

    @BeforeEach
    public void init() {
        lottoFactory = new LottoFactory();
    }

    @ParameterizedTest
    @MethodSource("testNumbers")
    public void generate_lotto_test(BigDecimal payAmount, List<LottoNumber> manualNumbers, int expectSize) {
        Lotto lotto = lottoFactory.generateLotto(payAmount, manualNumbers);
        assertThat(lotto.getLottoSize()).isEqualTo(expectSize);
    }

    static Stream<Arguments> testNumbers() {
        return Stream.of(arguments(BigDecimal.valueOf(14000L), generateNumber(2), 14),
                         arguments(BigDecimal.valueOf(17000L), generateNumber(1), 17),
                         arguments(BigDecimal.valueOf(15400L), generateNumber(1), 15));
    }

    static List<LottoNumber> generateNumber(int size) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoNumbers.add(new LottoNumber(Lists.list(1, 2, 3, 4, 5, 6)));
        }
        return lottoNumbers;
    }
}

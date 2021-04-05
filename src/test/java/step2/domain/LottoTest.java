
package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;


class LottoTest {

    private Set<LottoNumber> lottoNumbers;
    private Lotto lotto;

    @BeforeEach
    void init() {
        lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        lotto = new Lotto(lottoNumbers);
    }

    @DisplayName("숫자가 포함되어 있는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3:4:5:6", "10:11:12:13:15:16", "17:18:19:20:33:45"}, delimiter = ':')
    void lottoIsContainTest(int first, int second, int third, int fourth, int fifth, int sixth) {
        Set<LottoNumber> lottoNumbers = Stream.of(first, second, third, fourth, fifth, sixth)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Lotto lotto = new Lotto(lottoNumbers);

        Assertions.assertAll(
                () -> assertTrue(lotto.isContains(LottoNumber.valueOf(first))),
                () -> assertTrue(lotto.isContains(LottoNumber.valueOf((second)))),
                () -> assertTrue(lotto.isContains(LottoNumber.valueOf((third)))),
                () -> assertTrue(lotto.isContains(LottoNumber.valueOf((fifth)))),
                () -> assertTrue(lotto.isContains(LottoNumber.valueOf((sixth)))));
    }

    @DisplayName("로또 일치 테스트")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "1:2:3:4:5:6:6",
                    "10:11:12:13:15:16:0",
                    "1:2:3:4:5:45:5",
                    "1:2:3:4:11:22:4",
                    "1:2:3:11:22:33:3"},
            delimiter = ':')
    void lottoGetMatchCount(
            int first,
            int second,
            int third,
            int fourth,
            int fifth,
            int sixth,
            int expectedMatchedCount) {
        Set<LottoNumber> expectedLottoNumbers = Stream.of(first, second, third, fourth, fifth, sixth)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Lotto lotto = new Lotto(lottoNumbers);
        Lotto expectedLotto = new Lotto(expectedLottoNumbers);

        Assertions.assertEquals(lotto.matchNumberCounts(expectedLotto), expectedMatchedCount);
    }

    @Test
    void lottoTest() {
        lotto.getLottoNumbers().clear();
        Set<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        lottoNumbers.clear();

        System.out.println("lottoNumbers = " + lottoNumbers.size());
        System.out.println("lotto.getLottoNumbers().size() = " + lotto.getLottoNumbers().size());

    }

}
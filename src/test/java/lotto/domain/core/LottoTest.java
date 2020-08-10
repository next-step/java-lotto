package lotto.domain.core;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.util.stream.Collectors.toList;
import static lotto.domain.core.LottoNo.valueOf;
import static lotto.domain.core.LottoNoValidator.ERROR_MESSAGE_DUPLICATE_LOTTO_NO;
import static lotto.domain.core.LottoNoValidator.MAX_LOTTO_NO_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.util.Lists.list;
import static org.assertj.core.util.Sets.newLinkedHashSet;

public class LottoTest {

    @DisplayName("null 입력 여부 확인")
    @Test
    void lotto_nullLottoNoCheck() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Lotto.of(null))
            .withMessage(ERROR_MESSAGE_DUPLICATE_LOTTO_NO);
    }

    @DisplayName("6개의 로또 번호 이상을 입력했을 경우")
    @Test
    void lotto_moreThanSixLottoNoCheck() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> LottoGenerator.fromIntSet(newLinkedHashSet(
                1, 2, 3, 4, 5, 6, 7, 8
            )))
            .withMessage(ERROR_MESSAGE_DUPLICATE_LOTTO_NO);
    }

    @DisplayName("중복된 로또 번호가 있는지, 로또를 생성하면서 확인")
    @Test
    void lotto_duplicateLottoNoCheck() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Lotto.of(list(
                  valueOf(1)
                , valueOf(2)
                , valueOf(2)
                , valueOf(4)
                , valueOf(5)
                , valueOf(7)
            )))
            .withMessage(ERROR_MESSAGE_DUPLICATE_LOTTO_NO);
    }

    @DisplayName("자동생성된 로또 번호 갯수가 6개 인지 확인")
    @Test
    void lotto_auto() {
        Lotto autoLotto = LottoGenerator.automatic();
        assertThat(autoLotto.size()).isEqualTo(MAX_LOTTO_NO_COUNT);
    }

    @DisplayName("두장의 로또에 대해서 로또번호가 얼마나 맞는 지 확인")
    @ParameterizedTest
    @CsvSource(value = {
          "1, 2, 3, 4, 5, 6=6"
        , "1, 2, 3, 4, 5, 7=5"
        , "1, 2, 3, 4, 7, 8=4"
        , "1, 2, 3, 7, 8, 9=3"
        , "1, 2, 7, 8, 9,10=2"
        , "1, 7, 8, 9,10,11=1"
        , "7, 8, 9,10,11,12=0"
    }, delimiter = '=')
    void lotto_countOfMatch(String lotto, int expectedCountOfMatch) {
        final Lotto wonLotto = LottoGenerator.from(
            1, 2, 3, 4, 5, 6
        );

        final List<LottoNo> lottoNos = Arrays.stream(lotto.replaceAll(" ","").split(","))
                                      .mapToInt(Integer::valueOf)
                                      .mapToObj(LottoNo::valueOf)
                                      .collect(toList())
            ;
        Lotto testLotto = Lotto.of(lottoNos);
        assertThat(wonLotto.countOfMatch(testLotto)).isEqualTo(expectedCountOfMatch);
        assertThat(testLotto.countOfMatch(wonLotto)).isEqualTo(expectedCountOfMatch);
    }
}

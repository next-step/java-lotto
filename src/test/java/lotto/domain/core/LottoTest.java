package lotto.domain.core;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static lotto.domain.core.LottoNo.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.util.Lists.list;

public class LottoTest {
    @DisplayName("중복된 로또 번호가 있는지, 로또를 생성하면서 확인")
    @Test
    void lotto_duplicate_lottoNo_check() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Lotto.of(list(
                  valueOf(1)
                , valueOf(2)
                , valueOf(2)
                , valueOf(4)
                , valueOf(5)
                , valueOf(7)
            )))
            .withMessage(Lotto.ERROR_MESSAGE_DUPLICATE_LOTTO_NO);
    }

    @DisplayName("자동생성된 로또 번호 갯수가 6개 인지 확인")
    @Test
    void lotto_auto() {
        assertThat(Lotto.automaticGenerator().size()).isEqualTo(Lotto.MAX_LOTTO_NO_COUNT);
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
    void lott_countOfMatch(String lotto, int expectedCountOfMatch) {
        final Lotto defaultLotto = Lotto.of(list(
            valueOf(1)
            , valueOf(2)
            , valueOf(3)
            , valueOf(4)
            , valueOf(5)
            , valueOf(6)
        ));

        final List<LottoNo> lottoNos = Arrays.stream(lotto.replaceAll(" ","").split(","))
                                      .mapToInt(Integer::valueOf)
                                      .mapToObj(LottoNo::valueOf)
                                      .collect(toList())
            ;

        assertThat(defaultLotto.countOfMatch(Lotto.of(lottoNos))).isEqualTo(expectedCountOfMatch);
    }

    static class Lotto {
        public static final int FROM_INDEX = 0;
        public static final int MAX_LOTTO_NO_COUNT = 6;
        public static final String ERROR_MESSAGE_DUPLICATE_LOTTO_NO = format("로또 번호는 중복 없이 %d개의 숫자만 등록 가능합니다.", MAX_LOTTO_NO_COUNT);
        private final List<LottoNo> lottoNos;

        private Lotto(List<LottoNo> lottoNos) {
            this.lottoNos = lottoNos;
        }

        static Lotto of(List<LottoNo> lottoNos) {
            requiredSixLottoNo(lottoNos);
            return new Lotto(lottoNos);
        }

        static Lotto automaticGenerator(){
            List<LottoNo> autoLottoNos = LottoNo.shuffle()
                                                .subList(FROM_INDEX, MAX_LOTTO_NO_COUNT)
                ;
            return of(autoLottoNos);
        }


        int countOfMatch(Lotto otherLotto){
            return (int)lottoNos.stream()
                           .filter(otherLotto::contains)
                           .count()
                ;
        }

        boolean contains(LottoNo lottoNo){
            return lottoNos.contains(lottoNo);
        }

        int size(){
            return lottoNos.size();
        }

        private static void requiredSixLottoNo(List<LottoNo> lottoNos) {
            long count = lottoNos.stream()
                                 .distinct()
                                 .count()
                ;
            if (MAX_LOTTO_NO_COUNT != count) {
                throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_LOTTO_NO);
            }
        }
    }
}

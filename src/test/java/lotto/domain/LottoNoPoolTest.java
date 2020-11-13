package lotto.domain;

import lotto.asset.ExceptionConst;
import lotto.asset.LottoConst;
import lotto.exception.LottoRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNoPoolTest {

    private LottoNoPool lottoNoPool;

    @BeforeEach
    void setUp() {
        lottoNoPool = LottoNoPool.getInstance();
    }

    @Test
    @DisplayName("숫자 로또 번호의 성공 케이스")
    void getLottoNo_num_success() {
        Stream<Executable> executables = IntStream.rangeClosed(
                LottoConst.NO_MIN,
                LottoConst.NO_MAX
        ).mapToObj((int no) -> (Executable) () -> assertThat(
                lottoNoPool.getLottoNo(no)
        ).isEqualTo(new LottoNo(no)));
        Assertions.assertAll(executables);
    }


    @ParameterizedTest
    @DisplayName("1부터 45가 아닌 숫자로 LottoNo을 만들면, LottoRangeException 이 발생한다.")
    @ValueSource(ints = {-1, 0, 46})
    public void getLottoNo_bad_num(int lottoNo) {
        assertThatExceptionOfType(LottoRangeException.class)
                .isThrownBy(() -> lottoNoPool.getLottoNo(lottoNo))
                .withMessage(ExceptionConst.LOTTO_RANGE_MSG);
    }

}

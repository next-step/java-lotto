package lotto.domain;

import lotto.asset.ExceptionConst;
import lotto.asset.LottoConst;
import lotto.exception.LottoRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNoTest {
    @Test
    @DisplayName("숫자 로또 번호의 성공 케이스")
    void constructor_num_success() {
        Stream<Executable> executables = IntStream.rangeClosed(
                LottoConst.NO_MIN,
                LottoConst.NO_MAX
        ).mapToObj((int no) -> (Executable) () -> assertThat(
                new LottoNo(no)
        ).isEqualTo(new LottoNo(no)));
        Assertions.assertAll(executables);
    }

    @ParameterizedTest
    @DisplayName("1부터 45가 아닌 숫자로 LottoNo을 만들면, LottoRangeException 이 발생한다.")
    @ValueSource(ints = {-1, 0, 46})
    public void constructor_int_fail(int lottoNo) {
        assertThatExceptionOfType(LottoRangeException.class)
                .isThrownBy(() -> new LottoNo(lottoNo))
                .withMessage(ExceptionConst.LOTTO_RANGE_MSG);
    }


    private List<LottoNo> convertToList(Integer[] lottoNos) {
        return Arrays.stream(lottoNos)
                .map((Integer no) -> new LottoNo(no))
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("Collections.sort 를 하면, 로또 번호의 크기 순서대로 정렬이 된다.")
    public void sort() {
        Integer[] lottoNos = new Integer[]{45, 5, 2, 8, 3, 9, 15, 1};
        List<LottoNo> lottoNoList = convertToList(lottoNos);
        Arrays.sort(lottoNos);
        List<LottoNo> sortedList = convertToList(lottoNos);

        Collections.sort(lottoNoList);
        assertThat(lottoNoList)
                .isEqualTo(sortedList);
    }
}

package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ValueSource(ints = {5})
    @ParameterizedTest
    void 로또_번호는_1부터_45_사이이다(int ints) {
        List<Integer> lottoNumberSet = LottoNumber.getLottoNumberList();
        Boolean lottoNumberCheck = lottoNumberSet.contains(ints);
        assertThat(lottoNumberCheck).isTrue();
    }
}
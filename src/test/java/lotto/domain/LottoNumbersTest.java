package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;


class LottoNumbersTest {

    @Test
    @DisplayName("자동으로 생성된 로또가 중복없이 6자리인지 확인")
    void createAutoLotto() {
        LottoNumbers lottoNumbers = LottoNumbers.createAutoLottoNumber();
        List<LottoNumber> collect = lottoNumbers.lottoNumbers().stream().distinct().collect(Collectors.toList());
        Assertions.assertThat(collect.size()).isEqualTo(6);
    }
}
package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {
    private final List<LottoNumber> list = toLottoNumbers(1,2,3,4,5,6);

    @DisplayName("보너스 넘버가 6개 숫자에 포함 될 경우 생성자 예외처리")
    @Test
    void containsBonusNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(list, 1));
    }

    @DisplayName("보너스 넘버 체크")
    @Test
    void checkBonusNumber() {
        WinningLotto winningLotto = new WinningLotto(list, 7);
        List<LottoNumber> checkList = Stream.of(1,2,3,4,5,7).map(LottoNumber::of).collect(Collectors.toList());
        assertThat(winningLotto.checkBonusNumber(checkList)).isTrue();
    }

    @DisplayName("맞은 개수 확인")
    @Test
    void matchedCount() {
        WinningLotto winningLotto = new WinningLotto(list, 7);
        List<LottoNumber> checkList = Stream.of(1,2,3,4,5,6).map(LottoNumber::of).collect(Collectors.toList());
        long matchedCount = winningLotto.getMatchedCount(checkList);
        assertThat(matchedCount).isEqualTo(6);
    }

    private List<LottoNumber> toLottoNumbers(int ... numbers) {
        return IntStream.of(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

}

package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 발행 - 6개의 숫자가 발행 되는지 확인")
    @Test
    void issueLotto() {
        Lotto lotto = new Lotto();
        ArrayList<Integer> issuedLotto = lotto.issueLotto();
        assertThat(issuedLotto.size()).isEqualTo(6);
    }

    @DisplayName("로또 발행 - 6개의 고유한 번호를 가지고 있는 지 확인")
    @Test
    void issueLotto2() {
        Lotto lotto = new Lotto();
        ArrayList<Integer> issuedLotto = lotto.issueLotto();
        List<Integer> distinctList = issuedLotto.stream()
                .distinct()
                .collect(Collectors.toList());
        assertThat(distinctList.size()).isEqualTo(6);
    }

}
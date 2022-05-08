package lotto.model;

import lotto.exception.LottoLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @Test
    @DisplayName("당첨 번호와 상품으로 만들어진 로또의 번호가 일치하는지 확인한다.")
    void winningProduct() {
        Lotto lotto = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(Set.of(
                1, 2, 3, 4, 5, 6)));
    }


    @Test
    @DisplayName("로또 사이즈는 6자리입니다.")
    void lottoSizeException() {
        assertThrows(LottoLengthException.class, () -> {
            List<Integer> lottoNumbers = List.of(7, 8, 8, 9, 5, 6);
            new Lotto(new HashSet<>(lottoNumbers));
            new Lotto(
                    Set.of(7, 8, 9, 5, 6, 10, 17));

        });
    }

}
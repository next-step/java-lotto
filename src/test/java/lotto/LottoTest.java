package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class LottoTest {

    @Test
    void 체크() {
        Set<Integer> lottoList = new HashSet<>();
        lottoList.add(3);
        lottoList.add(16);
        lottoList.add(2);
        lottoList.add(44);
        lottoList.add(33);
        lottoList.add(18);

        Lotto lotto = new Lotto(lottoList);

    }


    @Test
    @DisplayName("1 ~ 45 사이의 6개의 숫자를 정상적으로 입력한게 맞는지 확인한다.")
    void 로또_숫자_입력_정상_체크() {
        Set<Integer> lottoList = new HashSet<>();
        lottoList.add(3);
        lottoList.add(16);
        lottoList.add(2);
        lottoList.add(44);
        lottoList.add(33);
        lottoList.add(18);

        assertThat(new Lotto(lottoList));
    }

    @Test
    @DisplayName("6개의 숫자를 입력하지 않은 경우 오류체크를 하는지 확인한다.")
    void 로또_숫자_6개_아닌_입력_오류_체크() {
        Set<Integer> lottoList = new HashSet<>();

        lottoList.add(3);
        lottoList.add(16);
        lottoList.add(2);
        lottoList.add(44);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoList);
                });
    }

    @Test
    @DisplayName("1 ~ 45 사이의 숫자가 아닌 경우 오류체크를 하는지 확인한다.")
    void 로또_숫자_1_45_사이의_숫자가_아닌_경우_오류체크() {
        Set<Integer> lottoList = new HashSet<>();

        lottoList.add(0);
        lottoList.add(48);
        lottoList.add(16);
        lottoList.add(44);
        lottoList.add(55);
        lottoList.add(99);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoList);
                });
    }

    @Test
    @DisplayName("중복되는 숫자가 있는 경우 오류체크를 하는지 확인한다.")
    void 로또_중복된_숫자_오류체크() {
        Set<Integer> lottoList = new HashSet<>();
        lottoList.add(3);
        lottoList.add(16);
        lottoList.add(16);
        lottoList.add(44);
        lottoList.add(33);
        lottoList.add(18);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoList);
                });
    }

}
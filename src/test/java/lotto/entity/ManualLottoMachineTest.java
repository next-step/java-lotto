package lotto.entity;

import lotto.LottoMethod;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ManualLottoMachineTest {

    @Test
    void 문자_배열_입력시_생성_검증() {
        List<String[]> texts = new ArrayList<>();
        texts.add(new String[]{"1", "2", "3", "4", "5", "6"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "7"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "8"});

        List<Lotto> newLottos = ManualLottoMachine.createLotto(3000, 3, texts);


        List<Lotto> lottos = Arrays.asList(
                Lotto.valueOf(LottoMethod.toList(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Lotto.valueOf(LottoMethod.toList(Arrays.asList(1, 2, 3, 4, 5, 7))),
                Lotto.valueOf(LottoMethod.toList(Arrays.asList(1, 2, 3, 4, 5, 8)))
        );
        assertAll(
                () -> assertThat(newLottos).hasSize(3),
                () -> assertThat(newLottos).isEqualTo(lottos)
        );
    }


    @Test
    void 문자_배열_입력시_사이즈_6개_아닐시_예외() {
        List<String[]> texts = new ArrayList<>();
        texts.add(new String[]{"1", "2", "3", "4", "5", "6", "7"});

        assertThatThrownBy(() -> ManualLottoMachine.createLotto(1000, 1, texts));

    }

    @Test
    void 투입금액보다_수동_로또_수가_크면_예외() {
        List<String[]> texts = new ArrayList<>();
        texts.add(new String[]{"1", "2", "3", "4", "5", "6", "7"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "6", "7"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "6", "7"});
        assertThatThrownBy(() -> ManualLottoMachine.createLotto(2000, 3, texts)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수동_입력_갯수와_텍스트_리스트가_다르면_예외() {
        List<String[]> texts = new ArrayList<>();
        texts.add(new String[]{"1", "2", "3", "4", "5", "6", "7"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "6", "7"});

        assertThatThrownBy(() -> ManualLottoMachine.createLotto(5000, 3, texts)).isInstanceOf(IllegalArgumentException.class);
    }
}

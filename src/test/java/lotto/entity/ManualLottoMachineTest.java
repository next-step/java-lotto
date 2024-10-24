package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottoMachineTest {

    @Test
    void 문자_배열_입력시_사이즈_검증() {
        List<String[]> texts = new ArrayList<>();
        texts.add(new String[]{"1", "2", "3", "4", "5", "6"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "7"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "8"});

        List<Lotto> lotto = ManualLottoMachine.createLotto(texts);
        assertThat(lotto).hasSize(3);
    }


    @Test
    void 문자_배열_입력시_사이즈_6개_아닐시_예외() {
        List<String[]> texts = new ArrayList<>();
        texts.add(new String[]{"1", "2", "3", "4", "5", "6", "7"});

        assertThatThrownBy(() -> ManualLottoMachine.createLotto(texts));

    }
}

package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.LottoMethod.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoMachineTest {

    @Test
    void 수동_로또와_투입금액_입력_시_사이즈_및_포함_여부_검증() {

        List<String[]> texts = new ArrayList<>();
        texts.add(new String[]{"1", "2", "3", "4", "5", "6"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "7"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "8"});

        List<Lotto> lotto = LottoMachine.createLotto(5000, 3, texts);

        assertAll(
                () -> assertThat(lotto).hasSize(5),
                () -> assertThat(lotto).contains(Lotto.valueOf(toList(Arrays.asList(1, 2, 3, 4, 5, 6))))
        );

    }
}

package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoMachineTest {

    List<LottoNumber> toList(List<Integer> numbers) {
        return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toList());
    }

    @Test
    void 투입금액보다_수동_로또_수가_크면_예외() {
        assertThatThrownBy(() -> LottoMachine.validate(2000, 3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수동_로또와_투입금액_입력_시_사이즈_및_포함_여부_검증() {

        List<String[]> texts = new ArrayList<>();
        texts.add(new String[]{"1", "2", "3", "4", "5", "6"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "7"});
        texts.add(new String[]{"1", "2", "3", "4", "5", "8"});

        List<Lotto> lotto = LottoMachine.createLotto(texts, 5000);

        assertAll(
                () -> assertThat(lotto).hasSize(5),
                () -> assertThat(lotto).contains(Lotto.valueOf(toList(Arrays.asList(1, 2, 3, 4, 5, 6))))
        );

    }
}

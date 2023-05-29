package lotto;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnigLottoTest {

    @Test
    public void createTest_ValidationCheck(){
        List<Number> winningList = Number.createNumberList(List.of(1,2,3,4,5,6,7));

        assertThatThrownBy(() -> WinnigLotto.createLotto(winningList, new Number(8)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
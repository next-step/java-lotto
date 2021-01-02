package lotto.oop.domain;

import lotto.oop.ui.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoIssueTest {
    private LottoIssue lotto;

    @BeforeEach
    public void setUp() {
        lotto = new LottoIssue();
    }

    @Test
    @DisplayName("발행한 로또의 개수 확인")
    public void publishLootListTest() {
        LottoNumber num= new LottoNumber();
        num.setGenerateNumbers(Arrays.asList(1,3,8,2,11,5));
        List<LottoNumber> handLotto = new ArrayList<>();
        handLotto.add(num);
        lotto.publishLottoList(13, handLotto);
        assertThat(lotto.getResultList().size()).isEqualTo(14);
    }

    @ParameterizedTest
    @ValueSource(strings = {"46,47,48,49,50,51"})
    void checkNumberTest(String numbers) {
        InputView input = new InputView();
        List<Integer> numList = input.convertInt(numbers);
        assertThatThrownBy(() -> {
            lotto.checkNumber(numList, 26);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

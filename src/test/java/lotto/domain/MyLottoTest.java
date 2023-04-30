package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyLottoTest {

    @Test
    void 로또자동발급확인() {
        MyLotto myLotto = MyLotto.auto();
        assertThat(myLotto.numbers().size()).isEqualTo(6);
        for(Integer number : myLotto.numbers()){
            assertThat(LottoRule.NUMBER_RANGE.contains(number)).isTrue();
        }
    }

    @Test
    void ToString() {
        String inputNumbers = "1, 8, 11, 31, 41, 42";
        WinLotto winLotto = new WinLotto(inputNumbers);
        String expectedToString = "[1, 8, 11, 31, 41, 42]";
        assertThat(winLotto.toString()).isEqualTo(expectedToString);
    }

    @Test
    void 당첨확인() {
        MyLotto myLotto = MyLotto.manual("7, 14, 21, 22, 44, 45");
        WinLotto winLotto = new WinLotto("1, 2, 7, 11, 40, 44");
        myLotto.checkMatchingNumbers(winLotto);
        assertThat(myLotto.matchingCount()).isEqualTo(2);
    }
}

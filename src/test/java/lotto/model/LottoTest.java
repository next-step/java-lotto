package lotto.model;

import lotto.exception.LottoNumbersSizeException;
import lotto.exception.NumberAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {

    private Lotto testLotto;
    private Number testNumberA;
    private Number testNumberB;
    private Number testNumberC;
    private Number testNumberD;
    private Number testNumberE;
    private Number testNumberF;
    private Number testNumberG;

    @BeforeEach
    void initializeNumbersTest() {
        testNumberA = new Number(9);
        testNumberB = new Number(2);
        testNumberC = new Number(5);
        testNumberD = new Number(23);
        testNumberE = new Number(12);
        testNumberF = new Number(22);
        testNumberG = new Number(35);

        List<Number> numberList = new ArrayList<>(Arrays.asList(testNumberA, testNumberB, testNumberC, testNumberD, testNumberE));

        testLotto = new Lotto();
        testLotto.addNumber(testNumberA);
        testLotto.addNumber(testNumberB);
        testLotto.addNumber(testNumberC);
        testLotto.addNumber(testNumberD);
        testLotto.addNumber(testNumberE);
    }


    @Test
    @DisplayName("create Numbers Test")
    void createNumberTest() {
        assertTrue(testLotto.contain(testNumberA));
    }

    @Test
    @DisplayName("create Random Numbers Test")
    void createRandomNumberTest() {
        Lotto randomLotto = new Lotto();
        randomLotto.createRandomNumber();
        assertThat(randomLotto.getNumbers().size()).isEqualTo(6);

    }


    @Test
    @DisplayName("exist Numbers Test : success")
    void addNumberTest() {
        testLotto.addNumber(testNumberG);
        assertThat(testLotto.contain(testNumberG)).isEqualTo(true);
    }

    @Test
    @DisplayName("exist Numbers Test : fail")
    void addNumberFailTest() {
        assertThatThrownBy(() -> testLotto.addNumber(testNumberB))
                .isInstanceOf(NumberAlreadyExistsException.class)
                .hasMessage("Number already exists.");
    }

    @Test
    @DisplayName("Numbers size over Test : fail")
    void addNumberFailTest2() {
        testLotto.addNumber(testNumberF);
        assertThatThrownBy(() -> testLotto.addNumber(testNumberG))
                .isInstanceOf(LottoNumbersSizeException.class)
                .hasMessage("Numbers can contain 6 numbers.");
    }

    @Test
    @DisplayName("getPrize test ")
    void getPrizeTest() {
        testLotto.addNumber(testNumberF);
        Lotto loseLotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(testLotto.getPrize(testLotto)).isEqualTo(LottoPrize.FIRST);
        assertThat(loseLotto.getPrize(testLotto)).isEqualTo(null);

    }
}

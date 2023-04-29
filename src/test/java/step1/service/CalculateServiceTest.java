package step1.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import step1.domain.Calculate;
import step1.domain.Number;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @Test
    public void split_테스트() {
        String testString = "1 + 3";
        String[] result = calculateService.split(testString);
        assertThat(result).containsExactly("1", "+", "3");
    }

    @Test
    public void 빈칸일때_에러() {
        String[] testString = {"3", " "};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculateService.sectionCalculate(testString);
        });
    }

    @Test
    public void 계산_테스트() {
        String[] testStrings = {"4", "+", "2", "*", "2", "/", "4"};
        Number number = calculateService.sectionNumber(testStrings);
        Calculate calculate = calculateService.sectionCalculate(testStrings);
        int result = calculateService.calculate(number, calculate);
        System.out.println(result);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 나눗셈의결과가_정수가_아닐때_테스트() {
        String[] testStrings = {"5", "/", "2"};
        Number number = calculateService.sectionNumber(testStrings);
        Calculate calculate = calculateService.sectionCalculate(testStrings);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculateService.calculate(number, calculate);
        });
    }

}
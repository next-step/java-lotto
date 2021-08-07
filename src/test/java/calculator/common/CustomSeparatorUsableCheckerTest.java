package calculator.common;

import calculator.common.CustomSeparatorUsableChecker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomSeparatorUsableCheckerTest {

    @Test
    public void 문자열이_주어지면_커스텀_구분자를_쓸_수_있는_여부를_확인한다(){
        //given
        CustomSeparatorUsableChecker checker = new CustomSeparatorUsableChecker();
        //when
        boolean result = checker.check("//;\\n1;2;3");
        //then
        assertThat(result).isTrue();
    }

    @Test
    public void 문자열의_길이가_커스텀_체커의_길이보다_짧으면_false를_반환한다(){
        //given
        CustomSeparatorUsableChecker checker = new CustomSeparatorUsableChecker();
        //when
        boolean result = checker.check("//;\\");
        //then
        assertThat(result).isFalse();
    }


    @Test
    public void 문자열의_길이가_커스텀_체커의_길이보다_길지만_조건에_부합하지_못하면_false를_반환한다(){
        //given
        CustomSeparatorUsableChecker checker = new CustomSeparatorUsableChecker();
        //when
        boolean result = checker.check("//;\\m1;2;3");
        //then
        assertThat(result).isFalse();
    }
}

package nextstep.lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StringUtilsTest {

    @Test
    @DisplayName("쉼표 , 콜런 : 을 구분자로 갖는 문자열 분리 테스트 (콜론)")
    void splitStringDefaultCharactor_콜론만_Test(){
        String[] splitString = StringUtils.splitString("1:2");
        assertThat(splitString).hasSize(2);
    }

    @Test
    @DisplayName("쉼표 , 콜런 : 을 구분자로 갖는 문자열 분리 테스트 (혼합)")
    void splitStringDefaultCharactor_혼합_Test(){
        String[] splitString = StringUtils.splitString("1:2,3");
        assertThat(splitString).hasSize(3);
    }

    @Test
    @DisplayName("구분자로 Split하는 테스트")
    void splitStringTest(){
        String[] splitString = StringUtils.splitString("//;\n1;2;3");
        assertThat(splitString).hasSize(3);
    }
}

package step1.separator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatorTest {

    @DisplayName("Separator 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String inputValue = "//;\n1;2;3,4:5";

        // when
        Separator separator = new Separator(inputValue);

        // then
        assertThat(separator).isNotNull();
    }


    @DisplayName("Separator 인스턴스 커스텀 구분자를 기준으로 분리하고 반화 여부 테스트")
    @Test
    void 분리하기_커스텀() {
        // given
        String[] expected = {"1", "2", "3"};
        String inputValue = "//;\n1;2;3";

        // when
        Separator separator = new Separator(inputValue);
        String[] actual = separator.splitByDelimiter();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Separator 인스턴스 디폴트 구분자를 기준으로 분리하고 반화 여부 테스트")
    @Test
    void 분리하기텀_디폴트() {
        // given
        String[] expected = {"1", "2", "3"};
        String inputValue = "1,2,3";

        // when
        Separator separator = new Separator(inputValue);
        String[] actual = separator.splitByDelimiter();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Separator 인스턴스 커스텀 구분자와 디폴트 구분를 기준으로 분리하고 반화 여부 테스트")
    @Test
    void 분리하기_혼힙() {
        // given
        String[] expected = {"1", "2", "3", "4"};
        String inputValue = "//;\n1;2,3:4";

        // when
        Separator separator = new Separator(inputValue);
        String[] actual = separator.splitByDelimiter();

        // then
        assertThat(actual).isEqualTo(expected);
    }

}
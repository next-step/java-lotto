package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SplitTest {

    @Test
    public void split_null() {
        //given
        String[] expectResult = {"0"};

        //when
        String[] result = Split.split(null);

        //then
        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    public void split_빈문자() {
        //given
        String[] expectResult = {"0"};

        //when
        String[] result = Split.split("");

        //then
        assertThat(result).isEqualTo(expectResult);
    }


    @Test
    public void split_숫자하나() throws Exception {
        //given
        String[] expectResult = {"1"};

        //when
        String[] result = Split.split("1");

        //then
        assertThat(result).isEqualTo(expectResult);

    }

    @Test
    public void split_쉼표구분자() throws Exception {
        //given
        String[] expectResult = {"1","2"};

        //when
        String[] result = Split.split("1,2");

        //then
        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    public void split_쉼표_또는_콜론_구분자() throws Exception {
        //given
        String[] expectResult = {"1","2","3"};

        //when
        String[] result = Split.split("1,2:3");

        //then
        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    public void split_custom_구분자() throws Exception {
        //given
        String[] expectResult = {"1","2","3"};

        //when
        String[] result = Split.split("//;\n1;2;3");

        //then
        assertThat(result).isEqualTo(expectResult);
    }


}

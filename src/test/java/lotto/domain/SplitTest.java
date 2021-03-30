package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitTest {
    @Test
    public void split_숫자하나() throws Exception {
        //given
        List<String> expectResult = Arrays.asList("1");

        //when
        List<String> result = Split.splitDelimiter("1");

        //then
        assertThat(result).isEqualTo(expectResult);

    }

    @Test
    public void split_쉼표구분자() throws Exception {
        //given
        List<String> expectResult = Arrays.asList("1", "2");

        //when
        List<String> result = Split.splitDelimiter("1, 2");

        //then
        assertThat(result).isEqualTo(expectResult);
    }
}

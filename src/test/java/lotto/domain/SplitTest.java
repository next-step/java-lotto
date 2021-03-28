package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitTest {
    @Test
    public void split_숫자하나() throws Exception {
        //given
        String[] expectResult = {"1"};

        //when
        String[] result = Split.splitDelimiter("1");

        //then
        assertThat(result).isEqualTo(expectResult);

    }

    @Test
    public void split_쉼표구분자() throws Exception {
        //given
        String[] expectResult = {"1", "2"};

        //when
        String[] result = Split.splitDelimiter("1,2");

        //then
        assertThat(result).isEqualTo(expectResult);
    }
}

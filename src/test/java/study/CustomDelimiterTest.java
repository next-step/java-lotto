package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomDelimiterTest {

    private long startTime;
    private String customSource;

    @BeforeEach
    void setUp() {
        customSource = "//;\\n1;2;3;4;5";
    }

    @DisplayName("Pattern을 활용해 커스텀 구분자 찾아보기")
    @Test
    public void customDelimiterFindTest() {
        Pattern pattern = Pattern.compile("//\\D\\\\n");

        boolean results = pattern.matcher(customSource).find();

        assertThat(results).isTrue();
    }

    @DisplayName("catAt 메서드로 커스텀 구분자 구하기")
    @Test
    public void parseCustomDelimiterChatAtTest() {
        this.startTime = System.currentTimeMillis();
        String source = "//;\\n";
        int index = Math.floorDiv(source.length(), 2);
        System.out.println("takes time: " + (System.currentTimeMillis() - startTime));

        assertThat(index).isEqualTo(2);
    }

    @DisplayName("Matcher 사용해서 커스텀 구분자 찾기")
    @Test
    public void findCustomDelimiterByMatcherTest() {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(customSource);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);

            assertThat(matcher.groupCount()).isEqualTo(2);
            assertThat(matcher.group(2)).isEqualTo("1;2;3;4;5");
            assertThat(customDelimiter).isEqualTo(";");
        }
    }

    @Test
    public void customDelimiterTest() {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher("//*\\n1*2*3");

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);

            assertThat(customDelimiter).isEqualTo("*");
            assertThat(tokens).containsExactly("1", "2", "3");
        }
    }
}

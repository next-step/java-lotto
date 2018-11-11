package calculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class TextTest {

    private Text text;

    @Test
    public void NULL_검사() {
        text = new Text(null);
        assertThat(text.isEmpty()).isTrue();
    }

    @Test
    public void 공백_검사() {
        text = new Text("");
        assertThat(text.isEmpty()).isTrue();
    }

    @Test
    public void 콤마를_구분자로하는_문자열_자르기_검사() {
        text = new Text("1,2,3");
        assertThat(text.split()).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    public void 콜론을_구분자로하는_문자열_자르기_검사() {
        text = new Text("1:2:3");
        assertThat(text.split()).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    public void 커스텀_구분자를_사용했을때_문자열_자르기_검사() {
        text = new Text("//;\n1;2;3");
        assertThat(text.split()).isEqualTo(new String[]{"1", "2", "3"});
    }

}
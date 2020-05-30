package study1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringsplitCalculatorTest {
	
	private Splitter splitter;
	
	@BeforeEach
	public void init() {
		splitter = new Splitter();
	}
	
	@Test
    public void splitAndSum_null_또는_빈문자() {
        
		assertThatThrownBy(() -> splitter.split(null))
        .isInstanceOf(NullPointerException.class);

		assertThatThrownBy(() -> splitter.split(""))
	        .isInstanceOf(IllegalArgumentException.class);
    }

     @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = splitter.split("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = splitter.split("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = splitter.split("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = splitter.split("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> splitter.split("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}

package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {

    @Test
    @DisplayName("이름 생성")
    public void create() throws Exception {
        String seongbeen = "seongbeen";
        Name name = new Name(seongbeen);
        assertThat(name).isEqualTo(new Name(seongbeen));
    }
}

package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemsTest {

    private Items items;

    @BeforeEach
    void setUp() {
        items = new Items();
    }

    @DisplayName("add(Item) 메서드는 Item을 추가한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:3","1:1", "1,2:2"}, delimiter = ':')
    void getItemStringTest(String itemlist, int expect) {

        String[] split = itemlist.split(",");
        Arrays.stream(split).forEach(item -> items.addItem(Item.from(item)));

        assertThat(items.size()).isEqualTo(expect);
    }


}
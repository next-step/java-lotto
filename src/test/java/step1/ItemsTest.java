package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ItemsTest {

    private Items items;

    @BeforeEach
    void setUp() {
        items = new Items();
    }

    @DisplayName("addItem() 메서드는 Item을 추가한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:3", "1:1", "1,2:2"}, delimiter = ':')
    void getItemStringTest(String itemlist, int expect) {

        String[] split = itemlist.split(",");
        Arrays.stream(split).forEach(item -> items.addItem(Item.from(item)));

        assertThat(items.size()).isEqualTo(expect);
    }

    @DisplayName("sum 메서드는 내부 아이템을 모두 더해서 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:6", "1:1", "1,2:3"}, delimiter = ':')
    void getItemStringTest(String itemlist, String expectStr) {

        String[] split = itemlist.split(",");
        Arrays.stream(split).forEach(item -> items.addItem(Item.from(item)));

        assertThat(items.sum()).isEqualTo(Item.from(expectStr));
    }


}
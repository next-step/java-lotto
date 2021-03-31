package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    @DisplayName("수동과 자동 생성 테스트")
    public void test1() {
        LottoStore lottoStore = new LottoStore();
        assertThat(lottoStore.lottoGenerate(new Price(9000)).size()).isEqualTo(9);
        assertThat(lottoStore.lottoGenerate(new Price(9900)).size()).isEqualTo(9);

        assertThat(lottoStore.lottoGenerate(new Price(15000), 3, createStringList() ).size()).isEqualTo(15);
    }

    private List<String> createStringList() {
        List<String> list = new ArrayList<>();
        list.add(new String("1,2,3,4,5,6"));
        list.add(new String("1,2,3,4,5,7"));
        list.add(new String("1,2,3,4,5,8"));
        return list;
    }
}

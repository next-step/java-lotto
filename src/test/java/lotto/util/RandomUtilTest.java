package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

class RandomUtilTest {

    @Test
    @DisplayName("입력한 count만큼 랜덤 숫자를 리스트로 생성")
    void generate_random_list_like_input_value(){
        assertThat( RandomUtil.generateRandomList(1, 45), hasSize(1));
        assertThat( RandomUtil.generateRandomList(2, 45), hasSize(2));
        assertThat( RandomUtil.generateRandomList(3, 45), hasSize(3));
        assertThat( RandomUtil.generateRandomList(4, 45), hasSize(4));
    }


}
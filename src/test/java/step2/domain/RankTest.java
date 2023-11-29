package step2.domain;


import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void rank_list_test() {
        for (Rank value : Rank.values()) {
            System.out.println(value.getMoneyNumber());
        }
    }

}
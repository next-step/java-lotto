package model;

import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    public void testRank() {
        int matchingCount = 3;
        boolean matching = true;
        Rank.valueOf(matchingCount, matching);
    }
}

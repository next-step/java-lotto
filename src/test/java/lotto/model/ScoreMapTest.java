package lotto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreMapTest {

    @Test
    void test(){
        ScoreMap scoreMap = new ScoreMap();
        scoreMap.updateWithNumMatched(1);

    }
}
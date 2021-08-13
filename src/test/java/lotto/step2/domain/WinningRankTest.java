package lotto.step2.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningRankTest {

    @Test
    void test() {
        WinningRank winningRank = WinningRank.findWinningRank(5);
        System.out.println(winningRank);
    }

    @Test
    void test2() {
        for (WinningRank rank : WinningRank.values()){
            System.out.println(rank+":"+rank.getMatchCount() +","+rank.getWinnings());
        }
    }

}
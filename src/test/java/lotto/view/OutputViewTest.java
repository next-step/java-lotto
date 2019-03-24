package lotto.view;

import lotto.domain.LottoRank;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class OutputViewTest {

    @Test
    public void printRankResult() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIFTH, LottoRank.FIRST);
        Collections.sort(lottoRanks, Collections.reverseOrder());
        for (LottoRank lottoRank : lottoRanks) {
            System.out.println(lottoRank.name());
        }
    }
}
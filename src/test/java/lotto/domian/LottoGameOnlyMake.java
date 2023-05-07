package lotto.domian;

import lotto.domain.LottoGame;

import java.util.ArrayList;
import java.util.List;

public class LottoGameOnlyMake {

    public List<LottoGame> init() {

        List<Integer> lottoNumList1 = new ArrayList<>();
        lottoNumList1.add(1);
        lottoNumList1.add(12);
        lottoNumList1.add(23);
        lottoNumList1.add(34);
        lottoNumList1.add(45);
        lottoNumList1.add(6);

        LottoGame lotto1 = new LottoGame(lottoNumList1);

        List<Integer> lottoNumList2 = new ArrayList<>();
        lottoNumList2.add(1);
        lottoNumList2.add(12);
        lottoNumList2.add(23);
        lottoNumList2.add(34);
        lottoNumList2.add(45);
        lottoNumList2.add(7);
        LottoGame lotto2 = new LottoGame(lottoNumList2);

        List<Integer> lottoNumList3 = new ArrayList<>();
        lottoNumList3.add(1);
        lottoNumList3.add(12);
        lottoNumList3.add(23);
        lottoNumList3.add(34);
        lottoNumList3.add(41);
        lottoNumList3.add(7);
        LottoGame lotto3 = new LottoGame(lottoNumList3);

        List<Integer> lottoNumList4 = new ArrayList<>();
        lottoNumList4.add(1);
        lottoNumList4.add(12);
        lottoNumList4.add(23);
        lottoNumList4.add(34);
        lottoNumList4.add(41);
        lottoNumList4.add(7);
        LottoGame lotto4 = new LottoGame(lottoNumList4);

        List<LottoGame> lottoGames = new ArrayList<>();
        lottoGames.add(lotto1);
        lottoGames.add(lotto2);
        lottoGames.add(lotto3);
        lottoGames.add(lotto4);

        return lottoGames;
    }
}

package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoUtils {

    public static List<Lotto> createTestLottos() {
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(new Lotto("1, 2, 3, 4, 5, 6"));
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 6"));
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 10"));
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 11"));
        lottoList.add(new Lotto("1, 2, 3, 4, 15, 20"));
        lottoList.add(new Lotto("1, 2, 3, 4, 15, 20"));
        lottoList.add(new Lotto("1, 2, 3, 14, 15, 20"));
        lottoList.add(new Lotto("1, 2, 3, 14, 15, 20"));
        lottoList.add(new Lotto("1, 2, 13, 14, 15, 20"));
        lottoList.add(new Lotto("1, 2, 13, 14, 15, 20"));

        return lottoList;
    }

    public static LottoGame createLottoGame() {
        LottoGame lottoGame = new LottoGame(0, 10);

        List<String> numbers = new ArrayList<>();
        numbers.add("1, 2, 3, 4, 5, 6");    //1
        numbers.add("1, 2, 3, 4, 5, 10");   //2
        numbers.add("1, 2, 3, 4, 15, 16");  //4
        numbers.add("1, 2, 3, 14, 15, 16"); //5
        numbers.add("1, 2, 3, 14, 5, 6");   //3
        numbers.add("1, 2, 3, 4, 15, 16");  //4
        numbers.add("11, 12, 13, 4, 5, 6"); //5
        numbers.add("11, 12, 13, 14, 5, 6");//0
        numbers.add("1, 2, 13, 14, 15, 16");//0
        numbers.add("1, 12, 13, 14, 15, 6");//0
        lottoGame.createLottos(numbers);

        return lottoGame;
    }
}

package lotto.domain;

import lotto.generator.ManualNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoUtils {

    public static List<Lotto> createTestLottos() {
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 5, 6")));
        lottoList.add(new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 5, 10")));
        lottoList.add(new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 5, 11")));
        lottoList.add(new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 15, 20")));
        lottoList.add(new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 15, 20")));
        lottoList.add(new Lotto(new ManualNumberGenerator("1, 2, 3, 14, 15, 20")));
        lottoList.add(new Lotto(new ManualNumberGenerator("1, 2, 3, 14, 15, 20")));
        lottoList.add(new Lotto(new ManualNumberGenerator("1, 2, 13, 14, 15, 20")));
        lottoList.add(new Lotto(new ManualNumberGenerator("1, 2, 13, 14, 15, 20")));

        return lottoList;
    }

    public static LottoGame createLottoGame() {
        Lotto lotto = new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 5, 6"));
        LottoNumber bonus = LottoNumber.from(10);
        LottoGame lottoGame = new LottoGame(0, new WinningLotto(lotto, bonus));

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

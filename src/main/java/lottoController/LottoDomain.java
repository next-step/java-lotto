package lottoController;

import lottoModel.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoDomain {

    public static final int ZERO = 0;
    public static final int ONE_GAME = 1000;

    public static List<Lotto> createLottoGames(int gameCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            List<Integer> numberList = sortLottoNumber(createLottoNumber());
            lottos.add(new Lotto(numberList));
        }
        return lottos;
    }

    public static Set<Integer> createLottoNumber() {
        List<Integer> numList = new ArrayList<Integer>();
        for (int i = 1; i <= 45; i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);

        return numList.subList(0, 6).stream().collect(Collectors.toSet());
    }

    public static int countGame(int money) {
        return money / ONE_GAME;
    }

    public static List<Integer> sortLottoNumber(Set<Integer> numbers) {
        ArrayList<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        return list;
    }

}

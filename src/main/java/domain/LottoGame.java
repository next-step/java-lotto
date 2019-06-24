package domain;

import view.ResultView;

import java.util.ArrayList;
import java.util.Collections;

public class LottoGame {
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int ONE_UNIT_OF_LOTTO = 6;

    private static ArrayList<ArrayList<Integer>> lotto = null;
    private static ArrayList<Integer> element = null;
    private static ArrayList<Integer> randomNumber = null;

    public static void run(int numofLotto) {
        getAutoLottoNumber(numofLotto);

    }

    private static void getAutoLottoNumber(int numofLotto) {
        lotto = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numofLotto; i++) {
            getLottoElementNumber();
            lotto.add(element);
            Collections.sort(lotto.get(i));
        }

        ResultView.printLottoNumber(lotto);
    }

    private static void getLottoElementNumber() {
        randomNumber = new ArrayList<>();
        for (int i = 1; i <= MAX_LOTTO_NUMBER; i++) {
            randomNumber.add(i);
        }

        Collections.shuffle(randomNumber);

        element = new ArrayList<>();
        for (int i = 0; i < ONE_UNIT_OF_LOTTO; i++) {
            element.add(randomNumber.get(i));
        }
    }
}

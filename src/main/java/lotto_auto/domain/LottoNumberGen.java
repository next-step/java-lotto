package lotto_auto.domain;

import lotto_auto.io.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGen implements RandomNumberGen {

    @Override
    public List<LottoNumbers> getLottoList() {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();

        while (InputView.budget > 0) {
            lottoNumbersList.add(new LottoNumbers(generateLotto()));
            InputView.budget -= 1000;
        }

        return lottoNumbersList;
    }

    public List<Integer> generateLotto() {
        List<Integer> numberList = generateNumberList();
        Collections.shuffle(numberList);

        List<Integer> lottoList = numberList.subList(0, 6);
        Collections.sort(lottoList);

        return lottoList;
    }

    private static List<Integer> generateNumberList() {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numberList.add(i);
        }
        return numberList;
    }

}

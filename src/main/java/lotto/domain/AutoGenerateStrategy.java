package lotto.domain;

import java.util.*;

public class AutoGenerateStrategy implements GenerateNumStrategy {
    public final static int NUMS_PER_LOTTO = 6;
//    private final static int LOTTO_MAX_NUM = 45;
    private final List<Integer> selectableNums;

    AutoGenerateStrategy() {
        List<Integer> numList = new ArrayList<>(LottoMachine.LOTTO_MAX_NUM);

        for (int i = 1; i <= LottoMachine.LOTTO_MAX_NUM; i++) {
            numList.add(i);
        }

        selectableNums = numList;
    }

//    public List<Integer> generate(int lottoTotalNum) {
//        List<Integer> generated = new ArrayList<>(NUMS_PER_LOTTO);
//        Collections.shuffle(selectableNums);
//
//        for (int i = 0; i < NUMS_PER_LOTTO; i++) {
//            generated.add(selectableNums.get(i));
//        }
//
//        return generated;
//    }

    public Lottos generate(int totalLottosNum, int numsPerLotto) {
        Integer[][] lottoArray = new Integer[totalLottosNum][numsPerLotto];

        for (int i = 0; i < totalLottosNum; i++) {
            Collections.shuffle(selectableNums);
            for (int j = 0; j < NUMS_PER_LOTTO; j++) {
                lottoArray[i][j] = selectableNums.get(j);
            }
        }

        List<Lotto> lottoList = new ArrayList<>(totalLottosNum);
        for (int i = 0; i < totalLottosNum; i++) {
            lottoList.add(new Lotto(Arrays.asList(lottoArray[i])));
        }

        return new Lottos(lottoList);
    }
}

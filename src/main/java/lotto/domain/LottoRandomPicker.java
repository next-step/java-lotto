package lotto.domain;


import java.util.concurrent.ThreadLocalRandom;

public class LottoRandomPicker {

    public static final int START_NUM = 1;
    public static final int END_NUM = 46;

    public static int pickLottoNumber(){
        return ThreadLocalRandom.current().nextInt(START_NUM, END_NUM);
    }
}

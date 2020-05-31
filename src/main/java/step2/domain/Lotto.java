package step2.domain;

/*
 * Lotto
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public class Lotto {

    private String[] lottoNumbers = new String[]{};

    private Lotto() {

    }

    public Lotto from(String[] collectedNumbers) {

        Lotto lotto = new Lotto();
        lotto.lottoNumbers = collectedNumbers;
        return lotto;

    }

    public String[] getNumbers() {
        return lottoNumbers;
    }






}

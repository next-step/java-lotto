package lotto.domain;

import lotto.exceptions.InputFormatException;
import lotto.utils.StringParser;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Lotto {

    private static final int LOTTO_COUNT = 6;
    private static final int LOTTO_BOUND = 46;
    private List<LottoNo> lottoNumbers;

    private Lotto() {
        this.lottoNumbers = new ArrayList<>();
        initLottoNumbers();
        validationCheck();

    }

    private void validationCheck() {
        if (this.lottoNumbers.size() != 6) {
            throw new InputFormatException();
        }
    }

    private Lotto(String lottoNumbers) {
        this.lottoNumbers = new ArrayList<>();
        for (String number : StringParser.StringParserByDelimeter(lottoNumbers, ",")) {
            this.lottoNumbers.add(LottoNo.lottoNoFactory(Integer.parseInt(number.trim())));
        }
        validationCheck();
    }

    public static Lotto auto() {
        return new Lotto();
    }

    public static Lotto manual(String lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private void initLottoNumbers() {
        int count = 0;
        while (true) {
            if (count == LOTTO_COUNT) break;
            int randomValue = ThreadLocalRandom.current().nextInt(1, LOTTO_BOUND);
            if (lottoNumbers.contains(randomValue)) continue;
            lottoNumbers.add(LottoNo.lottoNoFactory(randomValue));
            count++;
        }

        Collections.shuffle(lottoNumbers);
    }

    public boolean isBonusBallInLotto(int bonusBall) {
        return this.contains(bonusBall);
    }

    public List<LottoNo> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public boolean contains(Integer number) {
        for (LottoNo lottoNo : this.lottoNumbers) {
            if (lottoNo.equals(number))
                return true;
        }
        return false;
    }
}

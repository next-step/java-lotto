package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private List<Integer> lotto = new ArrayList<>();
    private int correctNumberCount = 0;
    private int prizeMoney = 0;

    public Lotto() {
        generateLotto(new LottoNumberAuto());
    }

    public void generateLotto(LottoNumber lottoNumber) {
        this.lotto = lottoNumber.generateLottoNumber();
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lotto);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }


    public int checkLottoNumbers(List<Integer> answerNumbers) {
        correctNumberCount = (int) lotto.stream()
                .filter(number -> answerNumbers.stream().anyMatch(Predicate.isEqual(number))).count();
        prizeMoney = Prize.prizes[correctNumberCount];
        return correctNumberCount;
    }


    /* 람다 변경 전
    public int checkLottoNumbers(List<Integer> answerNumbers) {
        for (Integer lottoNumber : lotto) {
            for (Integer correctNumber : answerNumbers) {
                if (lottoNumber == correctNumber) {
                    this.correctNumberCount++;
                }
            }
        }
        prizeMoney = Prize.prizes[correctNumberCount];
        return correctNumberCount;
    }*/
}

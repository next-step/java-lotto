package lotto.oop.domain;

import java.util.*;

public class LottoNumber {
    private static final int EXTRACT_FROM_FIRST_NUMBER = 0;
    private static final int EXTRACT_TO_LAST_NUMBER = 6;

    private List<Integer> number;
    private List<Integer> generateNumbers;
    private boolean bonusCheck;

    public void generateNumbers() {
        number = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            number.add(i);
        }
        shuffleNumber();
        sortSixNumber();
    }

    public void shuffleNumber() {
        Collections.shuffle(number);
    }

    public void sortSixNumber() {
        List<Integer> sixNumber = new ArrayList<>(this.number.subList(EXTRACT_FROM_FIRST_NUMBER, EXTRACT_TO_LAST_NUMBER));
        Collections.sort(sixNumber);
        generateNumbers = new ArrayList<>();
        generateNumbers = sixNumber;
    }

    public int checkLotto(List<Integer> numbers, int bonus) {
        int num = 0;
        for (int i = 0; i < numbers.size(); i++) {
            num += verifyNumCount(numbers, i);
        }
        checkBonusball(bonus);
        return num;
    }

    private int verifyNumCount(List<Integer> numList, int i) {
        if (getGenerateNumbers().contains(numList.get(i))) {
            return 1;
        }
        return 0;
    }

    private void checkBonusball(int bonus) {
        if (getGenerateNumbers().contains(bonus)) {
            bonusCheck = true;
        }
    }

    public void setGenerateNumbers(List<Integer> generateNumbers) {
        this.generateNumbers = generateNumbers;
    }

    public List<Integer> getGenerateNumbers() {
        return generateNumbers;
    }

    public boolean getBonusCheck() {
        return bonusCheck;
    }
}

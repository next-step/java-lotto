package lotto.oop.domain;

import java.util.*;

import static lotto.oop.ui.InputView.COMMA;

public class LottoNumber {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int EXTRACT_FROM_FIRST_NUMBER = 0;
    private static final int EXTRACT_TO_LAST_NUMBER = 6;

    private List<Integer> number;
    private List<Integer> generateNumbers;
    private boolean bonusCheck;

    public LottoNumber() {
    }

    public LottoNumber(String number) {
        if (convertInt(number).size() != LOTTO_NUMBER_COUNT) {
            throw new ArrayIndexOutOfBoundsException("로또 번호는 6개 입니다.");
        }
        generateNumbers = convertInt(number);
    }

    public List<Integer> convertInt(String result) {
        number = new ArrayList<>();
        String[] numberString = result.split(COMMA);
        for (String value : numberString) {
            number.add(Integer.parseInt(value));
        }
        Collections.sort(number);
        return number;
    }

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

package lottoModel;

import java.util.HashSet;
import java.util.Set;

public class LottoInputValue {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private String text;

    public LottoInputValue(String text) {
        this.text = text;
    }

    public int convertLottoBonusNumbers(Set<Integer> lastLotto) {
        int bonusNumber = convertNum(this.text);
        Lotto lotto = new Lotto(lastLotto);
        checkValid(bonusNumber);
        if ((lotto).isContainBonus(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호에서 제외된 숫자여야 함.");
        }
        return bonusNumber;
    }

    public Set<Integer> convertLastLottoNumbers() {
        Set<Integer> lastLottoNumbers = new HashSet<>();
        String[] values = splitText(clearValue(this.text));
        int number;
        for (String str : values) {
            number = convertNum(str);
            checkValid(number);
            lastLottoNumbers.add(number);
        }
        checkLottoNumberCount(lastLottoNumbers);
        return lastLottoNumbers;
    }

    private static void checkLottoNumberCount(Set<Integer> lastLottoNumbers) {
        if (lastLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 한개임당 6개 숫자 입니다. 확인후 다시 진행 해주세요");
        }
    }

    private static String clearValue(String text) {
        return text.replaceAll(" ", "");
    }

    private static String[] splitText(String text) {
        return text.split(",");
    }

    private static void checkValid(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 범위에 속한 숫자가 아닙니다.");
        }
    }

    public static int convertNum(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자 : " + text + " 숫자 변환시 오류 발생 하였습니다.");

        }
    }
}

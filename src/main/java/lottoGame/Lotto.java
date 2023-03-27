package lottoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int LOTTO_MIN_NUMBER_RANGE = 1;
    public static final int LOTTO_MAX_NUMBER_RANGE = 45;
    public static final int LOTTO_NUMBERS = 6;

    public enum TYPE{
        MANUAL,
        AUTO
    }
    private List<Integer> lottoNumbers;

    public Lotto(TYPE type, String input){
        lottoNumbers = new ArrayList<Integer>();

        if (type == TYPE.AUTO) {
            lottoNumbers.addAll(getNewLottoNumber());
        } else {
            lottoNumbers.addAll(getManualLottoNumber(input));
        }
    }

    private List<Integer> getNewLottoNumber() {
        List<Integer> lottoRange = new ArrayList<Integer>();

        for (int i = Lotto.LOTTO_MIN_NUMBER_RANGE; i <= Lotto.LOTTO_MAX_NUMBER_RANGE; i++) {
            lottoRange.add(i);
        }

        Collections.shuffle(lottoRange);

        List<Integer> lottoTicket = new ArrayList<>();
        for(int i = 0; i < Lotto.LOTTO_NUMBERS; i++) {
            lottoTicket.add(lottoRange.get(i));
        }
        Collections.sort(lottoTicket);

        return lottoTicket;
    }


    private Set<Integer> getManualLottoNumber(String input) {
        Set<Integer> manualLottoNumber = new HashSet<>();
        String[] tokens = input.split(",");
        try {
            for (int i = 0; i < tokens.length; i++) {
                int number = Integer.parseInt(tokens[i]);
                checkLottoNumberRange(number);
                manualLottoNumber.add(number);
            }
            checkDuplication(manualLottoNumber);

            return manualLottoNumber;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또번호에 문자는 입력할 수 없습니다.", e);
        }
    }

    public List<Integer> getLottoNumber() {
        return lottoNumbers;
    }

    public String toString() {
        return lottoNumbers.toString();
    }

    public void checkDuplication(Set<Integer> inputNumbers) {
        if (inputNumbers.size() != Lotto.LOTTO_NUMBERS) {
            throw new RuntimeException("입력된 숫자는 중복 없는 6자리 숫자여야 합니다.");
        }
    }

    private void checkLottoNumberRange(int number) {
        if (number < Lotto.LOTTO_MIN_NUMBER_RANGE || number > Lotto.LOTTO_MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

}

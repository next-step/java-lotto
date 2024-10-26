package lotto.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ManualLottoMachine {

    private ManualLottoMachine() {

    }

    public static List<Lotto> createLotto(int inputMoney, int manualCount, List<String[]> manualTexts) {
        validate(inputMoney, manualCount, manualTexts);
        List<Lotto> result = new ArrayList<>();
        for (String[] manualText : manualTexts) {
            Set<LottoNumber> lottoNumbers = LottoText.ofValues(manualText);
            result.add(Lotto.valueOf(lottoNumbers));
        }
        return result;
    }

    private static void validate(int inputMoney, int manualCount, List<String[]> manualTexts) {
        validateManualCount(inputMoney, manualCount);
        validateManualSize(manualCount, manualTexts);
    }

    private static void validateManualCount(int inputMoney, int manualCount) {
        int lottoCount = LottoMoney.getLottoCount(inputMoney);

        if (manualCount > lottoCount) {
            throw new IllegalArgumentException("로또 금액 보다 수동 갯수가 더 큽니다");
        }
    }

    private static void validateManualSize(int manualCount, List<String[]> manualTexts) {
        if (manualCount != manualTexts.size()) {
            throw new IllegalArgumentException("수동입력 갯수와 수동 번호 리스트 갯수가 맞지 않습니다");
        }
    }
}

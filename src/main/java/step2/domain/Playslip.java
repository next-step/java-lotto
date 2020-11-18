package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playslip {
    public static final String ONLY_POSITIVE_NUMBERS = "선택은 1개 이상만 가능합니다.";
    public static final List<Integer> NUMBER_POOL = makeNumberPool();
    private static final int MAX_SELECT_NUMBER = 45;
    public static final int SELECTION_COUNT = 6;

    private final NaturalSelection selection = new NaturalSelection();

    public List<LotteryNumber> selectNumbers(int numberSet) {
        if (numberSet < 1) {
            throw new IllegalArgumentException(ONLY_POSITIVE_NUMBERS);
        }

        List<LotteryNumber> result = new ArrayList<>();
        for (int i = 0; i < numberSet; i++) {
            result.add(new LotteryNumber(selection.select(NUMBER_POOL, SELECTION_COUNT)));
        }
        return result;
    }


    public void setManualSelection(ManualSelection manualSelection) {

    }

    private static List<Integer> makeNumberPool() {
        List<Integer> selectableNumberSource = new ArrayList<>();
        for (int i = 0; i < MAX_SELECT_NUMBER; i++) {
            selectableNumberSource.add(i + 1);
        }
        return Collections.unmodifiableList(selectableNumberSource);
    }
}

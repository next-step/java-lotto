package step2.domain;

import java.util.*;

public class Playslip {
    public static final String ONLY_POSITIVE_NUMBERS = "선택은 1개 이상만 가능합니다.";
    public static final List<Integer> NUMBER_POOL = makeNumberPool();
    private static final int MAX_SELECT_NUMBER = 45;
    public static final int SELECTION_COUNT = 6;

    private final NaturalSelection naturalSelection = new NaturalSelection();
    private ManualSelection manualSelection = new ManualSelection();
    private int selectNumberCount;

    public Set<LotteryNumber> selectNumbers(int numberSet) {
        if (numberSet < 1) {
            throw new IllegalArgumentException(ONLY_POSITIVE_NUMBERS);
        }

        Set<LotteryNumber> result = new HashSet<>();
        result.addAll(manualSelection.getLotteryNumbers());
        result.addAll(getNaturalSelectionNumbers(numberSet));
        return result;
    }

    public void setManualSelection(ManualSelection manualSelection) {
        this.manualSelection = manualSelection;
    }

    public int getManualSelectionCount() {
        return manualSelection.size();
    }

    private Set<LotteryNumber> getNaturalSelectionNumbers(int numberSet) {
        Set<LotteryNumber> result = new HashSet<>();
        if (selectNumberCount == 0) {
            selectNumberCount = numberSet;
        }
        int naturalSelectionCount = selectNumberCount - getManualSelectionCount();
        for (int i = 0; i < naturalSelectionCount; i++) {
            result.add(new LotteryNumber(naturalSelection.select(NUMBER_POOL, SELECTION_COUNT)));
        }
        return result;
    }

    private static List<Integer> makeNumberPool() {
        List<Integer> selectableNumberSource = new ArrayList<>();
        for (int i = 0; i < MAX_SELECT_NUMBER; i++) {
            selectableNumberSource.add(i + 1);
        }
        return Collections.unmodifiableList(selectableNumberSource);
    }
}

package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLotto {
    private final List<String> numberTexts;

    public ManualLotto(List<String> numberTexts) {
        this.numberTexts = new ArrayList<>(numberTexts);
    }

    public static ManualLotto of(List<String> numberTexts) {
        return new ManualLotto(numberTexts);
    }

    public List<String> getNumberTexts() {
        return numberTexts;
    }

    public int size() {
        return numberTexts.size();
    }
}

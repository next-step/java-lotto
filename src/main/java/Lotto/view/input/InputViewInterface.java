package Lotto.view.input;

import java.util.function.Predicate;

public interface InputViewInterface {
    int getNumberInput();

    int[] getNumberListInput();

    int getValidatedNumberInput(Predicate<Integer> validator, String errorMessage);
}

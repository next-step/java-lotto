package lotto.view;

public interface InputViewInterface {
    int getNumberInput(String message);

    String[] getStringListInput(String message, String delimiter);
}

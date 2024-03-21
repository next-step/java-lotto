package lotto.domain;

public class WinNumber {

    private static final String DELIMETER = ",";
    private static final int WIN_NUMBERS_SIZE = 6;

    public int[] createWinNumbers(String input) {
        String[] winTextNumbers = splitInput(input);
        if (!hasSize(winTextNumbers)) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        return parseInt(winTextNumbers);
    }

    private String[] splitInput(String input) {
        return input.split(DELIMETER);
    }

    private boolean hasSize(String[] winNumbers) {
        return winNumbers.length == WIN_NUMBERS_SIZE;
    }

    private int[] parseInt(String[] winTextNumbers) {
        int[] winNumbers = new int[WIN_NUMBERS_SIZE];
        for (int i = 0; i < winTextNumbers.length; i++) {
            winNumbers[i] = parseInt(winTextNumbers[i]);
        }
        return winNumbers;
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }
}

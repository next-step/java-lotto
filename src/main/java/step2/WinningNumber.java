package step2;

public class WinningNumber {

    private WinningNumber() {
    }

    public static int[] getWinnerNumberList(String winningNumber){
        String[] winningNumbers = winningNumber.split(",");
        int[] result = new int[winningNumbers.length];
        for (int i = 0; i < winningNumbers.length; i++) {
            String winningNum = winningNumbers[i];
            winningNum = winningNum.trim();
            result[i] = Integer.parseInt(winningNum);
        }
        return result;
    }
}

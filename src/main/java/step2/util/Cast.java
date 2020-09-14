package step2.util;

public class Cast {
    public static int[] castToNumber(String winningNumber) {
        // 당첨 번호 string -> int 형변환
        String[] tempNo = winningNumber.split(",");
        int[] numbers = new int[tempNo.length];
        for(int i = 0; i < tempNo.length; i++) {
            numbers[i] = Integer.parseInt(tempNo[i]);
        }
        return numbers;
    }
}

package step3.util;

public class Cast {
    public static Long[] castToNumber(String winningNumber) {
        // 당첨 번호 string -> int 형변환
        String[] tempNo = winningNumber.split(",");
        Long[] numbers = new Long[tempNo.length];
        for(int i = 0; i < tempNo.length; i++) {
            numbers[i] = Long.valueOf(Integer.parseInt(tempNo[i]));
        }
        return numbers;
    }
}

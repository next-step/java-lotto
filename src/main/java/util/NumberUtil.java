package util;

public class NumberUtil {

    public static int stringToInt(String number) {
        int parseInt = Integer.parseInt(number);
        if(parseInt < 0){
            throw new RuntimeException("음수는 입력될 수 없습니다.");
        }
        return parseInt;
    }
}

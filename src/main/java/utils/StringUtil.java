package utils;

public class StringUtil {

    public static String[] spliter(String stringWord) {
        if (stringWord == null || stringWord.trim().isEmpty()) {
            throw new IllegalArgumentException("로또 당첨 번호는 빈 값일 수 없습니다.");
        }

        return stringWord.replaceAll("\\p{Z}", "").split(",");
    }

}

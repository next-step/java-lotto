package cmm.util;

import java.util.Scanner;

public class InputUtil {
    public static Scanner scanner = new Scanner(System.in);

    public static int returnInteger(String question) {
        System.out.println(question);
        int result = scanner.nextInt();
        if(result < 0) {
            throw new IllegalArgumentException("음수는 입력이 불가능합니다.");
        }
        scanner.nextLine(); //개행문자(엔터)를 제거하기위해 추가
        return result;
    }

    public static String returnString(String question) {
        System.out.println(question);
        return returnStringWithBlank();
    }

    public static String returnStringWithBlank() {
        return scanner.nextLine();
    }
}

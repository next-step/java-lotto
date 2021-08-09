package stringaddcalculator;

import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputView() {
        System.out.println("덧셈이 필요한 문자열을 입력하세요.(기본 구분자: \",\", \":\")");
        System.out.println("별도 구분자 필요 시 오른쪽과 같은 형태로 입력 해주세요. \"//;\\n1;2;3\")");
        return scanner.next();
    }

    public static void outputView(int result) {
        System.out.println("결과는 " + result + " 입니다.");
    }


}

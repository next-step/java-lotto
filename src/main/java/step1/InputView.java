package step1;

import java.util.Scanner;

public class InputView {

    protected String inputNumbers() {

        System.out.println("문자열 덧셈기를 구동합니다. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 입력하세요.");
        System.out.println("커스터 마이징 가능!! “//”와 “\\\\n” 사이에 위치하는 문자구를 구분자로 사용가능합니다.");
        System.out.println("예를 들어 “//;\\\\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환.");

        Scanner scan = new Scanner(System.in);
        String addNumbers = scan.nextLine();

        return addNumbers;
    }


}

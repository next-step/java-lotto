package calculator.view;


public class InputView {

    private static final String INPUT_VIEW_MESSAGE = "숫자와 연잔를 입력한 후, 빈 공백으로 구분자를 입력하시오. ex:) 2 + 3 * 4 / 2";

    public void view(){
        System.out.println(INPUT_VIEW_MESSAGE);
    }

    public static String[] splitFormula(String formula) {
        return formula.split(" ");
    }

}

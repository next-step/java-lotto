package calculator.view;

public class ResultView {

    private static final String RESULT_MESSAGE = "연산 결과 : ";

    private ResultView(){

    }

    public static void resultCalculator(int data){
        System.out.println(RESULT_MESSAGE + data);
    }
}

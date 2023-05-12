package calculator.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleView {

    public String inputExpression() {
        printAskingInput();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            return br.readLine();
        } catch (Exception e) {
            throw new RuntimeException("입력을 받아오는데 실패하였습니다", e);
        }
    }

    private void printAskingInput() {
        System.out.println("식을 입력해주세요 : ");
    }

    public void printResult(Object result) {
        System.out.println(result);
    }
}

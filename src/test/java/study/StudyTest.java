package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StudyTest {

    @Test
    public void test(){
        String text = "1 2 3 + 4";
        String[] splitText = text.split(" ");
        for (int index = 0; index < splitText.length; index++) {
            // 숫자
            if (index % 2 ==  0) {
                System.out.println("숫자 : " + splitText[index]);
            }

            // 연산자
            if (index % 2 ==  1) {
                List<String> operators = Arrays.asList("+", "-", "*", "/");
                if(operators.contains(splitText[index])){

                }
                System.out.println("연산자 : " + splitText[index]);
            }
        }
    }
}

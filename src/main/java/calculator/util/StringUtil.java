package calculator.util;

public class StringUtil {

    public void checkNullOrEmpty(String string){
        if(string==null||string.isEmpty()||string.equals("")){
            throw new IllegalArgumentException("이름이 Null 혹은 빈문자열 입니다.");
        }
    }
}

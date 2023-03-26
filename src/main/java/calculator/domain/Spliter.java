package calculator.domain;

public class Spliter {

    public static String split(String input, Delimeter delimeter){
        if(delimeter.isExistCustomDelimeter()){
            return input.substring(input.indexOf("\\n") + 2, input.length());
        }
        return input;
    }
}

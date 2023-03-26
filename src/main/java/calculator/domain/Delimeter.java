package calculator.domain;

public class Delimeter {

    private static final char base1 = ',';
    private static final char base2 = ':';
    private char customDelimeter;

    public Delimeter(String input){
        if(isExistCustomDelimeter(input)){
            findCustomDelimeter(input);
        }
    }

    public boolean isExistCustomDelimeter(){
        if(customDelimeter == ' '){
            return false;
        }
        return true;
    }
    private boolean isExistCustomDelimeter(String input){
        if(input.indexOf("//") == -1){
            customDelimeter = ' ';
            return false;
        }
        return true;
    }

    public void findCustomDelimeter(String input){
        String subStringInput = input.substring(input.indexOf("//") + 2, input.length());
        String subStringInput2 = subStringInput.substring(0, subStringInput.indexOf("\\n"));
        customDelimeter = subStringInput2.charAt(0);
    }

    public boolean isDelimeter(char ch){
        if(ch == base1){
            return true;
        }
        if(ch == base2){
            return true;
        }
        if(ch == customDelimeter){
            return true;
        }
        return false;
    }
}

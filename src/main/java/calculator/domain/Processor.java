package calculator.domain;

import java.util.Stack;

public class Processor {
    private Delimeter delimeter;
    private int num;
    private int result;
    private Stack stack;

    public int calculate(String input){
        delimeter = new Delimeter(input);
        String str = Spliter.split(input, delimeter) + ",";
        stack = new Stack();
        for(char ch : str.toCharArray()){
            solve(selectCharacterType(ch), ch);
        }
        return result;
    }

    public CharacterType selectCharacterType(char ch){
        if(delimeter.isDelimeter(ch)){
            return CharacterType.DELIMETER;
        }
        if(Character.isDigit(ch)){
            return CharacterType.NUMBER;
        }
        return CharacterType.NOT_DEFINED;
    }

    public void solve(CharacterType characterType, char ch){
        if(characterType.equals(CharacterType.NUMBER)){
            stack.push(ch);
        }
        if(characterType.equals(CharacterType.DELIMETER)){
            calculate();
        }
        if(characterType.equals(CharacterType.NOT_DEFINED)){
            throw new RuntimeException("숫자 이외의 값 또는 음수는 실행할 수 없습니다.");
        }
    }

    public void calculate(){
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        num = Integer.parseInt(sb.reverse().toString());
        result += num;
    }
}

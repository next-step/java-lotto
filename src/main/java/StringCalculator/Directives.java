package StringCalculator;

import java.util.ArrayList;
import java.util.List;

public class Directives {

    private final List<String> directives;

    public Directives(String[] list) {
        directives = new ArrayList<>();
        for (String s : list) {
            createDirectives(s);
        }
    }

    private void createDirectives(String s){
        if (matchDirective(s)){
            this.directives.add(s);
        }
    }

    public int getDirectivesSize(){
        return this.directives.size();
    }

    public Operator findOperator(int i){
        if (this.matchDirective(directives.get(i))){
            return Operator.findOperator(directives.get(i));
        }
        System.out.println("형식에 맞는 기호가 아닙니다.");
        throw new IllegalArgumentException();
    }

    private boolean matchDirective(String s){
        return s.matches("[+\\-/\\*]");
    }


}

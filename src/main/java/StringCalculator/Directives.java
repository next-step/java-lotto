package StringCalculator;

import java.util.ArrayList;
import java.util.List;

public class Directives {

    private final List<String> directives;
    private final Numbers numbers;

    public Directives(String[] list) {
        directives = new ArrayList<>();
        for (String s : list) {
            createDirectives(s);
        }

        this.numbers = new Numbers(list);
    }

    public int calculate(){
        int result = 0;
        for (int i = 0; i < directives.size(); i++) {
            String directive = directives.get(i);
            result = this.numbers.interact(directive, result, i);
        }
        return result;
    }

    private void createDirectives(String s){
        if (matchDirective(s)){
            this.directives.add(s);
        }
    }

    private boolean matchDirective(String s){
        return s.matches("[+\\-/\\*]");
    }


}

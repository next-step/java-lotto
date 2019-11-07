package lotto.view;

public class TerminalViewer implements Viewer {
    private static final String EMPTY_STRING = "";

    @Override
    public void print(String result, String comment) {
        if (comment.equals(EMPTY_STRING) == false) {
            System.out.println(comment);
        }
        System.out.println(result);
    }
}

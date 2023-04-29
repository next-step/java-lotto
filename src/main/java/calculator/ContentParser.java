package calculator;

import calculator.domain.Content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContentParser {
    private final String content;

    public ContentParser(String content) {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.");
        }
        this.content = content;
    }
    public List<Content> parse() {
        List<Content> list = new ArrayList<>();
        for (String s : content.split(" ")) {
            list.add(new Content(s));
        }
        return list;
    }
}

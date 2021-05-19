# 로또

- Github 기반으로 온라인 코드 리뷰하는 경험
- TDD 기반으로 프로그래밍하는 경험
- 메소드 분리 + 클래스를 분리하는 리팩토링 경험
- 점진적으로 리팩토링하는 경험

## 진행 방법

- 로또 요구사항을 파악한다.
- 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
- 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
- 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

---

## Steps

1. [학습 테스트 실습](doc/01.md)
2. [문자열 덧셈 계산기](doc/02.md)
3. [로또 (자동)](doc/03.md)
4. [로또 (2등)](doc/04.md)
5. [로또 (수동)](doc/05.md)

---

## 객체지향 생활 체조 원칙

1. 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
2. else 예약어를 쓰지 않는다.
3. 모든 원시값과 문자열을 포장한다.
4. 한 줄에 점을 하나만 찍는다.
5. 줄여쓰지 않는다(축약 금지).
6. 모든 엔티티를 작게 유지한다.
7. 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
8. 일급 콜렉션을 쓴다.
9. 게터/세터/프로퍼티를 쓰지 않는다.

---

## 온라인 코드 리뷰 과정

- [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## 코드 스타일

[캠퍼스 핵데이 Java 코딩 컨벤션](https://naver.github.io/hackday-conventions-java/)

1. IntelliJ IDEA → Preferences
2. Editor → Code Style → Java
   - Scheme: `naver-intellij-formatter.xml`
3. Tools → Checkstyle
   - version: `8.24`
   - Scan Scope: All sources (including tests)
   - Treat Checkstyle errors as warnings
   - `Lotto Checkstyle Rules`: `naver-checkstyle-rules.xml`
     - suppressionFile: `naver-checkstyle-suppressions.xml`
4. Save Actions
   - Active save actions on save
   - Reformat file

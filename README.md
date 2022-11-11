# 로또
## 기능명세서
- 문자열 계산기(StringCalculator.java)
- 로또(자동) 추첨 프로그램(AutoResultView.java)
- 로또(2등) 추첨 프로그램(AutoResultView.java)
- 로또 수동 추첨 프로그램(ManualResultView.java)

# Commit Message Convention
```html
<type>: <subject>
<body>
<footer>
```
- e.g) feat: add login api (#12)

# Type
```text
feat : 새로운 기능 추가, 기존의 기능을 요구 사항에 맞추어 수정
fix : 기능에 대한 버그 수정
build : 빌드 관련 수정
chore : 패키지 매니저 수정, 그 외 기타 수정 ex) .gitignore
ci : CI 관련 설정 수정
docs : 문서(주석) 수정
style : 코드 스타일, 포맷팅에 대한 수정
refactor : 기능의 변화가 아닌 코드 리팩터링 ex) 변수 이름 변경
test : 테스트 코드 추가/수정
release : 버전 릴리즈
```

# Subject
- 간략하게 어떠한 작업을 하였는지 작성한다.
   - e.g) feat: 3단계 자동차 경주 기능 구현

# Body
- Subject에서 작성하지 못한 상세 설명을 작성한다. 

# Footer
- 어떤 이슈에 대한 작업인지 이슈 번호를 작성한다.(#issue번호)
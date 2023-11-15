# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

### TODO

### DONE
- [X] reset() 제거 및 동시성 이슈를 감안한 static으로 구현
- [X] 주석 제거
- [X] parameter명 축약표현 개선
- [X] 상수 부분 final로 변경
- [X] 메소드 분리 (최대 10라인)
- [X] 여러 assert문이 있는 테스트 개선
- [X] 단위 테스트 네이밍 규칙 적용
- [X] 사칙연산 기호가 아닌 경우 발생하는 IllegalArgumentException에 잘못된 기호 표기
- [X] 빈값 및 null값 테스트 수정
- [X] enum 클래스 내부 멤버변수명 수정
- [X] Operator에 대한 테스트 추가

# 로또(자동)

## 구현할 기능 목록
1. 기본 숫자 (NumberGenerator)
    - 1~45 범위의 숫자를 가진 숫자 

2. 로또 (Lotto)
    - 로또 번호를 가진다
    - 랜덤 번호를 생성한다

3. 로또 머신 (LottoMachine)
    - 입력한 장 수 만큼 로또 생성 
                                                        
4. 상금 (Prize)
    - 일치 개수와 당첨금으로 상금 계산

// 5. 로또 당첨 확인기 (WinningChecker)
//    - 번호별 일치 개수 확인
                                                    
6. 로또 분석기 (LottoAnalyzer)
    - 당첨 수 확인 (3개일치 로또 - 1개)
    - 수익율 계산 

7. 로또 유틸 (LottoUtil)
    - 구매 장수 계산

8. LottoController
    - 로또 어플리케이션
--- 
## 구현할 기능 목록 (수정 진행중)
1. 당첨 번호 WinningNumbers
    - 당첨 번호를 가지는 컬렉션 객체
    - 문자열 당첨 번호를 숫자 리스트로 변환한다
    - 당첨 번호가 바른 값인지 확인한다.
    - 로또 번호 일치 개수를 확인 한다. getMatchCount();
        
---
## 궁금한 점
1. WinningNumbers 의 생성자와 convertWinningNumber 부분
    - String 주입 -> convertWinningNumber() 변환 부분을 외부에서 List<Integer>로 변환 후 값을 넘겨주는 형태가 나았을지?
    - 멤버 변수(List)와 다른 타입(String) 을 받아 가공 후 값을 주입하는 형태가 괜찮은 방법인지 궁금합니다.


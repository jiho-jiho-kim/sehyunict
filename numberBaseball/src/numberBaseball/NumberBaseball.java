package numberBaseball;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberBaseball {

	public static void main(String[] args) {

		// 숫자는 1~9까지, 숫자는 중복될 수 없다.
		// 숫자, 자리가 맞으면 strike, 숫자만 맞을 경우 ball, 아무것도 없으면 out.

		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		int com1, com2, com3;
		int user1, user2, user3;
		int rcount = 0;
		int playCount = 0;
		int strikeCount = 0, ballCount = 0;

		// 정수가 아닌 문자 에러 발생

		// 게임전체반복
		while (true) {
			
				// 중복되지 않는 3개의 난수생성
				while (true) {
					rcount++;
					// 1~9사이의 랜덤수생성
					com1 = r.nextInt(100) % 9 + 1;
					com2 = r.nextInt(100) % 9 + 1;
					com3 = r.nextInt(100) % 9 + 1;
					if (!(com1 == com2 || com2 == com3 || com3 == com1)) {
						// 중복되지 않는 난수 생성에 성공하면 루프탈출
						break;
					}

				}

				// 난수확인
				System.out.println(rcount + "회:" + com1 + " " + com2 + " " + com3);
				try {
				while (true) {
					// 사용자로부터 3개의 정수를 입력받는다.
					System.out.println("3개의정수를 입력하세요(1~9)");
					System.out.println("스페이스로 구분하시고 마지막에 Enter를 눌러주세요");
					user1 = sc.nextInt();
					user2 = sc.nextInt();
					user3 = sc.nextInt();

					// 게임카운트 1회 증가
					playCount++;

					// 스크라이크(숫자와 위치가 일치)
					if (com1 == user1) {
						strikeCount++;
					}
					if (com2 == user2) {
						strikeCount++;
					}
					if (com3 == user3) {
						strikeCount++;
					}

					// 볼(숫자만 일치)
					if (com1 == user2 || com1 == user3) {
						ballCount++;
					}
					if (com2 == user1 || com2 == user3) {
						ballCount++;
					}
					if (com3 == user1 || com3 == user2) {
						ballCount++;
					}

					// 게임종료판단
					if (strikeCount == 3) {
						System.out.println("3 스트라이크 정답 게임종료");
						System.out.println(playCount + "회차에 맞추셨습니다.");
						break;

					} else {
						// 하나도 못맞추는 경우
						if (strikeCount == 0 && ballCount == 0) {
							System.out.println("아웃입니다");
						} else {
							System.out.printf("%d스트라이크, %d볼\n", strikeCount, ballCount);
						}

						// 스트라이크, 볼 카운트 초기화
						strikeCount = 0;
						ballCount = 0;

					}

				}

			} catch (InputMismatchException e) {

				System.out.println("잘못 입력했습니다. 정수만 입력가능");

			} finally {
				System.out.println("한게임 더 하시겠습니까?(0:종료,1:재시작)");
				int restart = sc.nextInt();

				while (!(restart == 0 || restart == 1)) {
					System.out.println("\n==0:종료 또는 1:재시작을 눌러주세요.==\n");
					System.out.println("한게임 더 하시겠습니까?(0:종료,1:재시작)");
					restart = sc.nextInt();

				}
				if (restart == 0) {
					// 게임종료
					System.out.println("\n==게임이 종료되었습니다.==\n");
					System.exit(0);

				} else if (restart == 1) {
					// 게임을 재시작하기 위해 카운트변수 초기화
					strikeCount = 0;
					ballCount = 0;
					playCount = 0;
					System.out.println("\n==게임을 재시작합니다.==\n");

				}
			}

			

		}
	}

}

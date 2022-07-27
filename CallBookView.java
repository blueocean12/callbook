package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.CallBookController;
import dto.CallBookUserDTO;
import util.Constant;

public class CallBookView implements View{

	@Override
	public void showView() {
		Scanner scanner = new Scanner(System.in);
		//메뉴 초이스 화면
		while(true) {

			System.out.println("*************************************************");
			System.out.println("******************1. 전체 조회*********************");
			System.out.println("******************2. 친구 검색*********************");
			System.out.println("******************3. 번호 추가*********************");
			System.out.println("******************4. 번호 수정*********************");
			System.out.println("******************5. 번호 삭제*********************");
			System.out.println("******************6. 프로그램 종료******************");
			System.out.println("*************************************************");
			System.out.println("메뉴 선택 : ");
			int menuNumber = scanner.nextInt();
			//1. 메뉴 선택시 메뉴 관련해서 프로그램동작
			//2. 프로그램 종료 선택 시, 프로그램 종료

			//			this.menuHandling(menuNumber); => 계속 메뉴 화면 띄움


			if(this.menuHandling(menuNumber)) {
				break;

			}


		}

	}

	@Override
	public boolean menuHandling(int menuNumber) {
		boolean isMenuExit = false;
		switch(menuNumber) {
		case Constant.SELECT_ALL_USER :
			System.out.println("유저 전체 조회");
			CallBookView.selectAllUser();
			break;
		case Constant.SEARCH_USER :
			System.out.println("유저 검색 조회");
			CallBookView.searchUser();
			break;
		case Constant.INSERT_USER :
			System.out.println("유저 입력");
			CallBookView.insertUser();
			break;
		case Constant.UPDATE_USER :
			System.out.println("유저 수정");
			CallBookView.updateUser();
			break;
		case Constant.DELETE_USER :
			System.out.println("유저 삭제");
			CallBookView.deleteUser();
			break;
		case Constant.CALLBOOK_MENU_EXIT :
			isMenuExit = true;

			break;


		default :
			wrongMenuSelected();
			break;

		}


		return isMenuExit;
	}

	public static void insertUser() {
		Scanner scanner = new Scanner(System.in);
		CallBookUserDTO callBookUserDTO = new CallBookUserDTO();

		System.out.println("이름 입력 : ");
		String userName = scanner.next();
		callBookUserDTO.setName(userName);

		System.out.println("번호 입력 : ");
		String phoneNumber = scanner.next();
		callBookUserDTO.setphoneNumber(phoneNumber);

		callBookUserDTO.printUserInfo();

		CallBookController.insertUser(callBookUserDTO);
		//		System.out.println("---------------모든 유저---------------");


	}

	public static void selectAllUser() {
		System.out.println("-----------------모든 유저 조회----------------------");
		ArrayList<CallBookUserDTO> callBookUserList = CallBookController.selectAllUser();
		//컨트롤러에 어레이리스트 안의 DTO의 목록을 전부 가져와라
		for(int i=0; i<callBookUserList.size(); i++) {
			callBookUserList.get(i).printUserInfo();
		}

	}

	public static void searchUser() {
		System.out.println("-------------------친구 검색-------------------------");
		System.out.println("찾고자 하는 사람 입력 : " );
		Scanner scanner = new Scanner(System.in);
		String findUserName = scanner.next();
		CallBookUserDTO callBookUserDTO = CallBookController.searchUser(findUserName);

		if(callBookUserDTO.getName() != null) {
			callBookUserDTO.printUserInfo();
		}
		else {
			System.out.println("일치하는 유저는 없습니다.");
		}

	}

	public static void updateUser() {
		Scanner scanner = new Scanner(System.in);
		CallBookUserDTO updateinfo = new CallBookUserDTO();
		System.out.println("-------------------유저 수정-------------------------");
		System.out.println("찾고자 하는 사람 입력 : " );
		String findUserName = scanner.next();
		System.out.println("수정할 이름 입력 : ");
		updateinfo.setName(scanner.next());
		System.out.println("수정할 번호 입력 : ");
		updateinfo.setphoneNumber(scanner.next());

		CallBookUserDTO callBookUserDTO = CallBookController.updateUser(findUserName, updateinfo);

		if(callBookUserDTO.getName() != null) {
			callBookUserDTO.printUserInfo();

		}
		else {
			System.out.println("일치하는 유저는 없습니다.");
		}

	}
	public static void deleteUser() {
		System.out.println("-----------------번호 삭제--------------------------");
		System.out.println("삭제할 사람 이름 입력 : ");
		Scanner scanner = new Scanner(System.in);
		String findUserName = scanner.next();

		CallBookUserDTO callBookUserDTO = CallBookController.deleteUser(findUserName);

		if(callBookUserDTO.getName() != null) {
			System.out.println("정상적으로 삭제되었습니다.");

		}
		else {
			System.out.println("일치하는 유저가 없습니다.");
		}

	}



}

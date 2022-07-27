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
		//�޴� ���̽� ȭ��
		while(true) {

			System.out.println("*************************************************");
			System.out.println("******************1. ��ü ��ȸ*********************");
			System.out.println("******************2. ģ�� �˻�*********************");
			System.out.println("******************3. ��ȣ �߰�*********************");
			System.out.println("******************4. ��ȣ ����*********************");
			System.out.println("******************5. ��ȣ ����*********************");
			System.out.println("******************6. ���α׷� ����******************");
			System.out.println("*************************************************");
			System.out.println("�޴� ���� : ");
			int menuNumber = scanner.nextInt();
			//1. �޴� ���ý� �޴� �����ؼ� ���α׷�����
			//2. ���α׷� ���� ���� ��, ���α׷� ����

			//			this.menuHandling(menuNumber); => ��� �޴� ȭ�� ���


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
			System.out.println("���� ��ü ��ȸ");
			CallBookView.selectAllUser();
			break;
		case Constant.SEARCH_USER :
			System.out.println("���� �˻� ��ȸ");
			CallBookView.searchUser();
			break;
		case Constant.INSERT_USER :
			System.out.println("���� �Է�");
			CallBookView.insertUser();
			break;
		case Constant.UPDATE_USER :
			System.out.println("���� ����");
			CallBookView.updateUser();
			break;
		case Constant.DELETE_USER :
			System.out.println("���� ����");
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

		System.out.println("�̸� �Է� : ");
		String userName = scanner.next();
		callBookUserDTO.setName(userName);

		System.out.println("��ȣ �Է� : ");
		String phoneNumber = scanner.next();
		callBookUserDTO.setphoneNumber(phoneNumber);

		callBookUserDTO.printUserInfo();

		CallBookController.insertUser(callBookUserDTO);
		//		System.out.println("---------------��� ����---------------");


	}

	public static void selectAllUser() {
		System.out.println("-----------------��� ���� ��ȸ----------------------");
		ArrayList<CallBookUserDTO> callBookUserList = CallBookController.selectAllUser();
		//��Ʈ�ѷ��� ��̸���Ʈ ���� DTO�� ����� ���� �����Ͷ�
		for(int i=0; i<callBookUserList.size(); i++) {
			callBookUserList.get(i).printUserInfo();
		}

	}

	public static void searchUser() {
		System.out.println("-------------------ģ�� �˻�-------------------------");
		System.out.println("ã���� �ϴ� ��� �Է� : " );
		Scanner scanner = new Scanner(System.in);
		String findUserName = scanner.next();
		CallBookUserDTO callBookUserDTO = CallBookController.searchUser(findUserName);

		if(callBookUserDTO.getName() != null) {
			callBookUserDTO.printUserInfo();
		}
		else {
			System.out.println("��ġ�ϴ� ������ �����ϴ�.");
		}

	}

	public static void updateUser() {
		Scanner scanner = new Scanner(System.in);
		CallBookUserDTO updateinfo = new CallBookUserDTO();
		System.out.println("-------------------���� ����-------------------------");
		System.out.println("ã���� �ϴ� ��� �Է� : " );
		String findUserName = scanner.next();
		System.out.println("������ �̸� �Է� : ");
		updateinfo.setName(scanner.next());
		System.out.println("������ ��ȣ �Է� : ");
		updateinfo.setphoneNumber(scanner.next());

		CallBookUserDTO callBookUserDTO = CallBookController.updateUser(findUserName, updateinfo);

		if(callBookUserDTO.getName() != null) {
			callBookUserDTO.printUserInfo();

		}
		else {
			System.out.println("��ġ�ϴ� ������ �����ϴ�.");
		}

	}
	public static void deleteUser() {
		System.out.println("-----------------��ȣ ����--------------------------");
		System.out.println("������ ��� �̸� �Է� : ");
		Scanner scanner = new Scanner(System.in);
		String findUserName = scanner.next();

		CallBookUserDTO callBookUserDTO = CallBookController.deleteUser(findUserName);

		if(callBookUserDTO.getName() != null) {
			System.out.println("���������� �����Ǿ����ϴ�.");

		}
		else {
			System.out.println("��ġ�ϴ� ������ �����ϴ�.");
		}

	}



}

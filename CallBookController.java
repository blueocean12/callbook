package controller;

import java.util.ArrayList;

import db.CallBookDB;
import dto.CallBookUserDTO;

public class CallBookController {
	
	
	public static  void insertUser(CallBookUserDTO callBookUserDTO) {
		CallBookDB.insert(callBookUserDTO);
	}

	public static ArrayList<CallBookUserDTO> selectAllUser() {
		return CallBookDB.selectAllUser();
	}
	
	public static CallBookUserDTO searchUser(String findUserName) {
		return CallBookDB.searchUser(findUserName);
	}

	public static CallBookUserDTO updateUser(String findUserName, CallBookUserDTO updateinfo) {
		return CallBookDB.updateUser(findUserName, updateinfo);
	}

	public static CallBookUserDTO deleteUser(String findUserName) {
		// TODO Auto-generated method stub
		return CallBookDB.deleteUser(findUserName) ;
	}
	
	
}
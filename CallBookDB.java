package db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import dto.CallBookUserDTO;
import util.Constant;

public class CallBookDB {
	public static void insert(CallBookUserDTO callBookUser) {
		CSVWriter writer;
		try {
			writer = new CSVWriter(new FileWriter(Constant.CALLBOOK_FILE_PATH, true));
			String lineArr[] = {callBookUser.getName(), callBookUser.getPhonenumber()};
			writer.writeNext(lineArr);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		// ÀÎÇ² ¾Æ¿ôÇ²ÀÇ ¿¹¿Ü´Â  IOException catch·Î ¹Þ¾Æ¶ó


	}


	public static ArrayList<CallBookUserDTO> selectAllUser(){
		ArrayList<CallBookUserDTO> callBookUserList = new ArrayList<>();

		try {
			CSVReader reader = new CSVReader(new FileReader(Constant.CALLBOOK_FILE_PATH));
			String[] nextLine;

			while((nextLine = reader.readNext()) != null) {
				CallBookUserDTO tempCallBookUser = new CallBookUserDTO();
				tempCallBookUser.setName(nextLine[0]);
				tempCallBookUser.setphoneNumber(nextLine[1]);
				callBookUserList.add(tempCallBookUser);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return callBookUserList;
	}

	public static CallBookUserDTO searchUser(String findUserName){
		CallBookUserDTO callBookUser = new CallBookUserDTO();

		try {
			CSVReader reader = new CSVReader(new FileReader(Constant.CALLBOOK_FILE_PATH));
			String[] nextLine;

			while((nextLine = reader.readNext()) != null) {
				if(nextLine[0].compareTo(findUserName) == 0) {
					callBookUser.setName(nextLine[0]);
					callBookUser.setphoneNumber(nextLine[1]);
					break;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return callBookUser;







	}
	public static CallBookUserDTO updateUser(String findUserName, CallBookUserDTO updateinfo){

		CallBookUserDTO result = new CallBookUserDTO();

		try {
			CSVReader reader = new CSVReader(new FileReader(Constant.CALLBOOK_FILE_PATH));

			List<String[]> csvBody = reader.readAll();
			for(int i = 0; i<csvBody.size(); i++) {
				if(csvBody.get(i)[0].compareTo(findUserName) == 0) {
					csvBody.get(i)[0] = updateinfo.getName();
					csvBody.get(i)[1] = updateinfo.getPhonenumber();

					result.setName(updateinfo.getName());
					result.setphoneNumber(updateinfo.getPhonenumber());
					break;

				}
			}

			CSVWriter writer = new CSVWriter(new FileWriter(Constant.CALLBOOK_FILE_PATH));
			writer.writeAll(csvBody);
			writer.flush();
			writer.close();

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CsvException e) {
			e.printStackTrace();
		}


		return result;



	}
	public static CallBookUserDTO deleteUser(String findUserName){

		CallBookUserDTO result = new CallBookUserDTO();

		try {
			CSVReader reader = new CSVReader(new FileReader(Constant.CALLBOOK_FILE_PATH));

			List<String[]> csvBody = reader.readAll();
			for(int i = 0; i<csvBody.size(); i++) {
				if(csvBody.get(i)[0].compareTo(findUserName) == 0) {


					result.setName(csvBody.get(i)[0]);
					result.setphoneNumber(csvBody.get(i)[1]);


					csvBody.remove(i);
					break;

				}
			}

			CSVWriter writer = new CSVWriter(new FileWriter(Constant.CALLBOOK_FILE_PATH));
			writer.writeAll(csvBody);
			writer.flush();
			writer.close();

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CsvException e) {
			e.printStackTrace();
		}


		return result;



	}


}



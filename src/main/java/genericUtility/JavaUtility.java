package genericUtility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;

import com.github.javafaker.Faker;

public class JavaUtility {
	Faker fk = new Faker();

	public int randomNumber(int i) {
		Random random = new Random();
		int rand = 0;
		while (true){
		    rand = random.nextInt(i);
		    if(rand !=0) break;
		}
		
		return rand;
	}
	
	

	public String fakeData(String requiredData) {
		if (requiredData.equalsIgnoreCase("fullname")) {
			return fk.name().fullName();
		} else if (requiredData.equalsIgnoreCase("username")) {
			return fk.name().username();
		} else if (requiredData.equalsIgnoreCase("mobile")) {
			return fk.number().digits(10);
		} else if (requiredData.equalsIgnoreCase("email")) {
			return fk.internet().emailAddress();
		} else if (requiredData.equalsIgnoreCase("password")) {
			return fk.internet().password();
		} else if (requiredData.equalsIgnoreCase("firstname")) {
			return fk.name().firstName();
		}else if (requiredData.equalsIgnoreCase("lastname")) {
			return fk.name().lastName();
		}else if (requiredData.equalsIgnoreCase("pincode")) {
			return fk.number().digits(6);
		}else {
			return "enter valid argument";
		}

	}

//	public ArrayList<String> getFakeUserCredentials() {
//		ArrayList<String> userCredentials = new ArrayList<String>();
//		userCredentials.add(fk.name().fullName());
//		userCredentials.add(fk.name().username());
//		userCredentials.add(fk.number().digits(10));
//		userCredentials.add(fk.internet().emailAddress());
//		String password = fk.internet().password();
//		userCredentials.add(password);
//		userCredentials.add(password);
//		return userCredentials;
//
//	}

	public HashMap<String, String> getFakeUserCredentialsMap() throws EncryptedDocumentException, IOException {

		ExcelFileUtility eUtil = new ExcelFileUtility();
		HashMap<String, String> mapList = new HashMap<String, String>();
		String password = null;
		for (int i = 0; i <= 5; i++) {
			String temp = eUtil.readDataFromExcel("userdata", 0, i);
			if (temp.equalsIgnoreCase("fullname")) {
				mapList.put(temp, fk.book().title());
			} else if (temp.equalsIgnoreCase("username")) {
				mapList.put(temp, fk.name().username());
			} else if (temp.equalsIgnoreCase("mobile")) {
				mapList.put(temp, fk.number().digits(10));
			} else if (temp.equalsIgnoreCase("email")) {
				mapList.put(temp, fk.internet().emailAddress());
			} else if (temp.equalsIgnoreCase("password")) {
				password = fk.internet().password();
				mapList.put(temp, password);
			} else if (temp.equalsIgnoreCase("ConfirmPassword")) {
				mapList.put(temp, password);
			}

		}
		return mapList;
	}


	public HashMap<String, String> getFakeIndividualHouseData(String sheetname) throws EncryptedDocumentException, IOException {

		ExcelFileUtility eUtil = new ExcelFileUtility();
		HashMap<String, String> mapList = new HashMap<String, String>();
		for (int i = 0; i <= 15; i++) {
			String temp = eUtil.readDataFromExcel(sheetname, 0, i);
			if (temp.equalsIgnoreCase("fullname")) {
				mapList.put(temp, fk.name().fullName());
			} else if (temp.equalsIgnoreCase("mobile")) {
				mapList.put(temp, fk.number().digits(10));
			} else if (temp.equalsIgnoreCase("altmobile")) {
				mapList.put(temp, fk.number().digits(10));
			} else if (temp.equalsIgnoreCase("email")) {
				mapList.put(temp, fk.internet().emailAddress());
			} else if (temp.toLowerCase().contains("plot/home")) {
				mapList.put(temp, fk.number().digits(3));
			} else if (temp.equalsIgnoreCase("availRooms")) {
				mapList.put(temp, this.randomNumber(4) + "BHK");
			} else if (temp.equalsIgnoreCase("country")) {
				mapList.put(temp, fk.address().country());
			} else if (temp.equalsIgnoreCase("state")) {
				mapList.put(temp, fk.address().state());
			} else if (temp.equalsIgnoreCase("city")) {
				mapList.put(temp, fk.address().city());
			} else if (temp.equalsIgnoreCase("rent")) {
				mapList.put(temp, fk.number().digits(4));
			} else if (temp.equalsIgnoreCase("sale")) {
				mapList.put(temp, fk.number().digits(4));
			} else if (temp.equalsIgnoreCase("deposite")) {
				mapList.put(temp, fk.number().digits(5));
			} else if (temp.equalsIgnoreCase("facilities")) {
				mapList.put(temp, fk.lorem().characters(15));
			} else if (temp.equalsIgnoreCase("description")) {
				mapList.put(temp, fk.lorem().characters(10));
			} else if (temp.equalsIgnoreCase("landmark")) {
				mapList.put(temp, fk.address().streetName());
			} else if (temp.equalsIgnoreCase("address")) {
				mapList.put(temp, fk.address().streetAddress());
			}
		}
		return mapList;
	}

	public HashMap<String, String> getApartmentData(String sheetname) throws EncryptedDocumentException, IOException {

		ExcelFileUtility eUtil = new ExcelFileUtility();
		
		HashMap<String, String> mapList = new HashMap<String, String>();
		for (int i = 0; i <=9 ; i++) {
			String temp = eUtil.readDataFromExcel(sheetname, 0, i);
			if (temp.equalsIgnoreCase("ApartmentName")) {
				mapList.put(temp, fk.book().title());
			} else if (temp.equalsIgnoreCase("mobile")) {
				mapList.put(temp, fk.number().digits(10));
			} else if (temp.equalsIgnoreCase("altmobile")) {
				mapList.put(temp, fk.number().digits(10));
			} else if (temp.equalsIgnoreCase("email")) {
				mapList.put(temp, fk.internet().emailAddress());
			} else if (temp.toLowerCase().contains("plot/home")) {
				mapList.put(temp, fk.number().digits(3));
			} else if (temp.equalsIgnoreCase("country")) {
				mapList.put(temp, fk.address().country());
			} else if (temp.equalsIgnoreCase("state")) {
				mapList.put(temp, fk.address().state());
			} else if (temp.equalsIgnoreCase("city")) {
				mapList.put(temp, fk.address().city());
			} else if (temp.equalsIgnoreCase("landmark")) {
				mapList.put(temp, fk.address().streetName());
			} else if (temp.equalsIgnoreCase("address")) {
				mapList.put(temp, fk.address().streetAddress());
			}

		}
		return mapList;
	}

	public HashMap<String, String> getApartmentRoomData(String sheetName) throws EncryptedDocumentException, IOException {

		ExcelFileUtility eUtil = new ExcelFileUtility();
		HashMap<String, String> mapList = new HashMap<String, String>();
		for (int i = 0; i <= 8; i++) {
			String temp = eUtil.readDataFromExcel(sheetName, 0, i);
			if (temp.equalsIgnoreCase("FullName")) {
				mapList.put(temp, fk.name().fullName());
			} else if (temp.equalsIgnoreCase("FlatNumber")) {
				mapList.put(temp, fk.number().digits(3));
			} else if (temp.equalsIgnoreCase("Rooms")) {
				mapList.put(temp, this.randomNumber(4) + "BHK");
			} else if (temp.equalsIgnoreCase("Area")) {
				mapList.put(temp, fk.address().streetName());
			} else if (temp.equalsIgnoreCase("rent")) {
				mapList.put(temp, fk.number().digits(4));
			} else if (temp.equalsIgnoreCase("deposite")) {
				mapList.put(temp, fk.number().digits(5));
			} else if (temp.equalsIgnoreCase("facilities")) {
				mapList.put(temp, fk.lorem().characters(15));
			} else if (temp.equalsIgnoreCase("description")) {
				mapList.put(temp, fk.lorem().characters(10));
			} 

		}
		return mapList;
	}

}

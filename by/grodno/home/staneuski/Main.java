package by.grodno.home.staneuski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Creates new object Notepad and keep records
 * Notepad allows:
 * append new records;
 * show all records;
 * delete records;
 * edit records. 
 * @author sergey
 *
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("App was started...");
		Notepad notepad = new Notepad();
		String userSelect;
		while(!(userSelect = showUserMenu()).equals("5")){
			switch(userSelect){
			case "1":
				ReadWriteToNotepad.addNewRecord(notepad);   //add new records
				break;
			case "2":
				ReadWriteToNotepad.showAllRecords(notepad); //show all records
				break;
			case "3":
				ReadWriteToNotepad.deleteRecord(notepad);   //delete record
				break;
			case "4":
				ReadWriteToNotepad.EditRecord(notepad);     //edit record
				break;
			}
		}
		System.out.println("App was ended.");
	}
	
	private static String showUserMenu() throws IOException{
		System.out.println("1 - add new; 2 - show all; 3 - delete; 4 - edit; 5 - exit");
		System.out.print("Select your action:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String userSelect = null;
		//check for correct selection
		boolean rightSelection = false;
		String selections[] = {"1","2","3","4","5"};
		while (!rightSelection){
			userSelect = reader.readLine();
			for (int i = 0; i < selections.length; i++){
				if (userSelect.equals(selections[i])){
					rightSelection = true;
					break;
				}
			}
			if (!rightSelection) System.out.print("Wrong option! Select your action:");
		}
		return userSelect;
	}

}

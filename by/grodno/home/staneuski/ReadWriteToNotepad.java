package by.grodno.home.staneuski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * realize main actions
 * with records
 * @author sergey
 *
 */
public class ReadWriteToNotepad {
	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * append new records to array
	 * @param notepad
	 * @throws IOException
	 */
	protected static void addNewRecord(Notepad notepad) throws IOException{
	
		System.out.println("Type new string:");
		String inputString;
		int countOfNewRecords = 0;
		while (!(inputString = reader.readLine()).equals("")) {
			//check for max index
			if (notepad.lastIndexNotepad >= notepad.notepadContent.length){
				System.out.println("Not enough space in notepad!");
				break;
			}
			notepad.notepadContent[notepad.lastIndexNotepad] = inputString;
	        notepad.lastIndexNotepad++;
	        countOfNewRecords++;
	    }
		System.out.println(countOfNewRecords+" records was added to notepad.");
	}
	
	/**
	 * shows all records of array
	 * @param notepad
	 */
	protected static void showAllRecords(Notepad notepad){
		
		System.out.println("Current content of notepad:");
		System.out.println("");
		for(int i = 0; i < notepad.lastIndexNotepad; i++){
			System.out.println((i+1)+": "+notepad.notepadContent[i]);
		}
		System.out.println("");
	}
	
	/**
	 * deletes record from array
	 * and shifts following indexes
	 * @param notepad
	 * @throws IOException
	 */
	protected static void deleteRecord(Notepad notepad) throws IOException{
		int indexForDeleting = -1;
		while(true){
			System.out.println("Enter number of row for deleting:");
			try{
				indexForDeleting = Integer.parseInt(reader.readLine());
			}
			catch(NumberFormatException e){
				System.out.println("You entering not a number!");
				continue;
			}
			if (indexForDeleting > 0 && indexForDeleting <= notepad.lastIndexNotepad) break;
			else System.out.println("this row does not exist.");
		}
		//deleting row
		for(int i = indexForDeleting; i < notepad.notepadContent.length - 1; i++){
			notepad.notepadContent[i-1] = notepad.notepadContent[i];
		}
		notepad.lastIndexNotepad--;
		System.out.println("row number "+indexForDeleting+" has been deleted.");
	}
	
	/**
	 * replacement record with new string
	 * @param notepad
	 * @throws IOException
	 */
	protected static void EditRecord(Notepad notepad) throws IOException{
		int indexForEdit = -1;
		while(true){
			System.out.println("Enter number of row for edit:");
			try{
				indexForEdit = Integer.parseInt(reader.readLine());
			}
			catch(NumberFormatException e){
				System.out.println("You entering not a number!");
				continue;
			}
			if (indexForEdit > 0 && indexForEdit <= notepad.lastIndexNotepad) break;
			else System.out.println("this row does not exist.");
		}
		System.out.print("Initial string is: ");
		System.out.println(notepad.notepadContent[indexForEdit]);
		System.out.print("Enter new string:");
		String newString = reader.readLine();
		notepad.notepadContent[indexForEdit - 1] = newString;
		System.out.println("String number "+indexForEdit+" was changed.");
	}
}

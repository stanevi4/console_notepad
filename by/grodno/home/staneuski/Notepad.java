package by.grodno.home.staneuski;

/**
 * objects of this class stores 
 * data entered by the user from console.
 * parameter notepadContent has limit size.
 * parameter lastIndexNotepad stores number
 * of entered rows in array notepadContent[].
 * @author sergey
 *
 */
public class Notepad {
	protected String[] notepadContent = new String[100]; //limit size if using array
	protected int lastIndexNotepad = 0; //index for adding new record
}

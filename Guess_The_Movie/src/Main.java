import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;
import java.util.Scanner; // need to use user input
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException { // if file CANNOT be opened
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        File file = new File("C:\\Users\\jwori\\GitHub\\Guess_The_Movie\\Guess_The_Movie\\src\\Movie_List"); // accesses movie list text file
        final RandomAccessFile movie_list = new RandomAccessFile(file, "r"); // creates a random access file stream to read from

        System.out.printf("Guess the movie!");
        System.out.printf("You have 10 guesses!");

        for (int i = 10; i >= 1; i--) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i); // DELETE LATER
            //if (letter != )
        }
    }
}
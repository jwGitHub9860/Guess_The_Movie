import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner; // need to use user input
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException { // if file CANNOT be opened
        // Access "Movie_List" file
        File file = new File("C:\\Users\\jwori\\GitHub\\Guess_The_Movie\\Guess_The_Movie\\src\\Movie_List"); // accesses movie list text file
        final RandomAccessFile movie_list = new RandomAccessFile(file, "r"); // creates a random access file stream to read from

        // Access Random Movie Name
        final long random_location = (long) (Math.random() * movie_list.length()); // chooses random movie name & "Math.random" creates floating point number between 0 & 1
        movie_list.seek(random_location); // finds random line location
        movie_list.readLine(); // reads random movie name (need because First line read does NOT have whole movie name)
        String random_name = movie_list.readLine(); // reads random movie name

        System.out.printf("Guess the movie!\nYou have 10 guesses!\n");

        while (random_name == null) { // chooses another random movie name if first random name is null
            movie_list.readLine(); // reads random movie name (need because First line read does NOT have whole movie name)
            random_name = movie_list.readLine(); // reads random movie name
        }

        String guess_word = random_name.replaceAll("[a-zA-Z]", "_"); // replace all letters with "_" & "[a-zA-Z]" represents ALL Uppercase and Lowercase letters

        Scanner scanner = new Scanner(System.in); // allows user input to be read
        boolean gameWon = false;

        for (int i = 10; i >= 1; i--) { // gives 10 guesses to guess movie name
            System.out.println("Guess a letter: ");

            // Takes Character as User Input
            String input = scanner.next(); // reads next token from input (MUST USE because there's NO "nextChar()")
            char letter_guess = input.charAt(0); // takes 1st character from User Input (MUST USE because there's NO "nextChar()")

            System.out.println("You have " + (i - 1) + " guesses left.");
            for (int j = 0; j < random_name.length(); j++) { // checks if "letter_guess" is in "random_name"
                if (random_name.charAt(j) == letter_guess) { // checks if "letter_guess" is CORRECT
                    guess_word = guess_word.substring(0, j) + letter_guess + guess_word.substring(j + 1); // replaces corresponding "_" with "letter_guess"
                }
            }
            System.out.printf(guess_word + "\n"); // displays correct guesses

            int countDash = 0; // amount of "_" in "guess_word"

            for (int m = 0; m < guess_word.length(); m++) { // checks if whole name has been guessed
                if (guess_word.charAt(m) == '_') { // counts amount of "_" in "guess_word"
                    countDash++;
                }
            }

            if (countDash == 0) { // checks if "guess_word" still has '_'
                gameWon = true;
            }

            if (gameWon) {
                System.out.println("You WON!!!!");
                break;
            }
        }
        if (!gameWon) {
            System.out.println("You Lost.\nThe movie name was: " + random_name);
        }
        movie_list.close(); // closes movie list file
    }
}
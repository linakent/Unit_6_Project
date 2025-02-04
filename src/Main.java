//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // step 1: create a file object
        File f = new File("src/input_file");
        PartOne partOne = new PartOne();

        String fileData = "";
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                fileData += currentLine + "\n";
            }

            // a String array where every item in the array is a line from the file
            String[] fileArray = fileData.split("\n");
            int [] handsTypeArray = partOne.countingHands(fileArray);
            System.out.println(partOne);
            PartTwo partTwo = new PartTwo(fileArray, handsTypeArray);
            System.out.println(partTwo);
            }
        catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }

    }
}
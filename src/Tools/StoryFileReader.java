package Tools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class StoryFileReader {
    private FileReader fileReader;
    private List<String> story;
    private Scanner scanner;


    public StoryFileReader(String file) {
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        scanner = new Scanner(fileReader);

        story = new LinkedList<>();

    }

    public List<String> readFile(){
        scanner.useDelimiter(" +");

        while(scanner.hasNext()) {

        story.add(scanner.next());
        }
        return story;
    }

    public List<String> getStory(){
        return story;
    }
}

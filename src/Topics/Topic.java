package Topics;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public abstract class Topic {
    private String title;
    private String[] words;
    private File file;
    private Scanner scanner;
    private StringBuilder story;
    private Random rand;

    public Topic(String[] words){
        this.words = words;
        rand = new Random();
    }

    public abstract void readFile();
    public abstract void createStory();
}

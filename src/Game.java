import Tools.GetWordList;
import Tools.StoryFileReader;

import java.util.*;

public class Game {
    private String playerName;
    private Scanner scanner;
    private List<String> story;
    private GetWordList getWordList;
    private Map<String, String> playerWords;
    private StoryFileReader storyFileReader;


    public Game() {
        scanner = new Scanner(System.in);

        //Linked list is used so the order remains the same as it was entered
        story = new LinkedList<>();
    }

    public void begin() {
        System.out.println("Welcome to Crazy Libs! \n");
        System.out.print("Please enter your name: ");
        playerName = scanner.nextLine();
        playOrEnd();
    }

    public void playOrEnd() {
        String playGame;
        System.out.print("\nWould you like to start a new game? Y/N: ");
        while (true) {
            playGame = scanner.nextLine();
            playGame = playGame.toLowerCase();
            if (playGame.equals("y") || playGame.equals("yes")) {
                pickTopic();
            } else if (playGame.equals("no") || playGame.equals("n")) {
                System.out.println("Thanks for playing!  Till next time!");
                System.exit(0);
            } else {
                System.out.print("I do not understand, please enter again: ");
            }
        }

    }

    public void pickTopic() {
        String pick;
        System.out.println("\nGreat, let's get started, " + playerName + "!");
        System.out.println("\nFirst, pick a topic: ");
        System.out.println("\t1. Fairy Tales");
        System.out.println("\t2. History");
        System.out.println("\t3. more to come");
        while (true) {
            pick = scanner.nextLine().toString();
            if (!pick.equals("1") && !pick.equals("2") && !pick.equals("3")) {
                System.out.println("Invalid choice, please try again.");
            }

            if (pick.equals("1")) {
                System.out.println("You picked fairy tales!\n");
                playGame("src/FairyTale.txt");

            }
        }
    }

    public void playGame(String storyChoice) {
        StringBuilder stringBuilder = new StringBuilder();
        int storyLength = 0;

        storyFileReader = new StoryFileReader(storyChoice);

        //method to read the selected story text file
        story = storyFileReader.readFile();

        //creates list of words in the file that the user will replace
        getWordList = new GetWordList(story);
        System.out.println("Type your words now!");

        //word list is displayed one at a time and player enters their own word which is stored in a linkedHashMap
        playerWords = getWordList.playerAddWords();

        //iterate through the linkedlist that contains the story and through the hashmap that contains the key(orginal
        //story word), and the value(the player entered word) and replace the story word with the player word value.
        for (int i = 0; i < story.size(); i++) {
            for (String word : playerWords.keySet()) {
                if (story.get(i).equals(word)) {
                    story.set(i, playerWords.get(word));
                }
            }
        }
        //create a stringbuilder using the updated story in the linkedlist
        for (int i = 0; i < story.size(); i++) {

            //add a line break to wrap the story
            if (storyLength + story.get(i).length() > 50) {
                stringBuilder.append(System.getProperty("line.separator"));
                storyLength = 0;
            }

            //corrects spacing for words that should have puncuation
            try {
                if (story.get(i + 1).equals(",") || story.get(i + 1).equals("'s") || story.get(i + 1).equals(".")) {
                    stringBuilder.append(story.get(i));
                    storyLength += story.get(i).length();
                } else {
                    stringBuilder.append(story.get(i) + " ");
                    storyLength += story.get(i).length();
                }
            } catch (Exception e) {

            }
        }
        //TODO save stringBuilder to an list so the user can read it again if they want
        //print the story with the players words
        System.out.println("\n" + stringBuilder + "\n");

        playOrEnd();
    }
}

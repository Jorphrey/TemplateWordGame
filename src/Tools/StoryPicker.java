package Tools;


import java.util.Random;

//TODO Make Singleton? I think i only need one of these
public class StoryPicker {

    private String genre;
    private String[] FairyTale;
    private String[] History;
    //TODO add more genre arrays
    private Random rand;

    public StoryPicker(String genre){
        this.genre = genre;
        rand = new Random();

    }

    public String getStory(){
        //TODO return random String from the genre array selected by the used
        return null;
    }

}

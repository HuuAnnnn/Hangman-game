import java.util.*;
import java.io.*;

public class HangManMaterial {
	private ArrayList<String> dict = new ArrayList<String>();
	public HangManMaterial() {
		try {
			FileReader read = new FileReader("./HMDictionary.dict");
			BufferedReader bReader = new BufferedReader(read);
			String data = "";
			while((data = bReader.readLine()) != null) {
				String[] splt = data.split(",");
				for(int i = 0;i<splt.length;i++) {
					dict.add(splt[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getRandomWord() {
		Random generator = new Random();
		return dict.get(generator.nextInt(dict.size()));
	}

	public String getStage(int index) { return HANGMANPICS[index]; }
	public String getGameOverState() { return gameOver; }
	public String getGameWinState() { return gameWin; }
	public String getWelcome() { return welcome; }

    private String[] HANGMANPICS = {
		"  +---+ \n"+
		"  |   | \n"+
		"  | \n"+
		"  | \n"+
		"  | \n"+
		"  | \n"+
		"========= \n",

		"  +---+ \n"+
		"  |   | \n"+
		"  |   O \n"+
		"  | \n"+
		"  | \n"+
		"  | \n"+
		"========= \n",            
		"  +---+ \n"+
		"  |   | \n"+
		"  |   O \n"+
		"  |   | \n"+
		"  | \n"+
		"  | \n"+
		"========= \n",

		"  +---+ \n"+
		"  |   | \n"+
		"  |   O \n"+
		"  |  /| \n"+
		"  | \n"+
		"  | \n"+
		"========= \n",

		"  +---+ \n"+
		"  |   | \n"+
		"  |   O \n"+
		"  |  /|\\ \n"+
		"  | \n"+
		"  | \n"+
		"========= \n",

		"  +---+ \n"+
		"  |   | \n"+
		"  |   O \n"+
		"  |  /|\\ \n"+
		"  |  / \n"+
		"  | \n"+
		"========= \n",

		"  +---+ \n"+
		"  |   | \n"+
		"  |   O \n"+
		"  |  /|\\ \n"+
		"  |  / \\ \n"+
		"  | \n"+
		"========= \n"
    };

	private String welcome = "|__|  /\\  |\\ | / _`  |\\/|  /\\  |\\ | \n"+
                             "|  | /~~\\ | \\| \\__>  |  | /~~\\ | \\| \n";

	private String gameOver = 
	"   ___                         ___                 \n"+
	"  / _ \\__ _ _ __ ___   ___    /___\\__   _____ _ __ \n"+
	" / /_\\/ _` | '_ ` _ \\ / _ \\  //  //\\ \\ / / _ \\ '__|\n"+
	"/ /_\\\\ (_| | | | | | |  __/ / \\_//  \\ V /  __/ |   \n"+
	"\\____/\\__,_|_| |_| |_|\\___| \\___/    \\_/ \\___|_|   \n";
                                                   



	private String gameWin = 
	"   ___                            _         _       _   _             \n"+
	"  / __\\___  _ __   __ _ _ __ __ _| |_ _   _| | __ _| |_(_) ___  _ __   \n"+
	" / /  / _ \\| '_ \\ / _` | '__/ _` | __| | | | |/ _` | __| |/ _ \\| '_ \\  \n"+
	"/ /__| (_) | | | | (_| | | | (_| | |_| |_| | | (_| | |_| | (_) | | | | \n"+
	"\\____/\\___/|_| |_|\\__, |_|  \\__,_|\\__|\\__,_|_|\\__,_|\\__|_|\\___/|_| |_| \n"+
	"                  |___/                                                \n";

}
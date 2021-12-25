import java.util.Scanner;
import java.io.*;

public class Main {
    private static HangManMaterial material = new HangManMaterial();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = "";
        boolean cont = true;

        welcomeScreen();
        System.out.print("Enter your name: ");
        username = sc.nextLine();
        
        clear();
        while(cont) {
            System.out.println("Start!");
            session(username);

            System.out.print("Do you want continue (Y/n): ");
            String ans = sc.next();
            if(ans.toLowerCase().equals("n")) {
                cont = false;
            }

            clear();
        }
    }

    public static void session(String username) {
        Scanner sc = new Scanner(System.in);
        String wordGuess = material.getRandomWord();
        String userGuess = "";
        int wordLength = wordGuess.length();
        String space = generateSpace(wordLength);
        int wrongCase = 1;
        boolean winState = true;
        int state = 0;
        
        while(true) {
            System.out.println(material.getStage(state));
            System.out.println("Word: "+ space);
            System.out.println(wordRate(wordGuess));
            System.out.print("Enter letter: ");
            userGuess = sc.next();

            if(wrongCase == 1) {
                System.out.println(material.getStage(0));
            }
            clear();

            //if player guesses the letter right, we replace all space by this letter
            if(wordGuess.contains(userGuess)) {
                for(int i = 0;i<wordGuess.length();i++) {
                    if(userGuess.equals(wordGuess.substring(i, i+1))) {
                        space = space.substring(0, i) + userGuess +space.substring(i+1);
                    }
                }

            } else {
                state = wrongCase++;
            }

            //players have 6 times to guess wrong.
            if(wrongCase == 7) {
                winState = false;
                break;
            }

            if(space.equals(wordGuess)) {
                break;
            }
        }

        if(winState) {
            System.out.println(material.getGameWinState() + username + "! You win");
        } else {
            System.out.println(material.getStage(state));
            System.out.println(material.getGameOverState());
        }

        System.out.println("\nAnswer: "+wordGuess);
    }

    public static String wordRate(String wordGuess) {
        int max = 0;
        String tmp = wordGuess;
        char ch = ' ';
        char letter = ' ';
        int count = 0;

        for(int i = 0;i<tmp.length();i++) {
            ch = tmp.charAt(i);
            count = countCharInString(ch, wordGuess);
            if(count > max) {
                max = count;
                letter = ch;
            }

            tmp = tmp.replace(ch+"", " ");
        }

        return "Letter: "+letter + " appear " + Math.ceil(max*100.0/wordGuess.length()) + "%";
    }

    public static int countCharInString(char ch, String str) {
        int count = 0;
        for(int i = 0;i<str.length();i++) {
            if(str.charAt(i) == ch) {
                count++;
            }
        }

        return count;
    }

    public static void welcomeScreen() {
        clear();
        System.out.println(material.getWelcome());
    }

    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
         } catch (IOException | InterruptedException ex) {}
    }
    public static String generateSpace(int n) {
        String space = "";
        for(int i = 0;i<n;i++) { space += "_"; }

        return space;
    }
}
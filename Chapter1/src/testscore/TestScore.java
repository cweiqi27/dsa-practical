package testscore;

import java.util.*;

public class TestScore {
    private final List<Integer> scoreList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    private void mainMenu() {
        try {
            System.out.println("===========");
            System.out.println("Test Scores");
            System.out.println("===========");
            System.out.println("(1) Add score");
            System.out.println("(2) Display all score");
            System.out.println("(3) Display lowest score");
            System.out.println("(4) Display highest score");
            System.out.println("(5) Display average score");
            System.out.println("(6) Exit \n");

            System.out.println("Enter number 1-5 to choose an option: ");

            int choice = input.nextInt();

            switch(choice) {
                case 1 -> addScore();
                case 2 -> displayScore(0);
                case 3 -> displayScore(1);
                case 4 -> displayScore(2);
                case 5 -> displayScore(3);
                case 6 -> System.exit(0);
                default -> {
                    System.out.println("Invalid input.\n");
                    mainMenu();
                }
            }
        } catch(Exception e) {
            System.out.println("Invalid Input.\n");
            continuePrompt();
        }
    }

    private void addScore() {
        System.out.println("Enter test score:");

        try {
            int testScore = input.nextInt();

            while(testScore < 0 || testScore > 100) {
                System.out.println("Test score out of bounds, please enter a number between 1 to 100: ");
                testScore = input.nextInt();
            }

            scoreList.add(testScore);
        } catch(NumberFormatException e) {
            System.out.println("Invalid number");
        }

        System.out.println("Test score added successfully. \n");

        continuePrompt();
    }

    private void displayScore(int option) {
        if(scoreList.isEmpty()) isEmptyMessage();

        System.out.println("Test Scores:");

        for(int score : scoreList) {
            System.out.println(score);
        }

        if(option == 1) {
            System.out.println("Lowest score:" + findLowestScore());
            continuePrompt();
        }
        else if(option == 2) {
            System.out.println("Highest score:" + findHighestScore());
            continuePrompt();
        }
        else if(option == 3) {
            System.out.println("Average score:" + findAverageScore());
            continuePrompt();
        }
        else {
            continuePrompt();
        }
    }

    private int findLowestScore() {
        if(scoreList.isEmpty()) isEmptyMessage();

//        Using Collections.sort
        List<Integer> sortedScoreList = new ArrayList<>(scoreList);
        Collections.sort(sortedScoreList);
        return sortedScoreList.get(0);
    }

    private int findHighestScore() {
        if(scoreList.isEmpty()) isEmptyMessage();

        List<Integer> sortedScoreList = new ArrayList<>(scoreList);
        Collections.sort(sortedScoreList);
        return sortedScoreList.get(sortedScoreList.size() - 1);
    }

    private int findAverageScore() {
        if(scoreList.isEmpty()) isEmptyMessage();

        int sum = 0;

        for(int score : scoreList) {
            sum += score;
        }

        return sum / scoreList.size();
    }

    private void isEmptyMessage() {
        System.out.println("!!!");
        System.out.println("No score has been entered yet \n");

        continuePrompt();
    }

    private void continuePrompt() {
        System.out.println("***");
        System.out.println("Enter any value to continue: ");
        input.next();
        mainMenu();
    }

    public static void main(String[] args) {
        TestScore testScores = new TestScore();
        testScores.mainMenu();
    }

}

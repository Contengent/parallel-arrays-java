// I don't know why I named it that, but whatever.               ;/\/\/\/\;
// I need to put all of these on github so I can build my resume :\/\/\/\/:
// walao walao walao walao walao walao walao walao walao walao   :/\/\/\/\:

package thisisnotthathard.project;

import java.util.Scanner;

/**
 *
 * @author Edelstein
 */

public class ThisIsNotThatHardProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // initializing the parallel arrays
        String teams[] = 
            {
                "Boston Celtics",     // 0
                "Brooklyn Nets",      // 1
                "New York Knicks",    // 2
                "Philadelphia 76ers", // 3
                "Toronto Raptors"     // 4
            };
        
        int wins[] = 
        {
            20,    // 0
            25,    // 1
            16,    // 2
            23,    // 3
            34     // 4
        };
        
        int losses[] =
        {
            30,    // 0
            25,    // 1
            34,    // 2
            27,    // 3
            16,    // 4
        };
        
        // variables that are used to communicate between methods
        int userChoice;
        String teamData[];
        
        // methods put in order
        userChoice = menuToChoice(teams);
        teamData = teamToArray(teams[userChoice], wins[userChoice], losses[userChoice]);
        statsCalculationToOutput(teamData);
        
        System.out.println("walao this was way easier then the last two projects :]");
    }
    
    private static int menuToChoice(String team[]){
        Scanner input = new Scanner(System.in);
        int choice = 0; // java is the worst man.
        boolean shouldPass;
        
        // print menu message
        System.out.println("Select a team you would like to see the win-loss ratio of:");
            
        // loop for outputting all the teams
        for(int i = 0; i < team.length; i++){
            System.out.println("[" + i + "] " + team[i]);
        }
        
        // while loop for catching mistakes and repeating :l
        do{
            // accepting user input
            try{ // to catch incorrect inputs
                choice = input.nextInt(); // I have absolutly no idea what is wrong with this line, but it never allows itself to be used twice, so I give up trying to fix this try... catch statement.
                shouldPass = true;
                
                // to check if choice is inside the index of 'team' array
                try{
                    System.out.println(team[choice]);
                } catch(Exception e){
                    System.out.println("Error: Choice outside of array index");
                    System.out.println("Exiting...");
                    System.exit(0); // Exits program bc screw Scanner
                }
            
            // basically the catch function directly above
            } catch(Exception e){
                System.out.println("Error: Invalid character"); 
                shouldPass = false;
                
                System.out.println("Exiting...");
                System.exit(0);
            }
            
        } while(!shouldPass && choice < team.length);
        
        // simple output of choice
        System.out.println("You have selected: " + team[choice] + "!");
        
        return choice; // return so can be used in global var
    }
    
    private static String[] teamToArray(String team, int wins, int losses){
        String teamStats[] =  new String[3];
        
        teamStats[0] = team;
        teamStats[1] = String.valueOf(wins);
        teamStats[2] = String.valueOf(losses);
        
        // it'd be hard to automate this and use a loop, so I'ma just do it like dis :]
        // this is an asic LOL
        
        return teamStats;
    }
    
    private static void statsCalculationToOutput(String teamStats[]){
        System.out.println("\nCalculating..."); // to assure the user that the program IS, infact, calculating.
        
        final double WINS = Double.parseDouble(teamStats[1]);   // assigning the 'win' index of 'teamStats' array
        final double LOSSES = Double.parseDouble(teamStats[2]); // assigning the 'losses' index of 'teamStats' array
        
        final String TEAM_NAME = teamStats[0]; // just setting the team name to a final variable
        final double WIN_PERCENT  = (WINS / (WINS + LOSSES)) * 100; // % of wins is: (wins / (wins + losses)) * 100
        final double LOSS_PERCENT = (LOSSES / (WINS + LOSSES)) * 100; // % of losses is: (losses / (wins + losses)) * 100
        final double WIN_TO_LOSS_RATIO[] = {WINS/WINS, LOSSES/WINS}; // ratio is wins/wins:losses/wins
        
        // simply outputting all the calculated data
        System.out.println("Calculation complete!\n");
        System.out.println("The stats for " + TEAM_NAME + " are as follows:");
        System.out.println("    Win percentage: " + WIN_PERCENT);
        System.out.println("    Loss percentage: " + LOSS_PERCENT);
        System.out.println("    wins:losses ratio: " + WIN_TO_LOSS_RATIO[0] + ":" + WIN_TO_LOSS_RATIO[1]);
        System.out.println("This program has come to it's end!");
        System.out.println("*incohearent screaming*");
    }
}

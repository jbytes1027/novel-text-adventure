// James Pretoirus
import java.util.Scanner;

public class Adventure {
    public static boolean hasArmour = false;
    public static boolean hasContract = false;
    public static int drinkCount = 0;

    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);

        giveStory("WELCOME TO A SHORT TEXT ADVENTURE.\n" + "Let's start at the beginning...\n");

        giveStory("It's been a long journey, even for a hunter.\n"
                + "It looks like its going to rain.\n"
                + "You see a cave that could serve as a shelter or there's an inn up ahead.");

        // inn
        if (getChoice(keyboardScanner, "Where to?", "Inn", "Cave").equalsIgnoreCase("Inn")) {
            giveStory("The inn is quiet, almost empty.\n"
                    + "You walk up to the to innkeeper tending the bar");

            while (!hasContract) {
                String choice = getChoice(keyboardScanner,
                        "\"What will it be for ya?\" the innkeeper asks.", "Ale", "News", "Room");

                if (choice.equalsIgnoreCase("Ale")) {
                    drinkCount++;
                    if (drinkCount == 2) {
                        giveStory("You gulp down another pint of ale.\nYou don't feel so good.\n"
                                + "\"You look like you've had your fill\", the innkeeper remarks.");
                    } else if (drinkCount == 3) {
                        giveStory("...Thonk.");
                        endStory();
                    } else {
                        giveStory("You gulp down a pint of ale.\nYou feel much better.");
                    }
                } else if (choice.equalsIgnoreCase("News")) {
                    giveStory(
                            "\"There's a bounty on a wherewolf, might intrest a hunter like you.\"\n"
                                    + "\"Made a den out of that cave you'd 'ave passed comming here.\"\n"
                                    + "\"You best watch your step 'round there, that place is booby-traped.\"\n"
                                    + "\"Used to be a hideout for gangs 'n ruffians.\"\n"
                                    + "\"But i'm not sure what what that wolf did to anyone, tis been awhile since anythings bothered us.\"\n"
                                    + "\"If you want the contract talk to the blacksmith with the grey beard.\"");

                    if (getChoice(keyboardScanner, "Pursue the contract?", "Yes", "No")
                            .equalsIgnoreCase("Yes")) {
                        if (drinkCount == 2) {
                            giveStory("You stumble over to blacksmith sitting by himself.");
                        } else {
                            giveStory("You walk over to blacksmith sitting by himself.");
                        }
                        giveStory("\"What do you want?\" the blacksmith says accusingly.\n"
                                + "\"Heard about a contract on a wherewolf\" you reply.\n"
                                + "\"Fruit, she was picking fruit, that beast slaughtered my daughter!\"\n"
                                + "\"I'll give you 300 for its head.\"\n"
                                + "\"I'll take it,\" you affirm.\n"
                                + "\"Then you best get somethin' better then that leather.\"\n"
                                + "\"I've a rusty armour set you can use, and the strongest blades 'round here',\" the blacksmith offered.");
                        if (getChoice(keyboardScanner, "Change gear?", "Yes", "No")
                                .equalsIgnoreCase("Yes")) {
                            hasArmour = true;
                        } else {
                            giveStory(
                                    "\"Then at least take some silver arrows,\" he said gesturing to a nearby quiver.\n"
                                            + "\"They 'll turn that thing human, make it an easy target.\"\n"
                                            + "You take the arrows.");
                        }
                        hasContract = true;

                        if (drinkCount > 0 && !hasArmour) {
                            giveStory(
                                    "\"Best of luck to ya\", the blacksmith calls on your way out.");
                        } else {
                            giveStory(
                                    "\"Give me his head!\", the blacksmith calls on your way out.");
                        }
                    }
                } else if (choice.equalsIgnoreCase("Room")) {
                    if (drinkCount == 2) {
                        giveStory(
                                "\"Take the second one to your right up the stair,\" the innkeeper says.\n"
                                        + "You stumble up the stairs.\n"
                                        + "The next morning you have a headache and feel groggy.\n"
                                        + "You don't feel ready for the journey ahead.");
                        endStory();
                    } else {
                        giveStory(
                                "\"Take the second one to your right up the stair,\" the innkeeper says.\n"
                                        + "You awaken the next morning refreshed and ready for the road ahead.");
                        endStory();
                    }
                }
            }
        }

        // cave
        if (drinkCount == 2) {
            giveStory("You stumble over to the cave.\n" + "You stumble over the tripwire.\n"
                    + "You get torn apart.");
            endStory();
        } else if (hasContract) {
            if (hasArmour) {
                giveStory("You make your way to the cave.\n" + "You draw your sword.\n"
                        + "Inside you see a dim glow of a fire.\n"
                        + "There thirty paces ahead is the wherewolf with its back turned to you eating what looks like the remains of a sheep.\n"
                        + "Infront of you blocking your way you see a line of tripwires a foot high.");

                if (getChoice(keyboardScanner, "Jump over them or cut through them?", "Jump", "Cut")
                        .equalsIgnoreCase("Jump")) {
                    giveStory(
                            "You don't jump high enough because of all your armour and trip over the wires.\n"
                                    + "A multitude of glass bottles to fall and shatter on the floor.\n"
                                    + "It was an alarm.\n"
                                    + "The wherewolf whips around.\nIt howls and comes tearing at you.\n"
                                    + "You dropped your blade when you hit the ground.\n"
                                    + "You struggle to get up quickly with all your armour on.\n"
                                    + "The wherewolf leaps onto you and pins you down.\n"
                                    + "It tears you apart like bread.");
                    endStory();
                } else {
                    giveStory(
                            "You cut throught the tripwires causing a multitude of glass bottles to fall and shatter on the floor.\n"
                                    + "It was an alarm.\n"
                                    + "The wherewolf whips around.\nIt howls and comes tearing at you.\n"
                                    + "You brace yourself pointing your blade definitely towards the beast ready to thrust.\n"
                                    + "The wherewolf leaps at you.\n"
                                    + "You plunge your blade deep into its neck.\nIts dead.");
                    endStory();
                }
            } else { // no sword or armour
                giveStory("You make your way to the cave.\n"
                        + "Inside you see a dim glow of a fire.\n"
                        + "There thirty paces ahead is the wherewolf with its back turned to you eating what looks like the remains of a sheep.\n"
                        + "Infront of you blocking your way you see a line of tripwires a foot high.\n"
                        + "You leap over them, quietly making your way foreward.\n"
                        + "You draw your bow back and take aim at the beasts.");
                if (getChoice(keyboardScanner, "Cripple or kill it", "Cripple", "Kill")
                        .equalsIgnoreCase("Kill")) {
                    // kill see morph back to human
                    giveStory(
                            "The arrow pierces through the back of the wherewolf's head, poking out throught its ear on the opposite side.\n"
                                    + "The beast sways for a second then slumps on its side.\n"
                                    + "Its dead.");
                    endStory();
                } else {
                    giveStory("The arrow pierces through the wherewolf's leg.\n"
                            + "It writhes around trying to stand.\n"
                            + "The wherewolf morphs into young man.\n"
                            + "You stand over him, bow drawn.\n"
                            + "\"Please, i couldn't control myself,\" he begs.");
                    if (getChoice(keyboardScanner, "Kill or spare him?", "Kill", "Spare")
                            .equalsIgnoreCase("Kill")) {
                        giveStory("Thonk.");
                        endStory();
                    } else {
                        giveStory(
                                "You step back.\n\"You must run from these parts and never return,\" you assert.\n"
                                        + "\"You won't hear of me again,\" he insists.\n"
                                        + "You help him tend to his wound.");
                        endStory();
                    }
                }
            }
        } else { // go in blind
            giveStory("You enter the cave, you see a dim light deeper inside.");
            if (getChoice(keyboardScanner, "Investigate?", "Yes", "No").equalsIgnoreCase("yes")) {
                giveStory("You venture deeper into the cave and trip over something.\n"
                        + "A multitude of glass bottles fall and shatter on the floor.\nA howl comes from deeper inside the cave.");
                if (getChoice(keyboardScanner, "Stay or flee?", "Stay", "Flee")
                        .equalsIgnoreCase("Stay")) {
                    giveStory(
                            "You pick yourself up and frantically draw your bow.\nA wherewolf comes tearing at you.\n"
                                    + "Your arrow pierces its chest, it hardly flinches.\n"
                                    + "The wherewolf leaps onto you and pins you down.\n"
                                    + "It tears you apart like bread.");
                    endStory();
                } else {
                    giveStory(
                            "You turn and run but are quickly overtaken by a four-legged beast.\nYou are torn apart like bread.");
                    endStory();
                }
            } else {
                giveStory(
                        "You sleep just inside the cave.\nYou wakeup with the sun and continue on your journey.");
                endStory();
            }
        }
        giveStory("ERROR YOU DONT BELONG HERE");
    }

    public static void giveStory(String story) {
        // for (int i = 100; i > 0; i--) {
        // System.out.println("\n");
        // }
        System.out.println(story);
    }

    public static void endStory() {
        System.out.println("The end.");
        System.exit(0);
    }

    public static String getChoice(Scanner keyboardScanner, String message, String... choices) {
        String choice = "";
        boolean isValidChoice = false;

        while (!isValidChoice) {
            System.out.print(message + " [");
            for (int i = 0; i < choices.length; i++) {
                System.out.print(choices[i]);

                if (i != choices.length - 1) {
                    System.out.print("/");
                } else {
                    System.out.print("] ");
                }
            }

            choice = keyboardScanner.nextLine().trim();
            for (int i = 0; i < choices.length; i++) {
                if (choice.equalsIgnoreCase(choices[i])) {
                    isValidChoice = true;
                }
            }
            if (!isValidChoice) {
                System.out.println("Not a valid option!\n");
            } else {
                for (int i = 100; i > 0; i--) {
                    System.out.println("\n");
                }
            }
        }
        return choice;
    }
}

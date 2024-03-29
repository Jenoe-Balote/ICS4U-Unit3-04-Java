/*
 * This program pushes and prints a stack.
 *
 * @author  Jenoe Balote
 * @version 1.0
 * @since   2021-12-14
 */

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * This program demonstrates a stack.
 * */
final class StackExample {

    /**
     * Prevents instantiation.
     * Throw an exception IllegalStateException when called.
     *
     * @throws IllegalStateException
     *
     */
    private StackExample() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * Creates an instance of MrCoxallStack and uses its methods.
     *
     * @param args No args will be used.
     */
    public static void main(final String[] args) {

        // Input
        final MrCoxallStack<Integer> aStack = new MrCoxallStack<Integer>();
        final String[] allowedCommands =
            {"push", "pop", "show", "peek", "clear", "exit"};
        final Scanner scanner = new Scanner(System.in);

        final String userCommand;
        String userInput;
        String[] userCommandArray;

        final int indexZero = 0;
        final int indexOne = 1;
        final int indexTwo = 2;
        final int indexThree = 3;
        final int indexFour = 4;
        final int indexFive = 5;

        System.out.println("Acceptable Commands:\n"
                + "push <number> - pop - show - peek - clear - exit");

        while (true) {
            try {
                System.out.print("> ");
                userInput = scanner.next();

                // Commands based off of the user input
                if (userInput.startsWith(allowedCommands[indexZero])) {
                    userCommandArray = scanner.nextLine().split(" ");
                    aStack.push(Integer.parseInt(userCommandArray[indexOne]));
                } else if (userInput.startsWith(allowedCommands[indexOne])) {
                    System.out.println("Removed: " + aStack.pop());
                } else if (userInput.startsWith(allowedCommands[indexTwo])) {
                    aStack.showStack();
                } else if (userInput.startsWith(allowedCommands[indexThree])) {
                    System.out.println(aStack.peek());
                } else if (userInput.startsWith(allowedCommands[indexFour])) {
                    aStack.clear();
                } else if (userInput.startsWith(allowedCommands[indexFive])) {
                    break;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (ArrayIndexOutOfBoundsException
                    | IllegalArgumentException exception) {
                System.out.println("Please enter a valid command.");
            } catch (EmptyStackException exception) {
                System.out.println("The stack is empty.");
            }
        }

        System.out.println("\nDone.");
    }
}


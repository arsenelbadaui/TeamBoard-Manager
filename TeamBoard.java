import java.util.Scanner;

public class TeamBoard {
    public static void main(String[] args) {
        String[] noticeboard = new String[10];
        int noticeCount = 0;
        
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 9) {
            System.out.println("\n(1) Post new notice");
            System.out.println("(2) Print all notices");
            System.out.println("(3) Print all notices in reverse order");
            System.out.println("(4) Print number of notices posted so far");
            System.out.println("(5) Search for a captain's name and print all notices they have posted");
            System.out.println("(6) Print the total number of digits across all notices");
            System.out.println("(7) Perform a search of notices containing a given word (case sensitive)");
            System.out.println("(8) Perform a search of notices containing a given word (case insensitive)");
            System.out.println("(9) End Program");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    if (noticeCount >= noticeboard.length) {
                        System.out.println("Error: The noticeboard is full! Cannot post new notice.");
                    } else {
                        System.out.print("Enter captain's name: ");
                        String captainName = scanner.nextLine().trim();
                        System.out.print("Enter notice message: ");
                        String message = scanner.nextLine().trim();

                        noticeboard[noticeCount] = captainName + " posts: " + message;
                        noticeCount++;
                        System.out.println("Notice successfully posted.");
                    }
                    break;

                case 2:
                    if (noticeCount == 0) {
                        System.out.println("No notices posted yet.");
                    } else {
                        System.out.println("--- All Notices ---");
                        for (int i = 0; i < noticeCount; i++) {
                            System.out.println((i + 1) + ". " + noticeboard[i]);
                        }
                    }
                    break;

                case 3:
                    if (noticeCount == 0) {
                        System.out.println("No notices posted yet.");
                    } else {
                        System.out.println("--- Notices in Reverse Order ---");
                        for (int i = noticeCount - 1; i >= 0; i--) {
                            System.out.println((i + 1) + ". " + noticeboard[i]);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Total notices posted: " + noticeCount + " / 10");
                    break;

                case 5:
                    System.out.print("Enter captain's name to search: ");
                    String searchCaptain = scanner.nextLine().trim().toLowerCase();
                    boolean foundCaptain = false;

                    System.out.println("--- Notices by Captain: " + searchCaptain + " ---");
                    for (int i = 0; i < noticeCount; i++) {
                        int index = noticeboard[i].indexOf(" posts: ");
                        if (index != -1) {
                            String storedCaptain = noticeboard[i].substring(0, index).toLowerCase();
                            if (storedCaptain.equals(searchCaptain)) {
                                System.out.println(noticeboard[i]);
                                foundCaptain = true;
                            }
                        }
                    }
                    if (!foundCaptain) {
                        System.out.println("No notices found for this captain.");
                    }
                    break;

                case 6:
                    int totalDigits = 0;
                    for (int i = 0; i < noticeCount; i++) {
                        int index = noticeboard[i].indexOf(" posts: ");
                        if (index != -1) {
                            String content = noticeboard[i].substring(index + 8);
                            for (int j = 0; j < content.length(); j++) {
                                char c = content.charAt(j);
                                if (c >= '0' && c <= '9') {
                                    totalDigits++;
                                }
                            }
                        }
                    }
                    System.out.println("Total digit characters in notice contents: " + totalDigits);
                    break;

                case 7:
                    System.out.print("Enter word to search (case sensitive): ");
                    String searchWordCS = scanner.nextLine();
                    boolean foundCS = false;

                    System.out.println("--- Search Results (Case Sensitive) ---");
                    for (int i = 0; i < noticeCount; i++) {
                        if (noticeboard[i].contains(searchWordCS)) {
                            System.out.println(noticeboard[i]);
                            foundCS = true;
                        }
                    }
                    if (!foundCS) {
                        System.out.println("No matching notices found.");
                    }
                    break;

                case 8:
                    System.out.print("Enter word to search (case insensitive): ");
                    String searchWordCI = scanner.nextLine().toLowerCase();
                    boolean foundCI = false;

                    System.out.println("--- Search Results (Case Insensitive) ---");
                    for (int i = 0; i < noticeCount; i++) {
                        if (noticeboard[i].toLowerCase().contains(searchWordCI)) {
                            System.out.println(noticeboard[i]);
                            foundCI = true;
                        }
                    }
                    if (!foundCI) {
                        System.out.println("No matching notices found.");
                    }
                    break;

                case 9:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 9.");
                    break;
            }
        }
        scanner.close();
    }
}
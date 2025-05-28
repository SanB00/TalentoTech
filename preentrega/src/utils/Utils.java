package utils;

public class Utils {
    public static void clearScreen() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } else {
                System.out.println("Operating system not supported for clearing console.");
            }
        } catch (Exception e) {
            System.err.println("Error clearing console: " + e.getMessage());
        }
    }
}

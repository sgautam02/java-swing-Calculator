import java.util.ArrayList;

class CalculatorHistory {
    private static ArrayList<String> history = new ArrayList<>();

    public static void addHistoryEntry(String entry) {
        history.add(entry);
    }

    public static ArrayList<String> getHistory() {
        return history;
    }
}